package com.bookverse.single_file_monolith.services;

import com.bookverse.single_file_monolith.entities.Book;
import com.bookverse.single_file_monolith.repositories.BookRepository;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service // Spring'e bu sınıfın bir Servis olduğunu bildirir.
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    // Artık @Autowired yok, Spring otomatik algılıyor. // Bağımlılık Enjeksiyonu (Dependency Injection)
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Optional<Book> findBookById(int id) {
        // İŞ MANTIĞI: Kontrol artık Controller'dan buraya taşındı.
        if (id <= 0) {
            throw new IllegalArgumentException("Kitap ID'si pozitif bir değer olmalıdır.");
        }
        
        // Veri erişimi sorumluluğu Repository'ye devredilir.
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }
}