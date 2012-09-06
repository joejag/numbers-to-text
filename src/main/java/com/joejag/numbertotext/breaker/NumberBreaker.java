package com.joejag.numbertotext.breaker;

import com.joejag.numbertotext.utils.StringPadder;

import java.util.ArrayList;
import java.util.List;

import static com.joejag.numbertotext.breaker.NumberComponent.Part.*;

public class NumberBreaker {

    public List<NumberComponent> breakDown(int baseNumber) {
        List<NumberComponent> components = new ArrayList<NumberComponent>();

        String parts = createdAPaddedRepresentationOfTheBaseNumber(baseNumber);

        addPartIfHasValue(components, parts, 9, 6, MILLION);
        addPartIfHasValue(components, parts, 6, 3, THOUSAND);
        addPartIfHasValue(components, parts, 3, 0, HUNDRED);

        return components;
    }

    private void addPartIfHasValue(List<NumberComponent> components, String parts,
                                   int negativeStart, int negativeFinish, NumberComponent.Part part) {
        int partialNumber = grabPartOfNumber(parts, negativeStart, negativeFinish);
        if (partialNumber != 0)
            components.add(new NumberComponent(part, partialNumber));
    }

    private Integer grabPartOfNumber(String parts, int negativeStart, int negativeFinish) {
        return Integer.valueOf(parts.substring(parts.length() - negativeStart, parts.length() - negativeFinish));
    }

    private String createdAPaddedRepresentationOfTheBaseNumber(int baseNumber) {
        return StringPadder.padLeft(String.valueOf(baseNumber), "0", 9);
    }
}
