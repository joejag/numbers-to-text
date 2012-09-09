package com.joejag.numbertotext;

import com.joejag.numbertotext.dictionary.NumberDictionary;
import com.joejag.numbertotext.dictionary.SentenceCreator;
import com.joejag.numbertotext.dictionary.british.BritishEnglishNumberDictionary;
import com.joejag.numbertotext.dictionary.british.BritishEnglishSentenceCreator;

public class NumberToTextMain {

    public String translateToBritishEnglish(int input) {
        return translate(input,
                new BritishEnglishNumberDictionary(),
                new BritishEnglishSentenceCreator());
    }

    private String translate(int input, NumberDictionary dictionary, SentenceCreator sentenceCreator) {
        return new DictionaryNumberConverter(dictionary, sentenceCreator).toWords(input);
    }

    public static void main(String[] args) {
        new NumberToTextMain().translateToBritishEnglish(Integer.parseInt(args[0]));
    }
}
