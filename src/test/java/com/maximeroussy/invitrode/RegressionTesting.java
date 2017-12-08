package com.maximeroussy.invitrode;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

@RunWith(JUnitQuickcheck.class)
public class RegressionTesting {

    @Property(trials = 10000)
    public void the_generation_should_never_crash() throws Exception {
        new RandomWord();
    }
}
