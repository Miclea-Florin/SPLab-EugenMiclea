package com.example.splabeugenmiclea.Classes.service.implementation;

public class NewBookRequest {

    String title;

    public NewBookRequest(String title) {
        this.title = title;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
