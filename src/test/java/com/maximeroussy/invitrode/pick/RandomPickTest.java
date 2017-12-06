package com.maximeroussy.invitrode.pick;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomPickTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private RandomPick randomPick = new RandomPick();

    @Test
    public void should_pick_an_element_from_the_list() throws Exception {
        String[] elements = {"fee", "fi", "fo"};
        String pick = randomPick.in(elements);
        assertThat(pick).isIn(elements);
    }

    @Test
    public void should_throw_an_exception_for_an_empty_list() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The list cannot be empty");

        randomPick.in(new String[0]);
    }

    @Test
    public void should_pick_the_first_element_when_the_list_contains_a_single_element() throws Exception {
        String onlyElement = "toto";
        String pick = randomPick.in(new String[]{onlyElement});
        assertThat(pick).isEqualTo(onlyElement);
    }
}