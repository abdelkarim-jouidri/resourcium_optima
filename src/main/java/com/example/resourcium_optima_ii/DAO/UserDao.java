package com.example.resourcium_optima_ii.DAO;

import com.example.resourcium_optima_ii.Model.User;
import jakarta.persistence.*;

public class UserDao {
    private final EntityManagerFactory entityManagerFactory;

    public UserDao(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void save(User user){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();

        }catch (Exception e){
            if(transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
    }

    public User getUserByEmail(String email){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            User user = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                    .setParameter("email", email).getSingleResult();
            return user;
        }catch (NoResultException e){
            System.out.println("There is no such User with this email address.");
            return null;
        }
        catch (NonUniqueResultException e ){
            System.out.println("More than one unique user instance was found with this email address");
            return null;
        }
    }

    public boolean userByEmailExists(String email){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            String hql = "SELECT COUNT(u) FROM User u WHERE u.email = :email";
            Query query = entityManager.createQuery(hql);
            query.setParameter("email", email);
            Long count = (Long) query.getSingleResult();
            transaction.commit();
            return count>0;
        }catch (Exception e){
            if(transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }finally {
            entityManager.close();
        }
    }

}
