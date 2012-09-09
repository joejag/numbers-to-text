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
        NumberToTextMain main = new NumberToTextMain();
        System.out.println(" ** Converting numbers to BritishEnglish");
        for (String arg : args) {
            System.out.println(" *** " + arg + " becomes " + main.translateToBritishEnglish(Integer.parseInt(arg)));
        }
    }
}
