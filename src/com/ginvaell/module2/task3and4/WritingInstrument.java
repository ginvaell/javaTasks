package com.ginvaell.module2.task3and4;

/**
 * Created by ginva_000 on 03.10.2015.
 */
public abstract class WritingInstrument extends Item {
    private String color;

    public WritingInstrument(String name, String manufacturer, double price) {
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
        return "\tWritingInstrument{" +
                " color='" + color + '\'' +"\n"+
                super.toString()+
                '}';
    }

    @Override
    public String getInfo() {
        return "Used to leave a trace on a paper";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        WritingInstrument obj = null;
        obj = (WritingInstrument) super.clone();
        if(this.color != null) {
            obj.color = new String(color);
        }
        return obj;
    }
}
