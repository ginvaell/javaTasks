package com.ginvaell.module3.task2;


import java.util.Locale;
import java.util.Scanner;

public class Task3_2 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("1. English");
            System.out.println("2. Русский");

            if (in.hasNextInt()) {
                int l = in.nextInt();
                Locale locale;
                switch (l) {
                    case 1:
                        locale = new Locale("en", "US");
                        break;
                    case 2:
                        locale = new Locale("ru", "RU");
                        break;
                    default:
                        return;

                }
                ResourceQuestion question = new ResourceQuestion(locale);
                ResourceAnswer answer = new ResourceAnswer(locale);
                for (int i = 1; i <= 5; i++) {
                    System.out.println(question.getValue("" + i));
                }
                System.out.println(question.getValue("question"));

                if (in.hasNextInt()) {
                    int q = in.nextInt();
                    if (q >= 1 && q <= 5) {
                        System.out.println(answer.getValue("" + q));
                    }
                }

            }
        }
    }
}
