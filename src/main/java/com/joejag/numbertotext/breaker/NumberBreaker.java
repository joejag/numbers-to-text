package com.joejag.numbertotext.breaker;

import com.joejag.numbertotext.utils.StringPadder;

import java.util.ArrayList;
import java.util.List;

import static com.joejag.numbertotext.breaker.NumberComponent.NumberComponentPart.*;

public class NumberBreaker {

    public NumberComponents breakDown(int baseNumber) {
        List<NumberComponent> components = new ArrayList<NumberComponent>();

        String parts = createdAPaddedRepresentationOfTheBaseNumber(baseNumber);

        addPartIfHasValue(components, parts, 9, 6, MILLIONS);
        addPartIfHasValue(components, parts, 6, 3, THOUSANDS);
        addPartIfHasValue(components, parts, 3, 0, HUNDREDS);

        return new NumberComponents(components);
    }

    private void addPartIfHasValue(List<NumberComponent> components, String parts,
                                   int negativeStart, int negativeFinish, NumberComponent.NumberComponentPart part) {
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
