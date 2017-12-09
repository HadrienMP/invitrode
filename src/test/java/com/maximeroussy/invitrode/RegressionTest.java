package com.maximeroussy.invitrode;

import com.maximeroussy.invitrode.pick.PositiveIntegerRecord;
import com.maximeroussy.invitrode.pick.PositiveIntegerReplay;
import com.maximeroussy.invitrode.pick.RandomPositiveInteger;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitQuickcheck.class)
public class RegressionTest {

    @Property(trials = 100000)
    public void double_run(@InRange(min = "3", max = "15") int length) throws Exception {
        WordLength wordLength = new WordLength(length);

        // Legacy
        PositiveIntegerRecord record = new PositiveIntegerRecord(new RandomPositiveInteger());
        String expected = new LegacyWordGenerator(record).generateWord(wordLength);

        // Refactor
        PositiveIntegerReplay replay = record.replay();
        String actual = new WordGenerator(replay).generateWord(wordLength);

        // Check
        assertThat(actual).isEqualTo(expected);
    }
}
