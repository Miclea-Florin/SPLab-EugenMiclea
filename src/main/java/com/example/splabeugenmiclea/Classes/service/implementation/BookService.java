package com.example.splabeugenmiclea.Classes.service.implementation;

import com.example.splabeugenmiclea.Classes.models.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class BookService {

    private final Map<Long, Book> books = new HashMap<>();
    private long nextId = 1;

    public Book createBook(Book bookData) {
        long bookId = getNextId();
        books.put(bookId, bookData);
        return books.get(bookId);
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books.values());
    }

    public Book getBookById(Long bookId) {
        return books.get(bookId);
    }

    public void updateBook(Long bookId, Book updatedBookData) {
        if (books.containsKey(bookId)) {
            books.put(bookId, updatedBookData);
        }
    }

    public void deleteBook(Long bookId) {
        System.out.println("________BEFORE____________");

        System.out.println(books);
        if (books.containsKey(bookId))
            books.remove(bookId);
        else
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++aici");
        System.out.println("________AFTER____________");
        System.out.println(books);
    }

    private synchronized long getNextId() {
        return nextId++;
    }

}
