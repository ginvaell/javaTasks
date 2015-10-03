package com.ginvaell.module2.task2;

import java.util.ArrayList;

/**
 * Created by ginva_000 on 02.10.2015.
 */
public class Employee {
    private final String name;
    private final ArrayList<Item> stuff;

    public Employee(String name) {
        this.name = name;
        stuff = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Employee addItem(Item item) {
        int i;
        if ((i = stuff.indexOf(item)) >= 0) {
            stuff.get(i).add(item.getCount());
        } else {
            stuff.add(item);
        }
        return this;
    }

    public boolean deleteItem(String name, int count) {
        for (Item i : stuff) {
            if (i.getName().equals(name)) {
                if (i.delete(count) <= 0) {
                    stuff.remove(i);
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "\n\tEmployee{" +
                "name='" + name + '\'' +
                ", stuff=" + stuff +
                '}';
    }

    public double getTotalCost() {
        double total = 0.0;
        for (Item i : stuff) {
            total += i.getTotalCost();
        }
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        return getName().equals(employee.getName());

    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
