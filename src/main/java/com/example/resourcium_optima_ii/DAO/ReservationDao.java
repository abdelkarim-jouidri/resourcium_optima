package com.example.resourcium_optima_ii.DAO;

import com.example.resourcium_optima_ii.Model.Equipment;
import com.example.resourcium_optima_ii.Model.Reservation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class ReservationDao {
    private final EntityManagerFactory entityManagerFactory;

    public ReservationDao() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("resourcium_optima");
    }

    public List<Reservation> getAllReservations(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            List<Reservation> reservations = entityManager.createQuery("SELECT r FROM Reservation r", Reservation.class).getResultList();
            transaction.commit();
            return reservations;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
    }

    public boolean save(Reservation reservation) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(reservation);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error saving reservation: " + e.getMessage(), e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
