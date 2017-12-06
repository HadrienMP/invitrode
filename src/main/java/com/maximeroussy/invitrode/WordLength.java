package com.maximeroussy.invitrode;

import java.util.Random;

public class WordLength {
    private static final int MIN = 3;
    private static final int MAX = 15;

    final int wordLength;

    /**
     * @param wordLength the expected word length, must be between 3 and 15, an IllegalArgumentException is thrown otherwise
     */
    public WordLength(int wordLength) {
        this.wordLength = wordLength;
        if (wordLength < MIN || wordLength > MAX) {
            throw new IllegalArgumentException("Word length error, words must be between 3 and 15 characters long.");
        }
    }

    public WordLength() {
        this(new Random().nextInt(MAX - MIN) + MIN);
    }
}
