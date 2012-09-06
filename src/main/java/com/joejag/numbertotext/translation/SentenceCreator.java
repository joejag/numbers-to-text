package com.joejag.numbertotext.translation;

import com.joejag.numbertotext.breaker.NumberComponent;

import java.util.List;

public class SentenceCreator {

    StringBuilder sb = new StringBuilder();

    public String toSentence(List<String> words, NumberComponent.Part part) {
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);

            addSpaceIfWordAlreadyPresent();
            addWord(word);
            handleHundredsWhichNeedAnAnd(i, word, words.size());
        }

        addNumberPartIfNotHundred(part);

        return sb.toString();
    }

    private void addNumberPartIfNotHundred(NumberComponent.Part part) {
        if (part != NumberComponent.Part.HUNDRED)
            sb.append(" ").append(part.toString().toLowerCase());
    }

    private void addSpaceIfWordAlreadyPresent() {
        if (sb.length() > 0)
            sb.append(" ");
    }

    private void addWord(String word) {
        sb.append(word);
    }

    private void handleHundredsWhichNeedAnAnd(int i, String word, int size) {
        if (word.contains("hundred") && size - 1 != i)
            sb.append(" and");
    }
}
