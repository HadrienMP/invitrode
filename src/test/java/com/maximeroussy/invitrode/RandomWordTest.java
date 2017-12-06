package com.maximeroussy.invitrode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomWordTest {

    @Test
    public void should_generate_a_word_of_a_required_size() throws Exception {
        int expectedWordSize = 5;

        String word = new RandomWord(expectedWordSize).toString();

        assertThat(word).hasSize(expectedWordSize);
    }

    @Test(expected = WordLengthException.class)
    public void the_legacy_generator_should_throw_a_word_length_exception_when_word_length_is_too_big() throws Exception {
         RandomWord.getNewWord(16);
    }
}
