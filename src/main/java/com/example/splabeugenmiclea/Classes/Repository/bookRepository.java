package com.example.splabeugenmiclea.Classes.Repository;

import com.example.splabeugenmiclea.Classes.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface bookRepository extends JpaRepository<Book, Integer> {
}
