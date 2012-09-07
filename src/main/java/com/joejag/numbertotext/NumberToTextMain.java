package com.joejag.numbertotext;

import com.joejag.numbertotext.breaker.NumberBreaker;
import com.joejag.numbertotext.breaker.NumberComponent;
import com.joejag.numbertotext.dictionary.NumberDictionary;
import com.joejag.numbertotext.dictionary.british.BritishEnglishNumberDictionary;
import com.joejag.numbertotext.dictionary.british.BritishEnglishSentenceCreator;
import com.joejag.numbertotext.translation.DictionaryBasedNumberReducer;

import java.util.List;

public class NumberToTextMain {

    public String translate(int input) {
        return translate(input, new BritishEnglishNumberDictionary());
    }

    private String translate(int input, NumberDictionary dictionary) {
        StringBuilder sb = new StringBuilder();

        for (NumberComponent component : new NumberBreaker(dictionary.parts()).breakDown(input)) {
            List<String> reduced = new DictionaryBasedNumberReducer(dictionary).toWords(component.number);
            sb.append(new BritishEnglishSentenceCreator().toSentence(reduced, component.part));
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        new NumberToTextMain().translate(Integer.parseInt(args[0]));
    }
}
