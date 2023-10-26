package com.example.resourcium_optima_ii.DAO;

import com.example.resourcium_optima_ii.Model.Department;
import com.example.resourcium_optima_ii.Model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class EmployeeDao {
    private final EntityManagerFactory entityManagerFactory;

    public EmployeeDao() {

        this.entityManagerFactory = Persistence.createEntityManagerFactory("resourcium_optima");
    }

    public List<Employee> getAllEmployees() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
            transaction.commit();
            return employees;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
    }

    public boolean save(Employee employee) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(employee);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error saving employee: " + e.getMessage(), e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public boolean delete(Employee employee) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            // Load the employee into the persistence context
            Employee managedEmployee = entityManager.find(Employee.class, employee.getId());
            if (managedEmployee != null) {
                entityManager.remove(managedEmployee);
                transaction.commit();
                return true;
            } else {
                throw new RuntimeException("Employee not found for deletion");
            }
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error saving employee: " + e.getMessage(), e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public Employee getEmployeeById(int ID){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Employee employee = entityManager.find(Employee.class, ID);
        return employee;
    }

}
