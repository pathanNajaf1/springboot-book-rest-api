package com.api.book.bootrestbook.Services;

// import java.util.ArrayList;
import java.util.List;
// import java.util.Iterator;

// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.api.book.bootrestbook.Entities.Book;
import com.api.book.bootrestbook.dao.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    // private static List<Book> list = new ArrayList<>();

    // static {
    //     list.add(new Book(1, "Java", "Me"));
    //     list.add(new Book(2, "Python", "Not Me"));
    //     list.add(new Book(3, "C++", "Absolutely Not Me"));
    // }

    // getting all books
    public List<Book> getAllBooks() {
        List<Book> list = (List<Book>) bookRepository.findAll();
        return list;
    }

    // getting a single book by id
    public Book getBookById(int id) {
    return bookRepository.findById(id).orElse(null);
}

    // Method to add a new book to the list
    public Book addBook(Book book){
        Book result = bookRepository.save(book);
        return result;
    }

    // Method to delete a book from the list
    public void deleteBook(int bookid){
        // Iterator<Book> iterator = list.iterator();
        // while(iterator.hasNext()){
        //     Book b = iterator.next();
        //     if(b.getId()==bookid){
        //         iterator.remove();
        //         System.out.println("Book with id " + bookid + " has been deleted.");
        //         break;
        //     }
        // }
        bookRepository.deleteById(bookid);
    }

    public void updateBook(Book book, int bookid){
        // for(int i=0;i<list.size();i++){
        //     Book b=list.get(i);
        //     if(b.getId()==bookid){
        //         book.setId(bookid);
        //         list.set(i,book);
        //         break;
        //     }
        // }
        book.setId(bookid);
        bookRepository.save(book);
    }
}
