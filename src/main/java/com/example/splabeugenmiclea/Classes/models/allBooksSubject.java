package com.example.splabeugenmiclea.Classes.models;

import com.example.splabeugenmiclea.Classes.service.Observer;
import com.example.splabeugenmiclea.Classes.service.implementation.SseObserver;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Component
public class allBooksSubject {
    private final List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void add(Book book) throws IOException {
        // Your existing logic to add a book
        // Notify all observers about the new book
        notifyObservers(book);
    }

    private void notifyObservers(Book book) throws IOException {
        for (Observer observer : observers) {
            observer.update(book);
        }
    }
}
