package com.arcade.openapi.Service;

import com.arcade.openapi.Entity.Book;
import com.arcade.openapi.Repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepo bookRepo;

    public Optional<Book> getBook(Integer id) {
        return bookRepo.findById(id);
    }

    public List<Book> getBooks() {
        return bookRepo.findAll();
    }

    public Book createBook(Book book) {
        bookRepo.save(book);
        return book;
    }

    public Optional<Book> updateBook(Book book, Integer id) {
        return bookRepo.findById(id).map((b) -> {
            b.setName(book.getName());
            b.setAuthor(book.getAuthor());
            return bookRepo.save(b);
        });
    }

    public void deleteBook(Integer id) {
        bookRepo.deleteById(id);
    }
}
