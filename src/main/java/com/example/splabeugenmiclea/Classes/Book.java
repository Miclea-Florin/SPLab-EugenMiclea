package com.example.splabeugenmiclea.Classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Book {
    String title;
    List<Author> autori = new ArrayList<Author>();
    List<Chapter> chapters = new ArrayList<Chapter>();

    public Book(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", autori=" + autori +
                ", chapters=" + chapters +
                '}';
    }


    public void addAuthor(Author author) {
        autori.add(author);
    }

    public int createChapter(String s) {
        chapters.add(new Chapter(s));
        return 0;
    }

    public Chapter getChapter(int indexChapterOne) {
        return this.chapters.get(indexChapterOne);
    }
}
