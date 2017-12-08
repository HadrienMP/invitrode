package com.maximeroussy.invitrode;

import com.maximeroussy.invitrode.pick.FirstElementPick;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WordGeneratorTest {

    @Test
    public void the() throws Exception {
        WordGenerator wordGenerator = new WordGenerator(new FirstElementPick());
        String word = wordGenerator.generateWord(new WordLength(3));
        assertThat(word).isEqualTo("THE");
    }
}