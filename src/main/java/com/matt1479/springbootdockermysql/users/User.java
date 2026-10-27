package com.matt1479.springbootdockermysql.users;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class User {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    protected User() {}

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override 
    public String toString() {
        return String.format(
            "User[id=%s, name='%s', email='%s']",
            id, name, email
        );
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
