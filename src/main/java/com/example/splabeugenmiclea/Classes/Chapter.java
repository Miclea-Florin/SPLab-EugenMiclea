package com.example.splabeugenmiclea.Classes;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Chapter {
    String name;
    List<SubChapter> subChapters = new ArrayList<SubChapter>();


    @Override
    public String toString() {
        return "Chapter{" +
                "name='" + name + '\'' +
                ", subChapters=" + subChapters +
                '}';
    }

    public Chapter(String name) {
        this.name = name;
    }

    public SubChapter getSubChapter(int indexSubChapterOneOne) {
       return this.subChapters.get(indexSubChapterOneOne);
    }

    public int createSubChapter(String s) {
        subChapters.add(new SubChapter(s));
        return 0;
    }
}
