package com.ginvaell.module2.task2;

/**
 * Created by ginva_000 on 02.10.2015.
 */
public class Item {
    private final String name;
    private final double price;
    private int count;

    public Item(String name, double price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public void add(int n) {
        count += n;
    }

    public int delete(int n) {
        return count -= n;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof Item)) return false;

        Item item = (Item) o;

        if (Double.compare(item.getPrice(), getPrice()) != 0) return false;
        return getName().equals(item.getName());

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getName().hashCode();
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "\n\t\tItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }

    public double getTotalCost() {
        return price * count;
    }
}
