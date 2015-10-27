package com.ginvaell.module5.task2;


public class Task5_2 {

    public static void main(String[] args) {

        PropertiesBundle bundle = new PropertiesBundle("src\\com\\ginvaell\\module5\\task2\\properties");

        new Thread(new PropertiesUser("words", bundle)).start();
        new Thread(new PropertiesUser("words", bundle)).start();
        new Thread(new PropertiesUser("colors", bundle)).start();
        new Thread(new PropertiesUser("colors", bundle)).start();
        new Thread(new PropertiesUser("qw", bundle)).start();


    }

}
