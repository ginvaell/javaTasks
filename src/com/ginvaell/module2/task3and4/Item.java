package com.ginvaell.module2.task3and4;

public abstract class Item implements Cloneable, Comparable<Item> {
    private String name;
    private String manufacturer;
    private double price;

    public Item(String name, String manufacturer, double price) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    @Override
    public String toString() {
        return "\t\tItem{" +
                "name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public abstract String getInfo();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Item obj;
        obj = (Item) super.clone();
        obj.name = this.name;
        obj.manufacturer = this.manufacturer;
        obj.price = this.price;
        return obj;

    }

    @Override
    public int compareTo(Item o) {
        return Double.compare(price, o.getPrice());
    }
}
