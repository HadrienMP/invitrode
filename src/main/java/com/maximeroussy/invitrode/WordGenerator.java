package com.maximeroussy.invitrode;

import com.maximeroussy.invitrode.pick.Pick;
import com.maximeroussy.invitrode.pick.PositiveInteger;

import static com.maximeroussy.invitrode.PronounceableChars.BIGRAM_INDEXES;
import static com.maximeroussy.invitrode.PronounceableChars.PRONOUNCEABLE_NEXT_CHARACTERS;
import static com.maximeroussy.invitrode.PronounceableChars.START_BI_GRAM;
import static java.util.Arrays.asList;

class WordGenerator {

    private static final int BIGRAM_LENGTH = 2;
    private static final int MAX_ATTEMPTS_TO_ATTAIN_LENGTH = 20;

    private final Pick pick;

    WordGenerator(PositiveInteger positiveInteger) {
        pick = new Pick(positiveInteger);
    }

    String generateWord(WordLength wordLength) {
        try {
            return generateRandomWord(wordLength);
        } catch (TooSmallWordException e) {
            return generateWord(wordLength);
        } catch (FailedTooManyTimesException e) {
            return generateWord(wordLength);
        }
    }

    private String generateRandomWord(WordLength wordLength) {
        String randomWord = pick.itemFrom(START_BI_GRAM);

        boolean drop2Chars = false;
        int numberOfAttempts = 0;
        String previousWord;

        while (randomWord.length() != wordLength.wordLength) {
            previousWord = randomWord;

            randomWord = addCharacter(wordLength, randomWord, drop2Chars);

            if (previousWord.equals(randomWord)) {
                numberOfAttempts++;
            } else {
                drop2Chars = false;
            }

            if (numberOfAttempts == 5) {
                drop2Chars = true;
                numberOfAttempts++;
            }

            if (numberOfAttempts == MAX_ATTEMPTS_TO_ATTAIN_LENGTH) {
                throw new FailedTooManyTimesException();
            }
        }

        return randomWord;
    }

    private String addCharacter(WordLength desiredLength, String currentWord, boolean drop2Chars) {
        // TODO HMP: 08/12/2017 le cas cas unknown bigram devrait être testé autrement si possible
        while (isUnknownBigram(lastBigram(currentWord)) || noPossibleNextCharacter(currentWord, desiredLength)) {

            if (isBigram(currentWord)) {
                return pick.itemFrom(START_BI_GRAM);
            }

            int charsToCut = charsToCut(drop2Chars);
            currentWord = backtrack(currentWord, charsToCut);
            drop2Chars = false;
        }

        return currentWord + nextCharacter(currentWord, desiredLength);
    }

    private int charsToCut(boolean drop2Chars) {
        return drop2Chars ? BIGRAM_LENGTH : 1;
    }

    private boolean isLastCharacter(WordLength desiredLength, String currentWord) {
        return currentWord.length() == (desiredLength.wordLength - 1);
    }

    private static boolean isBigram(String currentWord) {
        return currentWord.length() == BIGRAM_LENGTH;
    }

    // TODO HMP: 08/12/2017 faire un type bigram

    private static String backtrack(String string, int numberChars) {
        return string.substring(0, string.length() - numberChars);
    }

    // #############################################################

    // Next character

    // #############################################################

    private static boolean isUnknownBigram(String bigram) {
        // TODO HMP: 08/12/2017 ici on devrait logger pour permettre de corriger l'erreur
        return bigramIndex(bigram) < 0 ||
                bigramIndex(bigram) > BIGRAM_INDEXES.length;
    }

    private boolean noPossibleNextCharacter(String currentWord, WordLength desiredLength) {
        return nextPronounceableCharacters(currentWord, isLastCharacter(desiredLength, currentWord)).length <= 0;
    }


    private String nextCharacter(String word, WordLength desiredLength) {
        return pick.itemFrom(nextPronounceableCharacters(word, isLastCharacter(desiredLength, word)));
    }

    private static String[] nextPronounceableCharacters(String currentWord, boolean lastCharacter) {
        return nextPronounceableCharactersLists(currentWord)[lastCharacter ? 1 : 0];
    }

    private static String[][] nextPronounceableCharactersLists(String currentWord) {
        String lastBigram = lastBigram(currentWord);
        int bigramIndex = bigramIndex(lastBigram);
        return PRONOUNCEABLE_NEXT_CHARACTERS[bigramIndex];
    }

    private static String lastBigram(String word) {
        if (word.length() < BIGRAM_LENGTH) {
            throw new TooSmallWordException();
        } else {
            return word.substring(word.length() - BIGRAM_LENGTH);
        }
    }

    private static int bigramIndex(String bigram) {
        return asList(BIGRAM_INDEXES).indexOf(bigram);
    }

    private static class TooSmallWordException extends RuntimeException {}
    private class FailedTooManyTimesException extends RuntimeException {}
}
