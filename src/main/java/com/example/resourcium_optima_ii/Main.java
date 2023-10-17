package com.example.resourcium_optima_ii;

import com.example.resourcium_optima_ii.DAO.UserDao;
import com.example.resourcium_optima_ii.Model.User;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("resourcium_optima");

        User user = new User("abdelkrim","jouidri", "abc");
        UserDao userDao = new UserDao(emf);
        userDao.save(user);
    }
}
