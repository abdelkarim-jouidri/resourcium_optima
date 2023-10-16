package com.example.resourcium_optima_ii;

import com.example.resourcium_optima_ii.DAO.ProductDao;
import com.example.resourcium_optima_ii.DAO.UserDao;
import com.example.resourcium_optima_ii.Model.Product;
import com.example.resourcium_optima_ii.Model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("resourcium_optima");

        User user = new User("abdelkrim","jouidri", "abc");
        UserDao userDao = new UserDao(emf);
        userDao.save(user);
    }
}
