package com.example.splabeugenmiclea.Classes.service.implementation;

import com.example.splabeugenmiclea.Classes.models.Book;
import com.example.splabeugenmiclea.Classes.service.Command;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CommandGetBooks implements Command<List<Book>> {
    private final BookService bookService;

    public CommandGetBooks(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public List<Book> execute() {
        return bookService.getBooks();


    }
}
