package com.ginvaell.module1.task5;

import java.util.Scanner;

public class Task1_5 {

    private static Scanner in;
    private static int n;
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            in = scanner;
            n = read("n");
        }
        int[][] a = new int[n][n];

        for (int i = 0; i < n/2+1; i++) {
            a[i][i] = 1;
            a[i][n-i-1] = 1;
            a[n-i-1][i] = 1;
            a[n-i-1][n-i-1]=1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println("");
        }
    }

    private static int read(String varName) {
        System.out.print("Please, enter "+varName+": ");
        if(in.hasNextInt()) {
            return in.nextInt();
        }
        else {
            System.out.print("Wrong Input! Not a Number!");
            System.exit(0);
            return 0;
        }
    }
}
