package com.example.resourcium_optima_ii;

import com.example.resourcium_optima_ii.DAO.EmployeeDao;
import com.example.resourcium_optima_ii.Model.Department;
import com.example.resourcium_optima_ii.Model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("resourcium_optima");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Department department = entityManager.find(Department.class, 1);
        System.out.println(department.getId());
        }
    }
