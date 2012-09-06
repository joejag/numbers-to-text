package com.joejag.numbertotext.translation;

import java.util.List;

public class NumberTranslator {

    StringBuilder sb = new StringBuilder();

    public String translate(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);

            addSpaceIfWordAlreadyPresent();
            addWord(word);
            handleHundredsWhichNeedAnAnd(i, word, words.size());
        }

        return sb.toString();
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
