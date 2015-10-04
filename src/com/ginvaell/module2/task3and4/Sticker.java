package com.ginvaell.module2.task3and4;

/**
 * Created by ginva_000 on 03.10.2015.
 */
public class Sticker extends Paper {
    private String color;

    public Sticker(String name, String manufacturer, double price) {
        super(name, manufacturer, price);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "\nSticker{" +
                "color='" + color + '\'' +"\n"+
                super.toString()+
                '}';
    }

    @Override
    public String getInfo() {
        return super.getInfo()+" with the adhesive strip.";
    }

    protected Object clone() throws CloneNotSupportedException {
        Sticker obj = null;
        obj = (Sticker) super.clone();
        obj.color = this.color;
        return obj;
    }
}
