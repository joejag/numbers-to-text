package com.joejag.numbertotext.dictionary.british;

import com.joejag.numbertotext.dictionary.Part;

import java.util.List;

import static com.joejag.numbertotext.dictionary.british.BritishEnglishNumberDictionary.HUNDRED;

public class BritishEnglishSentenceCreator {

    StringBuilder sb = new StringBuilder();

    public String toSentence(List<String> words, Part part) {
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

    private void addNumberComponentPartIfNotHundred(Part part) {
        if (!part.name.equals(HUNDRED))
            sb.append(" ").append(part.name);
    }
}
