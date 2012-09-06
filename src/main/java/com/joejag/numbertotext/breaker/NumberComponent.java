package com.joejag.numbertotext.breaker;

public class NumberComponent {

    public enum NumberComponentPart {
        MILLIONS, THOUSANDS, HUNDREDS
    }

    public final NumberComponentPart part;
    public final int number;

    NumberComponent(NumberComponentPart part, int number) {
        this.part = part;
        this.number = number;
    }
}
