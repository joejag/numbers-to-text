package com.joejag.numbertotext.dictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface NumberDictionary {
    List<Integer> getListOfDescendingNumbers();

    String wordFor(int number);
}
