package com.ginvaell.module2.task2;

import java.util.Scanner;

public class Task2_2 {

    public static void main(String[] args) {
        Company co = new Company();
        Employee employee = null;
        String command;
        String name;
        String empName = " ";
        double price;
        int count;
        boolean working = true;
        try (Scanner in = new Scanner(System.in)) {
            while (working) {
                System.out.println(empName + ">> ");
                command = in.next();
                switch (command) {
                    case "addE":
                        System.out.print("employee name: ");
                        name = in.next();
                        if (!co.addEmployee(employee = new Employee(name))) {
                            System.out.println("Employee with such name is already existed!");
                        } else {
                            System.out.println("Added!");
                            empName = name;
                        }

                        break;
                    case "chooseE":
                        System.out.print("employee name: ");
                        name = in.next();
                        if ((employee = co.getEmployee(name)) == null) {
                            System.out.println("Employee with such name does not exist!");
                        } else {
                            empName = name;
                        }
                        break;
                    case "printAll":
                        System.out.println(co.toString());
                        break;
                    case "add":
                        if (employee == null) {
                            System.out.println("Choose employee first");
                        } else {
                            System.out.print("item name: ");
                            name = in.next();
                            System.out.print("price: ");
                            if (in.hasNextDouble()) {
                                price = in.nextDouble();
                            } else {
                                System.out.println("Wrong input! Price should be a number!");
                                in.next();
                                break;
                            }
                            System.out.print("count: ");
                            if (in.hasNextInt()) {
                                count = in.nextInt();
                            } else {
                                System.out.println("Wrong input! Count should be a number!");
                                in.next();
                                break;
                            }

                            employee.addItem(new Item(name, price, count));
                            System.out.println("Added!");
                        }
                        break;
                    case "delete":
                        if (employee == null) {
                            System.out.println("Choose employee first");
                        } else {
                            System.out.print("item name: ");
                            name = in.next();
                            System.out.print("count: ");
                            if (in.hasNextInt()) {
                                count = in.nextInt();
                            } else {
                                System.out.println("Wrong input! Count should be a number!");
                                in.next();
                                break;
                            }
                            if (!employee.deleteItem(name, count)) {
                                System.out.println("Item with such name does not exist!");
                            } else {
                                System.out.println("Deleted!");
                            }
                        }
                        break;
                    case "getTotalCost":
                        if (employee == null) {
                            System.out.println("Choose employee first");
                        } else {
                            System.out.println(employee.getTotalCost());
                        }
                        break;
                    case "print":
                        if (employee == null) {
                            System.out.println("Choose employee first");
                        } else {
                            System.out.println(employee.toString());
                        }
                        break;
                    case "end":
                        working = false;

                }
            }
        }

    }
}
