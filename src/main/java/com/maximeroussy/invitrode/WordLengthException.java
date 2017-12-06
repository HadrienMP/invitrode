package com.maximeroussy.invitrode;

/**
 * Created by maximer on 29/02/16.
 */
public class WordLengthException extends Exception {
    public WordLengthException(IllegalArgumentException e) {
        super(e);
    }
}
