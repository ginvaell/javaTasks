package com.ginvaell.module4.task3;

import java.io.File;
import java.io.IOException;

public class Task4_3 {
    public static void main(String[] args) {
        File input = new File("src\\com\\ginvaell\\module4\\task3\\in.txt");
        File output = new File("src\\com\\ginvaell\\module4\\task3\\out.txt");

        Converter converter = new Converter(input, output);
        try {
            converter.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        converter.printReadText();

        try {
            converter.writeFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
