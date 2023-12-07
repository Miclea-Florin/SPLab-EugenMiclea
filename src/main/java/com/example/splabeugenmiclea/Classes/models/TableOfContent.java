package com.example.splabeugenmiclea.Classes.models;

import com.example.splabeugenmiclea.Classes.service.Element;
import com.example.splabeugenmiclea.Classes.service.Visitor;
import com.example.splabeugenmiclea.Classes.service.implementation.Visitee;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class TableOfContent implements Element {

    private List<String> entries = new ArrayList<String>();



    public void print(){
        System.out.println("TableOfContent");
        for (String entry : this.entries) {
            System.out.println(entry);
        }
    }

    @Override
    public void add(Element e) {

    }


    @Override
    public void removeElement(Element e) {

    }

    @Override
    public Element get(int i) {
        return null;
    }

    public void addEntry(String entry) {
        this.entries.add(entry);
    }



    @Override
    public void accept(Visitor visitor) {
        visitor.visitTableOfContent(this);
    }


}

