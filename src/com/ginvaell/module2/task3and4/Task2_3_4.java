package com.ginvaell.module2.task3and4;

public class Task2_3_4 {

    public static void main(String[] args) {

        System.out.println(BeginnerSet.getSet().toString());
        System.out.println("By price");
        System.out.println(BeginnerSet.getSetSortedByPrice().toString());
        System.out.println("By name");
        System.out.println(BeginnerSet.getSetSortedByName().toString());
        System.out.println("By price and by name");
        System.out.println(BeginnerSet.getSetSortedByPriceAndName().toString());

    }
}
