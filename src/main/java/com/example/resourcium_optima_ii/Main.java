package com.example.resourcium_optima_ii;

import com.example.resourcium_optima_ii.Model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("resourcium_optima");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        User user = new User("abdelkrim","jouidri", "pa$$word");
        em.persist(user);
        transaction.commit();
    }
}
