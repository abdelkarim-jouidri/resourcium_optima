package com.example.resourcium_optima_ii.Model;

import jakarta.persistence.*;

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

    private String hashedPassword;

    public User(){

    }

    public User( String firstName, String lastName, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hashedPassword = hashedPassword;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String password){
            this.hashedPassword = hashPassword(password);
    }

    public String hashPassword(String pw){
        try {

            MessageDigest md = MessageDigest.getInstance("SH-256");
            md.update(pw.getBytes());
            byte[] encodedHash = md.digest();
            StringBuilder hexPassword = new StringBuilder();

            for (byte b : encodedHash){
                hexPassword.append(String.format("%02x", b));
            }
        return hashedPassword.toString();
        }catch (NoSuchAlgorithmException e){
            throw new RuntimeException("No such algorithm exists : "+e);
        }
    }
}
