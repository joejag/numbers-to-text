package com.joejag.numbertotext.breaker;

import java.util.ArrayList;
import java.util.List;


public class NumberBreaker {

    public NumberComponents breakDown(int baseNumber) {
        List<NumberComponent> components = new ArrayList<NumberComponent>();

        if (baseNumber < 1000)
            components.add(new NumberComponent(NumberComponent.NumberComponentPart.HUNDREDS, baseNumber));

        return new NumberComponents(components);
    }
}
