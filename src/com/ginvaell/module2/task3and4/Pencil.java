package com.ginvaell.module2.task3and4;

/**
 * Created by ginva_000 on 03.10.2015.
 */
public class Pencil extends WritingInstrument {
    private int soft;

    public Pencil(String name, String manufacturer, double price) {
        super(name, manufacturer, price);
    }

    public int getSoft() {
        return soft;
    }

    public void setSoft(int soft) {
        this.soft = soft;
    }

    @Override
    public String toString() {
        return "\nPencil{" +
                "soft=" + soft + "\n" +
                super.toString() +
                '}';
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " with lead";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Pencil obj;
        obj = (Pencil) super.clone();
        obj.soft = this.soft;
        return obj;
    }
}
