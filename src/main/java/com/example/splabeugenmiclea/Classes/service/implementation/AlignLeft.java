package com.example.splabeugenmiclea.Classes.service.implementation;

import com.example.splabeugenmiclea.Classes.service.AlignStrategy;

public class AlignLeft implements AlignStrategy {
    @Override
    public void render(String text) {
        System.out.println(text);
    }
}