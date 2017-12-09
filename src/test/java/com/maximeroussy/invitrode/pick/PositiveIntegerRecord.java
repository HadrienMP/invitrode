package com.maximeroussy.invitrode.pick;

import java.util.LinkedList;
import java.util.Queue;

public class PositiveIntegerRecord implements PositiveInteger {

    private final Queue<PickCall> pickCalls = new LinkedList<PickCall>();
    private final PositiveInteger positiveInteger;

    public PositiveIntegerRecord(PositiveInteger positiveInteger) {
        this.positiveInteger = positiveInteger;
    }

    @Override
    public int below(int max) {
        int picked = positiveInteger.below(max);
        pickCalls.add(new PickCall(max, picked));
        return picked;
    }

    public PositiveIntegerReplay replay() {
        return new PositiveIntegerReplay(pickCalls);
    }
}
