package com.joejag.numbertotext;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BritishEnglishNumberDictionary implements NumberDictionary {

    private final Map<Integer, String> singleDigits = new LinkedHashMap<Integer, String>() {{
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

    private final Map<Integer, String> others = new LinkedHashMap<Integer, String>() {{
        for (int integer : singleDigits.keySet()) {
            put(integer * 100, singleDigits.get(integer) +  " hundred");
        }

        put(90, "ninety");
        put(80, "eighty");
        put(70, "seventy");
        put(60, "sixty");
        put(50, "fifty");
        put(40, "forty");
        put(30, "thirty");
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

        putAll(singleDigits);
    }};

    public List<Integer> getListOfDescendingNumbers() {
        return new ArrayList<Integer>(others.keySet());
    }

    public String wordFor(int number) {
        return others.get(number);
    }
}
