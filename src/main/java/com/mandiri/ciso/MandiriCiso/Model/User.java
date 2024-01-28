package com.mandiri.ciso.MandiriCiso.Model;

import jakarta.persistence.*;
import jdk.jfr.Unsigned;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String username;

    protected User() {}

    public User(String name, String username) {
        this.name = name;
        this.username = username;
    }

    @Override
    public String toString() {
        return String.format("User[id=%d, name='%s', username='%s']", id, name, username);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
