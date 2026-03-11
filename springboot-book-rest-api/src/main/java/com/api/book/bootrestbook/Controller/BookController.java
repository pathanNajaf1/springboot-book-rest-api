package com.api.book.bootrestbook.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.api.book.bootrestbook.Entities.Book;
import com.api.book.bootrestbook.Services.BookService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getBooks() {
        return this.bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id) {
        return this.bookService.getBookById(id);
    }

    // Method to add a new book to the list
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        Book b = bookService.addBook(book);
        return b;
    }

    // Method to delete a book from the list\
    @DeleteMapping("/books/{bookid}")
    public void deleteBook(@PathVariable("bookid") int bookid) {
        this.bookService.deleteBook(bookid);
    }

    // Method to update a book in the list
    @PutMapping("/books/{bookid}")
    public void updateBook(@RequestBody Book book, @PathVariable("/bookid") int bookid){
        this.bookService.updateBook(book, bookid);
    }
}
