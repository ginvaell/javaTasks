package com.ginvaell.module3.task1;

public class Task3_1 {
    public static void main(String[] args) {
        CrazyLogger logger = new CrazyLogger();
        logger.addMessage("Hello");
        logger.addMessage("I`m super Logger");
        logger.addMessage("The Hell is hot!");
        System.out.println(logger);
        System.out.println(logger.searchForFragment("el"));
        System.out.println(logger.searchForFragment("!"));
    }
}
