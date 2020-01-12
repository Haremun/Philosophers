package com.bieganski.philosophers;

import java.util.List;

public class Chopsticks {
    private List<Chopstick> chopsticks;

    public Chopsticks(List<Chopstick> chopsticks) {
        this.chopsticks = chopsticks;
    }
    synchronized Chopstick obtainChopstick(int index){
        return index < chopsticks.size() ? chopsticks.get(index) : chopsticks.get(0);
    }
}
