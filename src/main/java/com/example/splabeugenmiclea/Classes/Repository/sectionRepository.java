package com.example.splabeugenmiclea.Classes.Repository;

import com.example.splabeugenmiclea.Classes.models.Author;
import com.example.splabeugenmiclea.Classes.models.Section;
import com.example.splabeugenmiclea.Classes.models.baseElement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface sectionRepository extends JpaRepository<baseElement, Integer> {

}
