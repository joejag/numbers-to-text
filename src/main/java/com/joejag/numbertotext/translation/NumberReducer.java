package com.joejag.numbertotext.translation;

import java.util.List;

public interface NumberReducer {
    List<String> toWords(int number);
}
