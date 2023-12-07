package com.example.splabeugenmiclea.Classes.service.implementation;

import com.example.splabeugenmiclea.Classes.models.Book;
import com.example.splabeugenmiclea.Classes.service.Command;
import org.springframework.stereotype.Component;

@Component
public class CommandGetBookByID implements Command<Book> {
    private final BookService bookService;
    Long id;
    public CommandGetBookByID(BookService bookService) {
        this.bookService = bookService;
    }


    @Override
    public Book execute() {
        return bookService.getBookById(id);
    }

    public void setID(Long id){
        this.id = id;

    }

}
