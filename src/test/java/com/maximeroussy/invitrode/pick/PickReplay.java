package com.maximeroussy.invitrode.pick;

import java.util.Queue;

public class PickReplay implements Pick {
    private final Queue<PickCall> pickCalls;

    public PickReplay(Queue<PickCall> pickCalls) {
        this.pickCalls = pickCalls;
    }

    @Override
    public int positiveIntegerBelow(int max) {
        PickCall call = pickCalls.remove();
        if (call.parameter != max) {
            throw new IllegalArgumentException("Le code refactor a demande " + max + " au lieu de " + call.parameter);
        }
        return call.result;
    }
}
