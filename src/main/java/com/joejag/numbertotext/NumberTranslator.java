package com.joejag.numbertotext;

public class NumberTranslator {

    private NumberDictionary dictionary;

    public NumberTranslator(NumberDictionary dictionary) {
        this.dictionary = dictionary;
    }

    public String translate(int number) {
        StringBuilder numberAsText = new StringBuilder();

        int remainder = number;

        for (int integer : dictionary.getListOfDescendingNumbers()) {
            if (remainder >= integer) {
                addSpaceIfNotTheFirstNumberAdded(numberAsText);
                numberAsText.append(dictionary.wordFor(integer));
                remainder -= integer;
            }
        }


        String s = numberAsText.toString();
        s = s.replaceAll("hundred", "hundred and");

        return s;
    }

    private void addSpaceIfNotTheFirstNumberAdded(StringBuilder numberAsText) {
        if (numberAsText.length() > 0) {
            numberAsText.append(" ");
        }
    }

}
