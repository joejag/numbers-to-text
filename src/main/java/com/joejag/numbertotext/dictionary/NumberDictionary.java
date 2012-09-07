package com.joejag.numbertotext.dictionary;

import com.joejag.numbertotext.breaker.Part;

import java.util.List;

public interface NumberDictionary {
    List<Integer> getListOfDescendingNumbers();

    String wordFor(int number);

    List<Part> parts();
}
