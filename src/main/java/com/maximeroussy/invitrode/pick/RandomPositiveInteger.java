package com.maximeroussy.invitrode.pick;

import java.util.Random;

public class RandomPositiveInteger implements PositiveInteger {
    @Override
    public int below(int max) {
        return new Random().nextInt(max);
    }
}
