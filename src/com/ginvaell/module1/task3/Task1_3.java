package com.ginvaell.module1.task3;

import java.util.Scanner;

public class Task1_3 {
    private static Scanner in;
    public static void main(String[] args) {
        double a = 0;
        double b = 0;
        double h = 0;
        try(Scanner scanner = new Scanner(System.in) ) {
            in = scanner;
            a = read("a");
            b = read("b");
            if(b - a < 0) {
                System.out.print("b should be greater then a!");
                System.exit(0);
            }
            h = read("h");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(h > b-a) {
            System.out.print("h should be less then b-a!");
            System.exit(0);
        }

        for (double x = a; x <= b; x+= h) {
            System.out.format("%9.5f  %9.5f%n", x, Math.tan(2*x)+3);
        }


    }

    private static double read(String varName) {
        System.out.print("Please, enter "+varName+": ");
        if(in.hasNextDouble()) {
            return in.nextDouble();
        }
        else {
            System.out.print("Wrong Input! Not a Number!");
            System.exit(0);
            return 0;
        }
    }
}
