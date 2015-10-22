package com.ginvaell.module7.task1;

import java.io.*;
import java.util.*;

public class Task7_1 {
    public static void main(String[] args) {
        File file = new File("src\\com\\ginvaell\\module7\\task1\\transactions.txt");
        try (Scanner in = new Scanner(file)) {

            Map<Integer, Account> accounts = new HashMap<>();
            for (int i = 1; i <= 9; i++) {
                accounts.put(i, new Account(10));
            }

            List<Thread> transHandlers = new ArrayList<>(3);
            for (int i = 0; i < 3; i++) {

                transHandlers.add(new Thread(new TransHandler(i, in, accounts)));
            }
            transHandlers.forEach(java.lang.Thread::start);


            transHandlers.forEach((thread) -> {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });


            System.out.println(accounts);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
