package com.example.splabeugenmiclea.Classes.service.implementation;

import com.example.splabeugenmiclea.Classes.Repository.bookRepository;
import com.example.splabeugenmiclea.Classes.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.CompletableFuture;

@Service
@EnableAsync(proxyTargetClass = true)
public class BookService {

    private final Map<Long, Book> books = new HashMap<>();
    private final bookRepository bookRepository;
    private long nextId = 1;
@Autowired
    public BookService(bookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Async
    public CompletableFuture<Book> createBook(Book bookData) {
        Book createdBook = bookRepository.save(bookData);
        return CompletableFuture.completedFuture(createdBook);
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Integer bookId) {
        return bookRepository.findById(bookId);
    }

    public void updateBook(Integer bookId, Book updatedBookData) {
        if (bookRepository.existsById(bookId)) {
            updatedBookData.setId(bookId);
            bookRepository.save(updatedBookData);

        }
    }

//    public void deleteBook(Long bookId) {
//        System.out.println("________BEFORE____________");
//
//        System.out.println(books);
//        if (books.containsKey(bookId))
//            books.remove(bookId);
//        else
//            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++aici");
//        System.out.println("________AFTER____________");
//        System.out.println(books);
//    }



    public void deleteBook(Integer bookId){
        bookRepository.deleteById(bookId);
    }

    private synchronized long getNextId() {
        return nextId++;
    }

}
