package com.example.splabeugenmiclea.Classes.Repository;

import com.example.splabeugenmiclea.Classes.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface authorRepository extends JpaRepository<Author, Integer> {
}
