package com.ginvaell.module2.task3and4;

/**
 * Created by ginva_000 on 03.10.2015.
 */
public class Notebook extends Paper{
    private String marking;

    public Notebook(String name, String manufacturer, double price) {
        super(name, manufacturer, price);
    }

    public String getMarking() {
        return marking;
    }

    public void setMarking(String marking) {
        this.marking = marking;
    }

    @Override
    public String toString() {
        return "\nNotebook{" +
                "marking='" + marking + '\'' +
                super.toString()+
                '}';
    }

    @Override
    public String getInfo() {
        return "Stapled "+super.getInfo() + "with marking.";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Notebook obj = null;
        obj = (Notebook) super.clone();
        if(this.marking != null) {
            obj.marking = new String(marking);
        }
        return obj;
    }
}
