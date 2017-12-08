package com.maximeroussy.invitrode;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitQuickcheck.class)
public class RandomWordProperties {

    @Property
    public void a_word_is_never_blank() {
        assertThat(toString(new RandomWord())).isNotEmpty();
    }

    @Property
    public void a_word_has_always_the_requested_size(@InRange(min = "3", max = "15") int wordLength) {
        assertThat(toString(new RandomWord(wordLength))).hasSize(wordLength);
    }

    private String toString(RandomWord randomWord) {
        return randomWord.toString().trim();
    }
}
