package com.example.splabeugenmiclea.Classes.service.implementation;

import com.example.splabeugenmiclea.Classes.models.Book;
import com.example.splabeugenmiclea.Classes.service.Command;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CommandGetBookByID implements Command<Optional<Book>> {
    private final BookService bookService;
    Integer id;
    public CommandGetBookByID(BookService bookService) {
        this.bookService = bookService;
    }


    @Override
    public Optional<Book> execute() {
        return bookService.getBookById(id);
    }

    public void setID(Integer id){
        this.id = id;

    }

}
