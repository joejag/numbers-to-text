package com.joejag.numbertotext.translation;

import com.joejag.numbertotext.breaker.NumberComponent;

import java.util.List;

/**
 * Deliberately made not thread safe to improve readability
 */
public class SentenceCreator {

    StringBuilder sb = new StringBuilder();

    public String toSentence(List<String> words, NumberComponent.Part part) {
        for (String word : words) {
            addSpaceIfWordAlreadyPresent();
            addWord(word);
        }

        handleHundredsWhichNeedAnAnd();
        addNumberPartIfNotHundred(part);

        return sb.toString();
    }

    private void addSpaceIfWordAlreadyPresent() {
        if (sb.length() > 0)
            sb.append(" ");
    }

    private void addWord(String word) {
        sb.append(word);
    }

    private void handleHundredsWhichNeedAnAnd() {
        String sentence = sb.toString();
        if (sentence.contains("hundred") && !sentence.endsWith("hundred"))
            sb.insert(sb.indexOf("hundred") + "hundred".length(), " and");
    }

    private void addNumberPartIfNotHundred(NumberComponent.Part part) {
        if (part != NumberComponent.Part.HUNDRED)
            sb.append(" ").append(part.toString().toLowerCase());
    }
}
