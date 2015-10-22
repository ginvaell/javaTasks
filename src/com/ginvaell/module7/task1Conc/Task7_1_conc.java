package com.ginvaell.module7.task1Conc;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class Task7_1_conc {
    public static void main(String[] args) {
        File file = new File("src\\com\\ginvaell\\module7\\task1Conc\\transactions.txt");
        try (Scanner in = new Scanner(file)) {

            Map<Integer, Account> accounts = new HashMap<>();
            for (int i = 1; i <= 9; i++) {
                accounts.put(i, new Account(10));
            }

            List<Future<Integer>> futures = new ArrayList<>();

            ExecutorService es = Executors.newCachedThreadPool();
            for (int i = 0; i < 3; i++) {
                futures.add(es.submit(new TransHandler(i, in, accounts)));
            }
            es.shutdown();
            for (Future<Integer> f : futures) {
                try {
                    f.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(accounts);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
