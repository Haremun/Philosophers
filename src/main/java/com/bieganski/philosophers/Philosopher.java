package com.bieganski.philosophers;

public class Philosopher implements Runnable {
    private int index;
    private static int philosopherCounter;
    private Chopsticks chopsticks;
    private final Chopstick chopstick1;
    private final Chopstick chopstick2;

    public Philosopher(Chopsticks chopsticks) {
        this.index = philosopherCounter++;
        this.chopsticks = chopsticks;
        chopstick1 = chopsticks.obtainChopstick(index);
        chopstick2 = chopsticks.obtainChopstick(index + 1);
    }

    @Override
    public void run() {
        System.out.println(index);
        synchronized (chopstick1) {
            try {
                System.out.println("Pick up left " + index);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (chopstick2) {
                try {
                    System.out.println("Pick up right " + index++);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " eats");
            }
        }
    }
}
