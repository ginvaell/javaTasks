package com.ginvaell.module2.task1;

public class Task2_1 {

    public static void main(String[] args) {
	    Pen pen1 =  new Pen("G-base", "ErichKrause");
        pen1.setThickness(0.5);
        pen1.setPrise(32.5);

        Pen pen2 = new Pen("G-base", "ErichKrause");
        pen2.setThickness(0.7);
        pen2.setPrise(32.5);

        System.out.println(pen2.equals(pen1));
        System.out.println(pen1.toString());
        System.out.println(pen1.hashCode());
        System.out.println(pen2.toString());
        System.out.println(pen2.hashCode());
        pen2.setThickness(0.5);
        System.out.println(pen2.equals(pen1));
        System.out.println(pen2.hashCode());

    }


}
