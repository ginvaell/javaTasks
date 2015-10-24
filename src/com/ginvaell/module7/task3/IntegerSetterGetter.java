package com.ginvaell.module7.task3;

import java.util.Random;

public class IntegerSetterGetter extends Thread {
    private static int n;
    private static int count;
    private static int part;
    private final SharedResource resource;
    private boolean run;

    private final Random rand = new Random();

    public IntegerSetterGetter(String name, SharedResource resource) {
        super(name);
        this.resource = resource;
        run = true;
        n++;
        count++;
        part = count / 5;
        if (part == 0) part = 1;
    }

    public void stopThread() {
        run = false;
    }

    public void run() {
        int action;

        try {
            while (run) {
                action = rand.nextInt(1000);
                if (action % 2 == 0) {
                    getIntegersFromResource();
                } else {
                    setIntegersIntoResource();
                }
            }
            System.out.println("Поток " + getName() + " завершил работу.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void getIntegersFromResource() throws InterruptedException {
        Integer number;

        synchronized (resource) {
            System.out.println("Поток " + getName()
                    + " хочет извлечь число.");
            if (n <= part) {
                System.out.println("Поток " + getName()
                        + " не смог извлечь число.");
                return;
            }
            number = resource.getELement();
            n--;
            while (number == null) {
                System.out.println("Поток " + getName()
                        + " ждет пока очередь заполнится.");
                resource.wait();
                System.out
                        .println("Поток " + getName() + " возобновил работу.");
                number = resource.getELement();
            }
            n++;
            System.out
                    .println("Поток " + getName() + " извлек число " + number);
        }
    }

    private void setIntegersIntoResource() {
        Integer number = rand.nextInt(500);
        synchronized (resource) {
            resource.setElement(number);
            System.out.println("Поток " + getName() + " записал число "
                    + number);
            resource.notify();
        }
    }

}

