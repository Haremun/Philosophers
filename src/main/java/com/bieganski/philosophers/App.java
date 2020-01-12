package com.bieganski.philosophers;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Chopsticks chopsticks = new Chopsticks(List.of(
                new Chopstick(),
                new Chopstick(),
                new Chopstick(),
                new Chopstick(),
                new Chopstick()
        ));
        List<Thread> philosophers = new ArrayList<>();
        List.of("Kamil", "Janek", "Andrzej", "Franek", "Zbyszek").forEach(x -> {
            Philosopher philosopher = new Philosopher(chopsticks);
            philosophers.add(new Thread(philosopher, x));
        });
        philosophers.forEach(x -> {
            x.start();
        });
    }
}
