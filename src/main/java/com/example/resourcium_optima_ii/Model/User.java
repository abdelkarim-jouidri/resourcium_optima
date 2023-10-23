package com.example.resourcium_optima_ii.Model;

import jakarta.persistence.*;

import javax.management.relation.Role;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User(){

    }

    public User( String firstName, String lastName,String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = hashPassword(password);
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getHashedPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHashedPassword(String password){
            this.password = hashPassword(password);
    }

    public static String hashPassword(String pw){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(pw.getBytes());
            byte[] bytes = md.digest();
            StringBuilder hashedPassword = new StringBuilder();
            for(byte b : bytes){
                hashedPassword.append(String.format("%02x",b));
            }
            return hashedPassword.toString();

        }catch (NoSuchAlgorithmException e){
            throw new RuntimeException("No such algorithm exists : "+e);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public boolean verifyPassword(String password){
        return this.getHashedPassword().equals(hashPassword(password));
    }


    public enum Role{
        ADMIN,
        PERSONNEL,
        TECHNICIAN
    }

}
