package com.maximeroussy.invitrode.pick;

import java.util.Random;

public class RandomPick implements Pick {
    @Override
    public String in(String[] strings) {
        if (strings.length == 0) throw new IllegalArgumentException("The list cannot be empty");
        return strings[new Random().nextInt(strings.length)];
    }
}
