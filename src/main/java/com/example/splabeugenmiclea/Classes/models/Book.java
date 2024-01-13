package com.example.splabeugenmiclea.Classes.models;

import com.example.splabeugenmiclea.Classes.service.Element;
import com.example.splabeugenmiclea.Classes.service.Visitor;
import com.example.splabeugenmiclea.Classes.service.implementation.Visitee;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
@Entity
public class Book implements Visitee {
    private String title;

    @OneToMany(targetEntity = baseElement.class)
    private List<baseElement> sections;

    @ManyToMany
    private List<Author> authors;
    @Id
    @GeneratedValue
    private Integer id;

    public Book(String title, List<baseElement> sections) {
        this.title = title;

        this.sections = sections;
    }

    public Book(String title, List<baseElement> sections, List<Author> a) {
        this.title = title;

        this.sections = sections;
        this.authors = a;
    }

    public Book() {

    }

    public void addAuthor(Author a) {
        authors.add(a);
    }

    public Book(String title) {
        this.title = title;
        authors = new ArrayList<Author>();
        sections = null;
    }

    public int createSection(String ChapterTitle) {
        if (sections == null) {
            sections = new ArrayList<baseElement>();
        }
        Section newSection = new Section("ChapterTitle");
        sections.add(newSection);
        return sections.size();
    }

    public void print() {
        System.out.println("Book: " + title);
        System.out.println("\nAuthors: ");
        for (Author a : authors)
            a.print();
        System.out.println();
        for (Element e : sections)
            e.print();
    }


    public Element getSection(int index) {
        return sections.get(index - 1);
    }

    public void addContent(Element paragraph) {
        if (sections == null) sections = new ArrayList<baseElement>();
        sections.add((baseElement) paragraph);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitBook(this);
        System.out.println("Book: " + this.getTitle());
        System.out.println();
        System.out.println("Authors:");
        for (Author a : this.getAuthors()) {
            a.print(); }

        for (Element el : sections) {
                el.accept(visitor);
            }

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
