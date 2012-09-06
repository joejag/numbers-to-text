package com.joejag.numbertotext.breaker;

import org.junit.Test;

import java.util.List;

import static com.joejag.numbertotext.breaker.NumberComponent.Part.*;
import static junit.framework.Assert.assertEquals;

public class NumberBreakerTest {

    @Test
    public void number_in_the_hundreds_returns_just_itself() {
        List<NumberComponent> components = new NumberBreaker().breakDown(100);

        assertEquals(1, components.size());
        assertPart(components.get(0), 100, HUNDRED);
    }

    @Test
    public void number_in_the_thousands_returns_two_parts() {
        List<NumberComponent> components = new NumberBreaker().breakDown(1100);

        assertEquals(2, components.size());
        assertPart(components.get(0), 1, THOUSAND);
        assertPart(components.get(1), 100, HUNDRED);
    }

    @Test
    public void number_in_the_millions_returns_three_parts() {
        List<NumberComponent> components = new NumberBreaker().breakDown(100100100);

        assertEquals(3, components.size());
        assertPart(components.get(0), 100, MILLION);
        assertPart(components.get(1), 100, THOUSAND);
        assertPart(components.get(2), 100, HUNDRED);
    }

    @Test
    public void number_without_thousands_misses_them_out() {
        List<NumberComponent> components = new NumberBreaker().breakDown(10000020);

        assertEquals(2, components.size());
        assertPart(components.get(0), 10, MILLION);
        assertPart(components.get(1), 20, HUNDRED);
    }

    private void assertPart(NumberComponent component, int expectedNumber, NumberComponent.Part expectedPart) {
        assertEquals(expectedNumber, component.number);
        assertEquals(expectedPart, component.part);
    }
}
