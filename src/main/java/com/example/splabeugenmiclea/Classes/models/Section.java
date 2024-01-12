package com.example.splabeugenmiclea.Classes.models;

import com.example.splabeugenmiclea.Classes.service.Element;
import com.example.splabeugenmiclea.Classes.service.Visitor;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
@Entity
public class Section extends baseElement implements Element {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column
    private String title;
    @OneToMany(targetEntity = baseElement.class)
    private List<Element> children = new ArrayList<>();

    public Section(String title) {
        this.title = title;
    }

    public Section() {

    }

    @Override
    public void print(){
        System.out.println(title);
        for(Element e:children)
            e.print();
    }


    @Override
    public void add(Element e){
        children.add(e);
    }

    @Override
    public void removeElement(Element e){
        children.remove(e);
    }

    @Override
    public Element get(int i){
        return children.get(i);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitSection(this);
        for(Element c: children){
            c.accept(visitor);
        }
    }
}