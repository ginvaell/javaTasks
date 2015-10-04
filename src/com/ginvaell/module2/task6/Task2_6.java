package com.ginvaell.module2.task6;


public class Task2_6 {
    public static void main(String[] args) {
        NuclearSubmarine submarine = new NuclearSubmarine();
        System.out.println("New!");
        System.out.println(submarine.getInfo());
        submarine.sail();
        System.out.println("Sail!");
        System.out.println(submarine.getInfo());
        submarine.start();
        System.out.println("Start!");
        System.out.println(submarine.getInfo());
        submarine.sail();
        System.out.println("Sail!");
        System.out.println(submarine.getInfo());

    }
}
