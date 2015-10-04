package com.ginvaell.module2.task3and4;

/**
 * Created by ginva_000 on 03.10.2015.
 */
public class Pen extends WritingInstrument {
    private double thickness;

    public Pen(String name, String manufacturer, double price) {
        super(name, manufacturer, price);
    }

    public double getThickness() {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    @Override
    public String toString() {
        return "\nPen{" +
                " thickness=" + thickness + "\n"+
                super.toString()+
                '}';
    }

    @Override
    public String getInfo() {
        return super.getInfo()+" with ink.";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Pen obj = null;
        obj = (Pen) super.clone();
        obj.thickness = this.thickness;
        return obj;
    }
}
