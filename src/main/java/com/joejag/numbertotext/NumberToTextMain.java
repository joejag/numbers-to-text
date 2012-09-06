package com.joejag.numbertotext;

import com.joejag.numbertotext.breaker.NumberBreaker;
import com.joejag.numbertotext.breaker.NumberComponent;
import com.joejag.numbertotext.breaker.NumberComponents;
import com.joejag.numbertotext.dictionary.BritishEnglishNumberDictionary;
import com.joejag.numbertotext.translation.DictionaryBasedNumberReducer;
import com.joejag.numbertotext.translation.NumberTranslator;

import java.util.List;

public class NumberToTextMain {

    private DictionaryBasedNumberReducer numberReducer = new DictionaryBasedNumberReducer(new BritishEnglishNumberDictionary());

    public String translate(int input) {
        StringBuilder sb = new StringBuilder();

        NumberComponents numberComponents = new NumberBreaker().breakDown(input);
        List<NumberComponent> components = numberComponents.components;
        for (NumberComponent component : components) {
            List<String> reduced = numberReducer.reduce(component.number);
            sb.append(new NumberTranslator().translate(reduced, component.part));
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        new NumberToTextMain().translate(Integer.parseInt(args[0]));
    }
}
