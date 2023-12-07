package com.example.splabeugenmiclea.Classes.models;

import com.example.splabeugenmiclea.Classes.service.Visitor;
import com.example.splabeugenmiclea.Classes.service.implementation.Visitee;

public class TableOfContentUpdate implements Visitor {
    private TableOfContent tableOfContent;
    private int pageIndex;

    public TableOfContentUpdate() {
        this.tableOfContent = new TableOfContent();
        this.pageIndex = 0;
    }

    @Override
    public void visitBook(Book book) {
        this.pageIndex += 1;
    }

    @Override
    public void visitSection(Section section) {
        String entry = section.getTitle() + ' ';
        while (entry.length() <= 20) {
            entry += '.';
        }
        entry += " " + this.pageIndex;

        tableOfContent.addEntry(entry);
    }

    @Override
    public void visitParagraph(Paragraph paragraph) {
        this.pageIndex += 1;
    }

    @Override
    public void visitImageProxy(ImageProxy imageProxy) {
        this.pageIndex += 1;
    }

    @Override
    public void visitImage(Image image) {
        this.pageIndex += 1;
    }

    @Override
    public void visitTable(Table table) {
        this.pageIndex += 1;
    }

    @Override
    public void visitTableOfContent(TableOfContent tableOfContent) {

    }

    public TableOfContent getToC() {
        return this.tableOfContent;
    }

}
