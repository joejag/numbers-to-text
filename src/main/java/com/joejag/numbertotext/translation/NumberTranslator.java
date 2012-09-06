package com.joejag.numbertotext.translation;

import java.util.List;

public class NumberTranslator {

    public String translate(List<String> words) {
        StringBuilder sb = new StringBuilder();

        for (String word : words) {

            if (sb.length() > 0)
                sb.append(" ");

            sb.append(word);
        }

        return sb.toString();
    }
}
