package com.joejag.numbertotext;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class NumberTranslator {

    private Map<Integer, String> britishEnglish = new LinkedHashMap<Integer, String>() {{
        put(20, "twenty");
        put(19, "nineteen");
        put(18, "eighteen");
        put(17, "seventeen");
        put(16, "sixteen");
        put(15, "fifteen");
        put(14, "fourteen");
        put(13, "thirteen");
        put(12, "twelve");
        put(11, "eleven");
        put(10, "ten");
        put(9, "nine");
        put(8, "eight");
        put(7, "seven");
        put(6, "six");
        put(5, "five");
        put(4, "four");
        put(3, "three");
        put(2, "two");
        put(1, "one");
    }};

    public String translate(int number) {
        StringBuilder numberAsText = new StringBuilder();

        int remainder = number;
        for (int integer : britishEnglish.keySet()) {
            if (integer <= remainder) {
                if (numberAsText.length() > 0) {
                    numberAsText.append(" ");
                }

                numberAsText.append(britishEnglish.get(integer));
                remainder -= integer;
            }
        }

        return numberAsText.toString();
    }

}
