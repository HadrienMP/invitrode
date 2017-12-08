package com.maximeroussy.invitrode.pick;

import java.util.Random;

public class RandomPick implements Pick {
    @Override
    public int positiveIntegerBelow(int max) {
        return new Random().nextInt(max);
    }
}
