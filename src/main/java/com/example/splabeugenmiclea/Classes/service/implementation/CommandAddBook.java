package com.example.splabeugenmiclea.Classes.service.implementation;

import com.example.splabeugenmiclea.Classes.models.Author;
import com.example.splabeugenmiclea.Classes.models.Book;
import com.example.splabeugenmiclea.Classes.service.Command;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class CommandAddBook implements Command<CompletableFuture<Book>> {
    private final BookService bookService;
    private Book Book;

    private Author autor;

    public CommandAddBook(BookService bookService) {
        this.bookService = bookService;
    }
//
//    @Override
//    public Book execute() {
//        return bookService.createBook(Book);
//
//    }
@Override
@Async
    public CompletableFuture<Book> execute(){

        return bookService.createBook(Book);
    }
    public void setBook(Book book) {
        Book = book;

    }

    public Book getBook() {
        return Book;
    }
}
