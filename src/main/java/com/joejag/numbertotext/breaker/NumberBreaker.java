package com.joejag.numbertotext.breaker;

import com.joejag.numbertotext.utils.StringPadder;

import java.util.ArrayList;
import java.util.List;

import static com.joejag.numbertotext.breaker.NumberComponent.Part.*;
import static java.util.Arrays.asList;

public class NumberBreaker {

    private List<NumberComponent> components = new ArrayList<NumberComponent>();

    public List<NumberComponent> breakDown(int baseNumberAsInt) {
        String baseNumber = createAPaddedRepresentationOfTheBaseNumber(baseNumberAsInt);

        for (NumberComponent.Part part : asList(MILLION, THOUSAND, HUNDRED))
            addPartIfHasValue(baseNumber, part);

        return components;
    }

    private void addPartIfHasValue(String parts, NumberComponent.Part part) {
        int partialNumber = grabPartOfNumber(parts, part.getStartIndexInNumber(), part.getEndIndexInNumber());
        if (partialNumber != 0)
            components.add(new NumberComponent(part, partialNumber));
    }

    private Integer grabPartOfNumber(String parts, int negativeStart, int negativeFinish) {
        return Integer.valueOf(parts.substring(parts.length() - negativeStart, parts.length() - negativeFinish));
    }

    private String createAPaddedRepresentationOfTheBaseNumber(int baseNumber) {
        return StringPadder.padLeft(String.valueOf(baseNumber), "0", MILLION.getStartIndexInNumber());
    }
}
