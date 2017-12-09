package com.maximeroussy.invitrode.pick;

import java.util.Queue;

public class PositiveIntegerReplay implements PositiveInteger {
    private final Queue<PickCall> pickCalls;

    public PositiveIntegerReplay(Queue<PickCall> pickCalls) {
        this.pickCalls = pickCalls;
    }

    @Override
    public int below(int max) {
        PickCall call = pickCalls.remove();
        if (call.parameter != max) {
            throw new IllegalArgumentException("Le code refactor a demande " + max + " au lieu de " + call.parameter);
        }
        return call.result;
    }
}
