package com.example.splabeugenmiclea.Classes.service;

import com.example.splabeugenmiclea.Classes.service.implementation.Visitee;

public interface Element extends Visitee {
    void print();
    void add(Element e);
    void removeElement(Element e);
    Element get(int i);
}
