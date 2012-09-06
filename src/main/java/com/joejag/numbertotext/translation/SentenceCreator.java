package com.joejag.numbertotext.translation;

import com.joejag.numbertotext.breaker.NumberComponent;

import java.util.List;

public class SentenceCreator {

    public static final String HUNDRED = "hundred";

    StringBuilder sb = new StringBuilder();

    public String toSentence(List<String> words, NumberComponent.Part part) {
        for (String word : words) {
            addSpaceIfWordAlreadyPresent();
            addWord(word);
        }

        addAndIfHasHundredWithFurtherValue();
        addNumberComponentPartIfNotHundred(part);

        return sb.toString();
    }

    private void addSpaceIfWordAlreadyPresent() {
        if (sb.length() > 0)
            sb.append(" ");
    }

    private void addWord(String word) {
        sb.append(word);
    }

    private void addAndIfHasHundredWithFurtherValue() {
        String sentence = sb.toString();
        if (sentence.contains(HUNDRED) && !sentence.endsWith(HUNDRED))
            sb.insert(sb.indexOf(HUNDRED) + HUNDRED.length(), " and");
    }

    private void addNumberComponentPartIfNotHundred(NumberComponent.Part part) {
        if (part != NumberComponent.Part.HUNDRED)
            sb.append(" ").append(part.toString().toLowerCase());
    }
}
