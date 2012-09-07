package com.joejag.numbertotext.dictionary;

import java.util.List;

public interface NumberDictionary {
    List<Integer> getListOfDescendingNumbers();

    String wordFor(int number);

    List<Part> parts();
}
