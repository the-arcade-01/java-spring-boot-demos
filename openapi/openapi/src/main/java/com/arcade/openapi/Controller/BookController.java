package com.arcade.openapi.Controller;

import com.arcade.openapi.Entity.Book;
import com.arcade.openapi.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Book> getBook(@PathVariable Integer id) {
        return bookService.getBook(id);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book updateBook(@RequestBody Book book, @PathVariable Integer id) {
        bookService.updateBook(book, id);
        return book;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
    }
}
