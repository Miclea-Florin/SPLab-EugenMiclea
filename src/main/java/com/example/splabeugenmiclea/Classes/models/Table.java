package com.example.splabeugenmiclea.Classes.models;

import com.example.splabeugenmiclea.Classes.service.Element;

public class Table implements Element {
    private String name;
    public Table(String name){
        this.name = name;
    }

    @Override
    public void print(){
        System.out.println("Table name: " + name);
    }

    @Override
    public void add(Element e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeElement(Element e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Element get(int i) {
        throw new UnsupportedOperationException();
    }
}