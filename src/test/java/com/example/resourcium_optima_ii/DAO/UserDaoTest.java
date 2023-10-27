package com.example.resourcium_optima_ii.DAO;

import com.example.resourcium_optima_ii.Model.User;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    private UserDao userDao = new UserDao(Persistence.createEntityManagerFactory("resourcium_optima"));

//    @BeforeAll
//    static void setUpClass(){
//        entityManagerFactory = Persistence.createEntityManagerFactory("resourcium_optima");
//        userDao = new UserDao(entityManagerFactory);
//    }

//    @AfterAll
//    static void tearDownClass(){
//        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
//            entityManagerFactory.close();
//        }
//    }

    @Test
    void save() {
    }

    @Test
    void getUserByEmail() {
    }

    @Test
    void userByEmailDoesntExistsTest() {
        //given
        String email = "abdelkarimjouidri@gmail.com";
        //when
        boolean result = userDao.userByEmailExists(email);
        System.out.println(result);
        //then
        assertFalse(result);
    }
}