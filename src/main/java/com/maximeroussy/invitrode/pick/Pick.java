package com.maximeroussy.invitrode.pick;

public class Pick {
    private final PositiveInteger positiveInteger;

    public Pick(PositiveInteger positiveInteger) {
        this.positiveInteger = positiveInteger;
    }

    public String itemFrom(String[] strings) {
        return strings[positiveInteger.below(strings.length)];
    }
}
