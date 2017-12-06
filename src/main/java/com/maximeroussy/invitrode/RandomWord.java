package com.maximeroussy.invitrode;

import com.maximeroussy.invitrode.pick.RandomPick;

/**
 * Created by maximeroussy on 17/02/16.
 */
public class RandomWord {
    /**
     * @param wordLength the desired word length
     * @return a random word
     * @throws WordLengthException when the word size does is not between 3 and 15
     */
    public static String getNewWord(int wordLength) throws WordLengthException {
        try {
            return new RandomWord(wordLength).toString();
        } catch (IllegalArgumentException e) {
            throw new WordLengthException(e);
        }
    }

    private final WordLength wordLength;
    private final WordGenerator wordGenerator;

    public RandomWord() {
        this(new WordLength());
    }

    public RandomWord(int wordLength) {
        this(new WordLength(wordLength));
    }

    public RandomWord(WordLength wordLength) {
        this.wordLength = wordLength;
        this.wordGenerator = new WordGenerator(new RandomPick());
    }

    public String get() {
        return toString();
    }

    @Override
    public String toString() {
        return wordGenerator.generateWord(wordLength);
    }

}
