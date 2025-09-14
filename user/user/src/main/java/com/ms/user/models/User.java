package com.ms.user.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_USERS")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;
    private String name;
    private String email;

    public void setUserId(UUID userId){
        this.userId = userId;
    }
    public UUID getUserId(){
        return this.userId;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }

}
