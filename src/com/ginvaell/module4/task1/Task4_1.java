package com.ginvaell.module4.task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Task4_1 {
    public static void main(String[] args) {
        File file = new File("src\\com\\ginvaell\\module4\\task1\\keyWords.txt");
        File progFile = new File("src\\com\\ginvaell\\module4\\task1\\KeyWordsCounter.java");
        File outputFile = new File("src\\com\\ginvaell\\module4\\task1\\out.txt");
        KeyWordsCounter javaKeyWordsCounter;
        try {
            javaKeyWordsCounter = new KeyWordsCounter(progFile, file);

            try {
                javaKeyWordsCounter.parseWithReader();

                javaKeyWordsCounter.printAll();
                javaKeyWordsCounter.printUsed();

                try {
                    javaKeyWordsCounter.printToFileWithWriter(outputFile);


                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                System.out.println("File with text to handle is not found!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File with key words is not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
