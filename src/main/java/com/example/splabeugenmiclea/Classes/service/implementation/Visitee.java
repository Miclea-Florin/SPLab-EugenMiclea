package com.example.splabeugenmiclea.Classes.service.implementation;

import com.example.splabeugenmiclea.Classes.models.*;
import com.example.splabeugenmiclea.Classes.service.Element;
import com.example.splabeugenmiclea.Classes.service.Visitor;

public class Visitee implements Visitor {

    @Override
    public void visitBook(Book book) {
        System.out.println("Book: " + book.getTitle());
        System.out.println("\nAuthors: ");
        for(Author a: book.getAuthors())
            a.print();
        System.out.println();
        for(Element e: book.getSections())
            e.print();
    }

    @Override
    public void visitSection(Section section) {
        System.out.println(section.getTitle());
    }

    @Override
    public void visitParagraph(Paragraph paragraph) {
        paragraph.print();
    }

    @Override
    public void visitImageProxy(ImageProxy imageProxy) {
        imageProxy.print();
    }

    @Override
    public void visitImage(Image image) {
        image.print();
    }

    @Override
    public void visitTable(Table table) {
        table.print();
    }

    @Override
    public void visitTableOfContent(TableOfContent tableOfContent) {
        tableOfContent.print();
    }
}
