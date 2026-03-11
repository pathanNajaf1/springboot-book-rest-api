package com.api.book.bootrestbook.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import org.springframework.stereotype.Service;
import com.api.book.bootrestbook.Entities.Book;

@Service
public class BookService {
    private static List<Book> list = new ArrayList<>();

    static {
        list.add(new Book(1, "Java", "Me"));
        list.add(new Book(2, "Python", "Not Me"));
        list.add(new Book(3, "C++", "Absolutely Not Me"));
    }

    // getting all books
    public List<Book> getAllBooks() {
        return list;
    }

    // getting a single book by id
    public Book getBookById(int id) {
        Book book = null;
        for (Book b : list) {
            if (b.getId() == id) {
                book = b;
                break;
            }
        }
        return book;
    }

    // Method to add a new book to the list
    public Book addBook(Book book){
        list.add(book);
        return book;
    }

    // Method to delete a book from the list
    public void deleteBook(int bookid){
        Iterator<Book> iterator = list.iterator();
        while(iterator.hasNext()){
            Book b = iterator.next();
            if(b.getId()==bookid){
                iterator.remove();
                System.out.println("Book with id " + bookid + " has been deleted.");
                break;
            }
        }
    }

    public void updateBook(Book book, int bookid){
        for(int i=0;i<list.size();i++){
            Book b=list.get(i);
            if(b.getId()==bookid){
                book.setId(bookid);
                list.set(i,book);
                break;
            }
        }
    }
}