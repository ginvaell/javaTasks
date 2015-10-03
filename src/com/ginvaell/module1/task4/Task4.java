package com.ginvaell.module1.task4;

public class Task4 {

    public static void main(String[] args) {
	    //lab 1-4
        double[] a = {1, 2, 20, 0, 5, 3};
        double max = Double.MIN_VALUE;
        int n = a.length;
        for (int i = 0; i < n/2; i++) {
            if(a[i]+a[n-1-i] > max) {
                max = a[i]+a[n-1-i];
            }
        }
        System.out.print(max);

    }
}
