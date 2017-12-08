package com.maximeroussy.invitrode.pick;

import java.util.LinkedList;
import java.util.Queue;

public class PickRecord implements Pick {

    private final Queue<PickCall> pickCalls = new LinkedList<PickCall>();
    private final Pick pick;

    public PickRecord(Pick pick) {
        this.pick = pick;
    }

    @Override
    public int positiveIntegerBelow(int max) {
        int picked = pick.positiveIntegerBelow(max);
        pickCalls.add(new PickCall(max, picked));
        return picked;
    }

    public PickReplay replay() {
        return new PickReplay(pickCalls);
    }
}
