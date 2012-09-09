package com.joejag.numbertotext.dictionary;

import com.joejag.numbertotext.breaker.Part;

import java.util.List;

public interface SentenceCreator {
    String applyGrammarTo(List<String> words, Part part);
}
