package com.example.splabeugenmiclea.Classes.service.implementation;

import com.example.splabeugenmiclea.Classes.models.Book;
import com.example.splabeugenmiclea.Classes.service.Command;
import org.springframework.stereotype.Component;

@Component
public class CommandAddBook implements Command<Book> {
    private final BookService bookService;
    private Book Book;

    public CommandAddBook(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public Book execute() {
        return bookService.createBook(Book);

    }

    public void setBook(Book book) {
        Book = book;

    }
}
