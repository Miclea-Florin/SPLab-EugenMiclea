package com.example.splabeugenmiclea.Classes.models;

import com.example.splabeugenmiclea.Classes.models.Image;
import com.example.splabeugenmiclea.Classes.service.Element;
import com.example.splabeugenmiclea.Classes.service.Visitor;
import com.example.splabeugenmiclea.Classes.service.implementation.Visitee;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@NoArgsConstructor
public class ImageProxy extends baseElement implements Element, Visitee {

    private String imagename;
    @Transient
    private Image realImage= null;

    public ImageProxy(String imagename) {
        this.imagename = imagename;
    }

    public Image loadRealImage() {
        if (Objects.isNull(realImage)) {
            realImage = new Image(this.imagename);
        return realImage;
        }
        return realImage;
    }

    @Override
    public void print() {
        loadRealImage();
        realImage.print();
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

    @Override
    public void accept(Visitor visitor) {
        visitor.visitImageProxy(this);
    }
}
