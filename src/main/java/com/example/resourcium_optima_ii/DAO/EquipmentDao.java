package com.example.resourcium_optima_ii.DAO;

import com.example.resourcium_optima_ii.Model.Employee;
import com.example.resourcium_optima_ii.Model.Equipment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class EquipmentDao {
    private EntityManagerFactory entityManagerFactory;

    public EquipmentDao() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("resourcium_optima");
    }

    public List<Equipment> getAllEquipments(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            List<Equipment> equipments = entityManager.createQuery("SELECT e FROM Equipment e", Equipment.class).getResultList();
            transaction.commit();
            return equipments;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
    }

    public boolean save(Equipment equipment) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(equipment);
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

}
