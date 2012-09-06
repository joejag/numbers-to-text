package com.joejag.numbertotext;

public class NumberTranslator {

    private NumberDictionary dictionary;

    public NumberTranslator(NumberDictionary dictionary) {
        this.dictionary = dictionary;
    }

    public String translate(int number) {
        StringBuilder numberAsText = new StringBuilder();

        int remainder = number;

        for (int integer : dictionary.getDictionary().keySet()) {
            if (remainder >= integer) {
                addSpaceIfNotTheFirstNumberAdded(numberAsText);
                numberAsText.append(dictionary.getDictionary().get(integer));
                remainder -= integer;
            }
        }

        return numberAsText.toString();
    }

    private void addSpaceIfNotTheFirstNumberAdded(StringBuilder numberAsText) {
        if (numberAsText.length() > 0) {
            numberAsText.append(" ");
        }
    }

}
