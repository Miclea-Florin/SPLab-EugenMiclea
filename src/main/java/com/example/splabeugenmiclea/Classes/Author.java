package com.example.splabeugenmiclea.Classes;

import java.util.Collection;

public class Author {
    String name;


    TableOfContents tableOfContents;

    public Author(String name, Collection<Book> books, TableOfContents tableOfContents) {
        this.name = name;

        this.tableOfContents = tableOfContents;
    }

    public Author(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", tableOfContents=" + tableOfContents +
                '}';
    }
}
