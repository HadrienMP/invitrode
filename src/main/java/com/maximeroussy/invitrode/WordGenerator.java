package com.maximeroussy.invitrode;

import com.maximeroussy.invitrode.pick.Pick;

import static com.maximeroussy.invitrode.PronounceableChars.BIGRAM_INDEXES;
import static com.maximeroussy.invitrode.PronounceableChars.PRONOUNCEABLE_NEXT_CHARACTERS;
import static com.maximeroussy.invitrode.PronounceableChars.START_BI_GRAM;
import static java.util.Arrays.asList;

class WordGenerator {

    private static final int BIGRAM_LENGTH = 2;

    private final Pick pick;

    WordGenerator(Pick pick) {
        this.pick = pick;
    }

    String generateWord(WordLength wordLength) {
        String word="e";
        while (word.equals("e")) {
            try {
                word = generateRandomWord(wordLength);
            } catch (Exception e) {
            }
        }
        return word;
    }

    private String generateRandomWord(WordLength wordLength) {
        String randomWord = itemFrom(START_BI_GRAM);
        int flag=0;
        int count=0;
        String previousWord;
        while (randomWord.length()!=wordLength.wordLength) {
            previousWord = randomWord;
            randomWord = addCharacter(wordLength, randomWord, flag);
            if(previousWord.equals(randomWord)) {
                count++;
            } else {
                flag = 0;
            }
            if(count == 5){
                flag = 1;
                count++;
            } else if (count==20){
                randomWord = itemFrom(START_BI_GRAM);
                count = 0;
            }
        }
        return randomWord;
    }

    private String addCharacter(WordLength desiredLength, String currentWord, int flag) {
        boolean lastCharacter = false;
        if (oneCharacterLeft(desiredLength, currentWord)) {
            lastCharacter = true;
        }

        // Cas particulier chelou
        // TODO HMP: 08/12/2017 le cas cas unknown bigram devrait être testé autrement si possible
        while (isUnknownBigram(lastBigram(currentWord)) || noPossibleNextCharacter(currentWord, lastCharacter)) {

            if (isBigram(currentWord)) {
                return itemFrom(START_BI_GRAM);
            }
            if (flag == 1) {
                currentWord = backtrack(currentWord, BIGRAM_LENGTH);
                flag = 0;
            } else {
                currentWord = backtrack(currentWord, 1);
            }
            lastCharacter = false;
            }

        return currentWord + nextCharacter(lastCharacter, currentWord);
        }

    private static boolean isBigram(String currentWord) {
        return currentWord.length() == BIGRAM_LENGTH;
    }

    private static boolean oneCharacterLeft(WordLength desiredLength, String currentWord) {
        return currentWord.length() == (desiredLength.wordLength - 1);
    }

    private static boolean isUnknownBigram(String bigram) {
        // TODO HMP: 08/12/2017 ici on devrait logger pour permettre de corriger l'erreur
        return bigramIndex(bigram) < 0 ||
                bigramIndex(bigram) > BIGRAM_INDEXES.length;
    }

    private static boolean noPossibleNextCharacter(String currentWord, boolean lastCharacter) {
        return nextPronounceableCharacters(currentWord, lastCharacter).length <= 0;
    }

    // TODO HMP: 08/12/2017 faire un type bigram

    private static String backtrack(String string, int numberChars) {
        return string.substring(0, string.length() - numberChars);
    }

    // #############################################################

    // Next character

    // #############################################################


    private String nextCharacter(boolean lastCharacter, String word) {
        return itemFrom(nextPronounceableCharacters(word, lastCharacter));
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
        if (isBigram(word)) {
            return word;
        } else {
            return word.substring(word.length() - BIGRAM_LENGTH);
        }
    }

    private static int bigramIndex(String bigram) {
        return asList(BIGRAM_INDEXES).indexOf(bigram);
    }

    public String itemFrom(String[] strings) {
        return strings[pick.positiveIntegerBelow(strings.length)];
    }
}
