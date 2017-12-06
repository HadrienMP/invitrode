package com.maximeroussy.invitrode;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

@RunWith(JUnitQuickcheck.class)
public class WordLengthProperties {

    @Property
    public void the_default_constructor_should_never_throw_exceptions() {
        new WordLength();
    }

}