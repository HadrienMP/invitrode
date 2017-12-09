package com.maximeroussy.invitrode.pick;

public class Pick {
    private final PositiveInteger positiveInteger;

    public Pick(PositiveInteger positiveInteger) {
        this.positiveInteger = positiveInteger;
    }

    public String itemFrom(String[] strings) {
        if (strings.length == 0) {
            throw new NoPickableElementException();
        }
        return strings[positiveInteger.below(strings.length)];
    }

    public static class NoPickableElementException extends RuntimeException {}
}
