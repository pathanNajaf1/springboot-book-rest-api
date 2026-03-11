package com.api.book.bootrestbook.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.Entities.Book;
import com.api.book.bootrestbook.Services.BookService;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {

        List<Book> list = bookService.getAllBooks();
        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(book);
    }

    // Method to add a new book to the list
    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        try {
            Book b = bookService.addBook(book);
            return ResponseEntity.status(HttpStatus.CREATED).body(b);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Method to delete a book from the list\
    @DeleteMapping("/books/{bookid}")
    public ResponseEntity<Void> deleteBook(@PathVariable int bookid) {
        Book book = bookService.getBookById(bookid);

        if (book == null) {
            return ResponseEntity.notFound().build();
        }

        bookService.deleteBook(bookid);
        return ResponseEntity.noContent().build();
    }

    // Method to update a book in the list
    @PutMapping("/books/{bookid}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("bookid") int bookid) {
        try {
            this.bookService.updateBook(book, bookid);
            return ResponseEntity.ok().body(book);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
