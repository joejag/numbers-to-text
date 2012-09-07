package com.joejag.numbertotext;

import com.joejag.numbertotext.breaker.NumberBreaker;
import com.joejag.numbertotext.breaker.NumberComponent;
import com.joejag.numbertotext.dictionary.NumberDictionary;
import com.joejag.numbertotext.dictionary.SentenceCreator;
import com.joejag.numbertotext.reducer.DictionaryBasedNumberReducer;
import com.joejag.numbertotext.utils.Strings;

import java.util.ArrayList;
import java.util.List;

public class DictionaryNumberConverter {

    private final NumberDictionary dictionary;
    private final SentenceCreator creator;
    private final DictionaryBasedNumberReducer reducer;

    public DictionaryNumberConverter(NumberDictionary dictionary, SentenceCreator creator) {
        this.dictionary = dictionary;
        this.creator = creator;
        this.reducer = new DictionaryBasedNumberReducer(dictionary);
    }

    public String toWords(int number) {
        List<NumberComponent> components = new NumberBreaker(dictionary.parts()).breakDown(number);

        List<String> sentenceParts = new ArrayList<String>();
        for (NumberComponent component : components) {
            List<String> reduced = reducer.toWords(component.number);
            sentenceParts.add(creator.toSentence(reduced, component.part));
        }

        return Strings.join(sentenceParts);
    }
}
