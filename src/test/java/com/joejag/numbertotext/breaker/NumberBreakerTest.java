package com.joejag.numbertotext.breaker;

import org.junit.Test;

import static com.joejag.numbertotext.breaker.NumberComponent.NumberComponentPart.*;
import static junit.framework.Assert.assertEquals;

public class NumberBreakerTest {

    @Test
    public void number_in_the_hundreds_returns_just_itself() {
        NumberComponents components = new NumberBreaker().breakDown(100);
        assertEquals(1, components.components.size());

        assertPart(components.components.get(0), 100, HUNDRED);
    }

    @Test
    public void number_in_the_thousands_returns_two_parts() {
        NumberComponents components = new NumberBreaker().breakDown(1100);
        assertEquals(2, components.components.size());

        assertPart(components.components.get(0), 1, THOUSAND);
        assertPart(components.components.get(1), 100, HUNDRED);
    }

    @Test
    public void number_in_the_millions_returns_three_parts() {
        NumberComponents components = new NumberBreaker().breakDown(100100100);
        assertEquals(3, components.components.size());

        assertPart(components.components.get(0), 100, MILLION);
        assertPart(components.components.get(1), 100, THOUSAND);
        assertPart(components.components.get(2), 100, HUNDRED);
    }

    @Test
    public void number_without_thousands_misses_them_out() {
        NumberComponents components = new NumberBreaker().breakDown(10000020);
        assertEquals(2, components.components.size());

        assertPart(components.components.get(0), 10, MILLION);
        assertPart(components.components.get(1), 20, HUNDRED);
    }

    private void assertPart(NumberComponent component, int expectedNumber, NumberComponent.NumberComponentPart expectedPart) {
        assertEquals(expectedNumber, component.number);
        assertEquals(expectedPart, component.part);
    }
}
