package com.animator.catalog.splitwise.model.User;

public class User {
    private int id;
    private String name;
    private String email;
    private String contact;

    public User(int id, String name, String email, String contact) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }
}
