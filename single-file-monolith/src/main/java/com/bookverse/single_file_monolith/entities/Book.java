package com.bookverse.single_file_monolith.entities;

public class Book {
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    // *** EKSİK OLAN GETTER METODLARI EKLENDİ ***

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Setters metotlarını da ekleyebilirsiniz, ancak bu uygulama için sadece
    // Getter'lar yeterli olacaktır.
    // ...
}