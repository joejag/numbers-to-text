package com.joejag.numbertotext.translation;

import java.util.ArrayList;
import java.util.List;

import static com.joejag.numbertotext.translation.NumberComponent.NumberComponentPart.HUNDREDS;


public class NumberBreaker {

    public NumberComponents breakDown(int baseNumber) {
        List<NumberComponent> components = new ArrayList<NumberComponent>();

        if (baseNumber < 1000)
            components.add(new NumberComponent(HUNDREDS, baseNumber));

        return new NumberComponents(components);
    }
}
