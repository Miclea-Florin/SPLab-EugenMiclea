package com.example.splabeugenmiclea.Classes.models;

import com.example.splabeugenmiclea.Classes.service.Element;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.Data;
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Section.class, name = "section"),
})
@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class baseElement implements Element {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
}
