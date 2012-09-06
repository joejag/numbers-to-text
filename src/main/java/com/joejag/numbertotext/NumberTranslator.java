package com.joejag.numbertotext;

import java.util.HashMap;
import java.util.Map;

public class NumberTranslator {

    private Map<Integer, String> britishEnglish = new HashMap<Integer, String>(){{
        put(1, "one");
        put(2, "two");
    }};

    public String translate(int number) {
        return britishEnglish.get(number);
    }

}
