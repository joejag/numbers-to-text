package com.joejag.numbertotext.utils;

public class StringPadder {

    public static String padLeft(String base, String with, int size) {
        StringBuilder sb = new StringBuilder(base);

        int toAdd = size - sb.length();
        for (int i = 0; i < toAdd; i++)
            sb.insert(0, with);

        return sb.toString();
    }
}
