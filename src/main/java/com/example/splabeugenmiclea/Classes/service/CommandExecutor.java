package com.example.splabeugenmiclea.Classes.service;

import com.example.splabeugenmiclea.Classes.service.implementation.BookService;
import com.example.splabeugenmiclea.Classes.service.implementation.Request;

public interface CommandExecutor {
    abstract Request executeCommand(Command command, BookService bookService);
}
