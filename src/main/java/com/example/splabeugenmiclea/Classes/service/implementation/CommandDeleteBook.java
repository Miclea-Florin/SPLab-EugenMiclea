package com.example.splabeugenmiclea.Classes.service.implementation;

import com.example.splabeugenmiclea.Classes.service.Command;
import org.springframework.stereotype.Component;

@Component
public class CommandDeleteBook implements Command<Void> {
    private final BookService bookService;
    Long id;

    public CommandDeleteBook(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public Void execute() {
        bookService.deleteBook(id);
        return null;
    }

    public void setId(Long id){
        this.id=id;

    }
}
