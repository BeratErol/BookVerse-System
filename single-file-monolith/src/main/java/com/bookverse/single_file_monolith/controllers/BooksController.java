package com.bookverse.single_file_monolith.controllers;

import com.bookverse.single_file_monolith.entities.Book;
import com.bookverse.single_file_monolith.services.BookService;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    // Bağımlılık artık Servis Katmanına (Business Logic Layer)
    private final BookService bookService;

    // Artık @Autowired yok, Spring otomatik algılıyor.
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        // Controller sadece Servisi çağırır, iş mantığı hakkında hiçbir şey bilmez.
        return bookService.findAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getBookById(@PathVariable int id) {
        try {
            // Servis çağrılır. İş mantığı (ID doğrulama) Servis içinde halledilir.
            return bookService.findBookById(id)
                    // Sonucu HTTP 200 (OK) veya HTTP 404 (Not Found) olarak döner.
                    .<ResponseEntity<Object>>map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (IllegalArgumentException e) {
            // Controller, Servisten gelen iş kuralı hatasını (Exception) yakalar
            // ve bunu HTTP 400 (Bad Request) olarak kullanıcıya sunar.
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}