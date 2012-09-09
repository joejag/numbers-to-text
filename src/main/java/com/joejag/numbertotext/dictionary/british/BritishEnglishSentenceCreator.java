package com.joejag.numbertotext.dictionary.british;

import com.joejag.numbertotext.breaker.Part;
import com.joejag.numbertotext.dictionary.SentenceCreator;
import com.joejag.numbertotext.utils.Strings;

import java.util.List;

import static com.joejag.numbertotext.dictionary.british.BritishEnglishNumberDictionary.HUNDRED;

public class BritishEnglishSentenceCreator implements SentenceCreator {

    public String applyGrammarTo(List<String> words, Part part) {
        StringBuilder sb = new StringBuilder(Strings.join(words));

        addAndIfHasHundredPartWithFurtherValue(sb);
        addNumberComponentPartIfNotHundred(sb, part);

        return sb.toString();
    }

    private void addAndIfHasHundredPartWithFurtherValue(StringBuilder sb) {
        String sentence = sb.toString();
        if (sentence.contains(HUNDRED) && !sentence.endsWith(HUNDRED))
            sb.insert(sb.indexOf(HUNDRED) + HUNDRED.length(), " and");
    }

    private void addNumberComponentPartIfNotHundred(StringBuilder sb, Part part) {
        if (!part.name.equals(HUNDRED))
            sb.append(" ").append(part.name);
    }
}
