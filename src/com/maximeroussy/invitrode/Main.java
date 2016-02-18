package com.maximeroussy.invitrode;

public class Main {

    public static void main(String[] args) {
        RandomWord randomWordClass = new RandomWord();
        String newWord = randomWordClass.getNewWord(4);
        System.out.println(newWord);
    }

}
