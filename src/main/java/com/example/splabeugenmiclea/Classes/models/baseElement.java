package com.example.splabeugenmiclea.Classes.models;

import com.example.splabeugenmiclea.Classes.service.Element;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class baseElement implements Element {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
}
