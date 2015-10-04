package com.ginvaell.module2.task3and4;

/**
 * Created by ginva_000 on 03.10.2015.
 */
public abstract class Paper extends Item {
    private int count;

    public Paper(String name, String manufacturer, double price) {
        super(name, manufacturer, price);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "\tPaper{" +
                "count=" + count + "\n"+
                super.toString()+
                '}';
    }

    @Override
    public String getInfo() {
        return "Paper records";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Paper obj = null;
        obj = (Paper) super.clone();
        obj.count = this.count;
        return obj;
    }
}
