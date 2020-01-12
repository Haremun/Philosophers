package com.bieganski.philosophers;

public class Philosopher implements Runnable {
    private int index;
    private static int philosopherCounter;
    private final Chopstick chopstick1;
    private final Chopstick chopstick2;

    public Philosopher(Chopsticks chopsticks) {
        this.index = philosopherCounter++;
        if (index < 4) {
            chopstick1 = chopsticks.obtainChopstick(index);
            chopstick1.setName("Left");
            chopstick2 = chopsticks.obtainChopstick(index + 1);
            chopstick2.setName("Right");
        } else {
            chopstick1 = chopsticks.obtainChopstick(index + 1);
            chopstick1.setName("Right");
            chopstick2 = chopsticks.obtainChopstick(index);
            chopstick2.setName("Left");
        }
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + chopstick1);
        synchronized (chopstick1) {
            pickUp(chopstick1);
            synchronized (chopstick2) {
                pickUp(chopstick2);
                System.out.println(Thread.currentThread().getName() + " eats");
            }
        }
    }

    private void pickUp(Chopstick chopstick) {
        try {
            System.out.println(index + " " + Thread.currentThread().getName() + " picks up " + chopstick);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
