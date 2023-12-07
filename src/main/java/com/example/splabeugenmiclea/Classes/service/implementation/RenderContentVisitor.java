package com.example.splabeugenmiclea.Classes.service.implementation;

import com.example.splabeugenmiclea.Classes.models.*;
import com.example.splabeugenmiclea.Classes.service.Element;
import com.example.splabeugenmiclea.Classes.service.Visitor;

import java.util.List;

public class RenderContentVisitor implements Visitor {
    List<Book> el;
    @Override
    public void visitBook(Book book) {
        System.out.println("Book: " + book.getTitle());
        System.out.println();
        System.out.println("Authors:");
        for (Author a : book.getAuthors()) {
            a.print();
        }

        System.out.println();
        for (Element et : book.getSections()) {
            ((Visitee)et).accept(this);
        }
    }

    @Override
    public void visitSection(Section section) {
        System.out.println(section.getTitle());
        for(Element e: section.getChildren())
            e.accept(this);
    }

    @Override
    public void visitParagraph(Paragraph paragraph) {
        if(paragraph.getAlign() == null)
            System.out.println("Paragraph: " + paragraph.getName());
        else
            paragraph.getAlign().render(paragraph.getName());
//        paragraph.accept(this);
    }

    @Override
    public void visitImageProxy(ImageProxy imageProxy) {
        imageProxy.loadRealImage().accept(this);
    }

    @Override
    public void visitImage(Image image) {


    }

    @Override
    public void visitTable(Table table) {

    }

    @Override
    public void visitTableOfContent(TableOfContent tableOfContent) {
        for (String s : tableOfContent.getEntries()){
            System.out.println(s);
        }

    }
}
