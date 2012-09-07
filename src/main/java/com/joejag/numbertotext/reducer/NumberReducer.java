package com.joejag.numbertotext.reducer;

import java.util.List;

public interface NumberReducer {
    List<String> toWords(int number);
}
