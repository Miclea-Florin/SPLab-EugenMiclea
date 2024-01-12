package com.example.splabeugenmiclea.Classes.service;

import com.example.splabeugenmiclea.Classes.models.Book;

import java.io.IOException;

public interface Observer {

    void update(Book book) throws IOException;

}
