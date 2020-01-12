package com.bieganski.philosophers;

public class Chopstick {
    private String name;
    public Chopstick() {
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
