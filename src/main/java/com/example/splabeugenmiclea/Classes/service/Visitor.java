package com.example.splabeugenmiclea.Classes.service;

import com.example.splabeugenmiclea.Classes.models.*;

public interface Visitor {
    void visitBook(Book book);
    void visitSection(Section section);
    void visitParagraph(Paragraph paragraph);
    void visitImageProxy(ImageProxy imageProxy);
    void visitImage(Image image);
    void visitTable(Table table);
    void visitTableOfContent(TableOfContent tableOfContent);
}
