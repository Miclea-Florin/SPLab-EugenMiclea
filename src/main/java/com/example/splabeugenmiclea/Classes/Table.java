package com.example.splabeugenmiclea.Classes;

public class Table {
    String title;

    public Table(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Table{" +
                "title='" + title + '\'' +
                '}';
    }
}
