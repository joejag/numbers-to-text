package com.joejag.numbertotext.breaker;

public class NumberComponent {

    public enum Part {
        MILLION, THOUSAND, HUNDRED
    }

    public final Part part;
    public final int number;

    NumberComponent(Part part, int number) {
        this.part = part;
        this.number = number;
    }
}
