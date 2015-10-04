package com.ginvaell.module2.task3and4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BeginnerSet {
    static private ArrayList<Item> set;

    public static ArrayList<Item> getSet() {
        if (set == null) {
            set = new ArrayList<>(4);
            Pen pen = new Pen("MEGAPOLIS", "ErichKrause", 26.5);
            pen.setColor("Black");
            pen.setThickness(0.5);
            set.add(pen);
            Pencil pencil = new Pencil("Classic", "Silwerhof", 102.2);
            pencil.setColor("Grey");
            pencil.setSoft(2);
            set.add(pencil);
            Notebook notebook = new Notebook("Copy book", "Brauberg", 26.5);
            notebook.setMarking("cell");
            notebook.setCount(48);
            set.add(notebook);
            Sticker sticker = new Sticker("Post-it", "Z-Notes", 56.8);
            sticker.setColor("pink");
            sticker.setCount(100);
            set.add(sticker);
        }
        //noinspection unchecked,unchecked
        return (ArrayList<Item>) set.clone();
    }

    public static ArrayList<Item> getSetSortedByPrice() {
        ArrayList<Item> cloned = getSet();
        Collections.sort(cloned);

        return cloned;
    }

    public static ArrayList<Item> getSetSortedByName() {
        ArrayList<Item> cloned = getSet();
        Collections.sort(cloned, (Item a, Item b) -> a.getName().compareTo(b.getName()));

        return cloned;
    }

    public static ArrayList<Item> getSetSortedByPriceAndName() {
        ArrayList<Item> cloned = getSet();
        Collections.sort(cloned, new ItemComparator());

        return cloned;
    }

    private static class ItemComparator implements Comparator<Item> {

        @Override
        public int compare(Item o1, Item o2) {
            int result;
            if ((result = o1.compareTo(o2)) != 0) {
                return result;
            } else {
                return o1.getName().compareTo(o2.getName());
            }
        }
    }


}
