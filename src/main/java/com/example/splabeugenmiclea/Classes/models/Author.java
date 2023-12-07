package com.example.splabeugenmiclea.Classes.models;

import java.util.Collection;

public class Author {
    String name;

    public Author(String name) {
        this.name = name;
    }

    public void print(){
        System.out.println("Author: " + name);
    }
}