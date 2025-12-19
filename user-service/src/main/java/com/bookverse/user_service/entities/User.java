package com.bookverse.user_service.entities;

// Kullanıcı varlığı (entity)
public class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    // Setters bu örnekte gerekli değildir, ancak eklenebilir.
}