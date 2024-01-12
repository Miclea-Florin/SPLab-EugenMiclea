package com.example.splabeugenmiclea.Classes.models;

import com.example.splabeugenmiclea.Classes.service.Visitor;
import com.example.splabeugenmiclea.Classes.service.implementation.AlignLeft;
import com.example.splabeugenmiclea.Classes.service.AlignStrategy;
import com.example.splabeugenmiclea.Classes.service.Element;
import com.example.splabeugenmiclea.Classes.service.implementation.Visitee;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Data
@Entity
public class Paragraph extends baseElement implements Element, Visitee {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Getter
    private String name;
    @Transient
    private AlignStrategy align;
    public Paragraph(String name){
        this.name = name;
        align = new AlignLeft();
    }

    public Paragraph() {

    }

    @Override
    public void print(){
        if(align == null)
            System.out.println("Paragraph: " + name);
        else
            align.render(name);
    }


    @Override
    public void add(Element e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeElement(Element e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Element get(int i) {
        throw new UnsupportedOperationException();
    }


    public void setAlignStrategy(AlignStrategy align) {
        this.align = align;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitParagraph(this);
    }
}