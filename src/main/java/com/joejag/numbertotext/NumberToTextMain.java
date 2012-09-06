package com.joejag.numbertotext;

import com.joejag.numbertotext.breaker.NumberBreaker;
import com.joejag.numbertotext.breaker.NumberComponent;
import com.joejag.numbertotext.dictionary.BritishEnglishNumberDictionary;
import com.joejag.numbertotext.translation.DictionaryBasedNumberReducer;
import com.joejag.numbertotext.translation.NumberReducer;
import com.joejag.numbertotext.translation.SentenceCreator;

import java.util.List;

public class NumberToTextMain {

    private final NumberReducer reducer = new DictionaryBasedNumberReducer(new BritishEnglishNumberDictionary());

    public String translate(int input) {
        StringBuilder sb = new StringBuilder();

        for (NumberComponent component : new NumberBreaker().breakDown(input)) {
            List<String> reduced = reducer.toWords(component.number);
            sb.append(new SentenceCreator().toSentence(reduced, component.part));
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        new NumberToTextMain().translate(Integer.parseInt(args[0]));
    }
}
