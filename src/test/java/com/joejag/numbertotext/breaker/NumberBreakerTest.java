package com.joejag.numbertotext.breaker;

import org.junit.Test;

import static com.joejag.numbertotext.breaker.NumberComponent.NumberComponentPart.HUNDREDS;
import static junit.framework.Assert.assertEquals;

public class NumberBreakerTest {

    @Test
    public void number_in_the_hundreds_returns_just_itself() {
        NumberComponents components = new NumberBreaker().breakDown(100);
        assertEquals(1, components.components.size());
        assertEquals(100, components.components.get(0).number);
        assertEquals(HUNDREDS, components.components.get(0).part);
    }
}
