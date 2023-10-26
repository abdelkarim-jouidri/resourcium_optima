package com.example.resourcium_optima_ii.DAO;

import com.example.resourcium_optima_ii.Model.Department;
import com.example.resourcium_optima_ii.Model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class DepartmentDao {
    private final EntityManagerFactory entityManagerFactory;

    public DepartmentDao() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("resourcium_optima");
    }

    public List<Department> getAllDepartments(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            List<Department> departments = entityManager.createQuery("SELECT d FROM Department d", Department.class).getResultList();
            transaction.commit();
            return departments;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
    }

    public boolean save(Department department) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(department);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error saving department: " + e.getMessage(), e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public Department getDepartmentByID(int ID){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        return entityManager.find(Department.class, ID);
    }


}
