package com.example.splabeugenmiclea.Classes;

public class Paragraph implements Element{
    private String name;
    AlignStrategy as = null;
    public Paragraph(String name){
        this.name = name;
    }

    @Override
    public void print(){
        if(as ==null)
            System.out.println("Paragraph: " + name);
        else if(as instanceof AlignLeft)
            System.out.println("# Paragraph: " + name);
        else if(as instanceof AlignRight)
            System.out.println("Paragraph: " + name+"#");
        else if(as instanceof AlignCenter)
            System.out.println("# Paragraph: " + name+"#");

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

    public void setAlignStrategy(AlignStrategy a){
        as = a;
    }

}