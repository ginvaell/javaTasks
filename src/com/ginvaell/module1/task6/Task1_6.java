package com.ginvaell.module1.task6;

import java.util.Scanner;

public class Task1_6 {

    public static void main(String[] args) {

        Notebook notebook = new Notebook();
        String command;
        String title;
        String text;
        boolean working = true;
        try (Scanner in = new Scanner(System.in)) {
            while (working) {
                command = in.next();
                switch (command) {
                    case "add":
                        System.out.print("title: ");
                        title = in.next();
                        System.out.print("text: ");
                        text = in.next();
                        if (!notebook.addRecord(title, text)) {
                            System.out.println("Record with such title is already existed!");
                        } else {
                            System.out.println("Added!");
                        }
                        break;
                    case "printAll":
                        System.out.println(notebook.toString());
                        break;
                    case "edit":
                        System.out.print("title: ");
                        title = in.next();
                        System.out.print("new text: ");
                        text = in.next();
                        if (!notebook.editRecord(title, text)) {
                            System.out.println("Record with such title does not exist!");
                        } else {
                            System.out.println("Edited!");
                        }
                        break;
                    case "delete":
                        System.out.print("title: ");
                        title = in.next();
                        if (!notebook.deleteRecord(title)) {
                            System.out.println("Record with such title does not exist!");
                        } else {
                            System.out.println("Deleted!");
                        }
                        break;
                    case "print":
                        System.out.print("title: ");
                        title = in.next();
                        if ((text = notebook.readRecord(title)) == null) {
                            System.out.println("Record with such title does not exist!");
                        } else {
                            System.out.println(text);
                        }
                        break;
                    case "end":
                        working = false;
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
