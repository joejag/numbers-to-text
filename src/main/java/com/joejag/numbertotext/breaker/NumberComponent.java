package com.joejag.numbertotext.breaker;

public class NumberComponent {

    public final Part part;
    public final int number;

    NumberComponent(Part part, int number) {
        this.part = part;
        this.number = number;
    }

    public enum Part {
        MILLION(9, 6), THOUSAND(6, 3), HUNDRED(3, 0);

        private int startIndexInNumber;
        private int endIndexInNumber;

        Part(int startIndexInNumber, int endIndexInNumber) {

            this.startIndexInNumber = startIndexInNumber;
            this.endIndexInNumber = endIndexInNumber;
        }

        public int getStartIndexInNumber() {
            return startIndexInNumber;
        }

        public int getEndIndexInNumber() {
            return endIndexInNumber;
        }
    }
}
