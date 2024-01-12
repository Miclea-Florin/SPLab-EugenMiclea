package com.example.splabeugenmiclea.Classes.service.implementation;

import com.example.splabeugenmiclea.Classes.models.Book;
import com.example.splabeugenmiclea.Classes.service.Command;
import org.springframework.stereotype.Component;

@Component
public class CommandUpdateBook implements Command<Book> {
    private final BookService bookService;
    Integer id;
    Book book;
    public CommandUpdateBook(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public Book execute() {
        bookService.updateBook(id,book);
        return this.book;
    }

    public void setBook(Integer id, Book book)
    {
        this.id = id;
        this.book = book;

    }
}
