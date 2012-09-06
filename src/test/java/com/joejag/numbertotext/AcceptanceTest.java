package com.joejag.numbertotext;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AcceptanceTest {

    private NumberToText numberToText = new NumberToText();

    @Test
    public void customer_provided_example_1() {
        assertConversion("one", 1);
    }

    @Test
    public void customer_provided_example_21() {
        assertConversion("twenty one", 21);
    }

    @Test
    public void customer_provided_example_56_945_781() {
        assertConversion("fifty six million nine hundred and forty five thousand seven hundred and eighty one", 56945781);
    }

    @Test
    public void translate_1_to_one() {
        assertConversion("one", 1);
    }

    @Test
    public void translate_2_to_two() {
        assertConversion("two", 2);
    }

    @Test
    public void translate_3_to_numbers_below_10() {
        assertConversion("three", 3);
        assertConversion("four", 4);
        assertConversion("five", 5);
        assertConversion("six", 6);
        assertConversion("seven", 7);
        assertConversion("eight", 8);
        assertConversion("nine", 9);
    }

    @Test
    public void translate_10_to_20() {
        assertConversion("ten", 10);
        assertConversion("eleven", 11);
        assertConversion("twelve", 12);
        assertConversion("thirteen", 13);
        assertConversion("fourteen", 14);
        assertConversion("fifteen", 15);
        assertConversion("sixteen", 16);
        assertConversion("seventeen", 17);
        assertConversion("eighteen", 18);
        assertConversion("nineteen", 19);
        assertConversion("twenty", 20);
    }

    @Test
    public void translate_21() {
        assertConversion("twenty one", 21);
    }

    @Test
    public void translate_selection_of_other_numbers_below_a_hundred() {
        assertConversion("thirty two", 32);
        assertConversion("forty three", 43);
        assertConversion("fifty four", 54);
        assertConversion("sixty five", 65);
        assertConversion("seventy six", 76);
        assertConversion("eighty seven", 87);
        assertConversion("ninety eight", 98);
    }

    @Test
    public void translate_selection_of_other_numbers_below_a_thousand() {
        assertConversion("three hundred and twenty", 320);
        assertConversion("four hundred and thirty", 430);
        assertConversion("five hundred and forty", 540);
        assertConversion("six hundred and fifty", 650);
        assertConversion("seven hundred and sixty", 760);
        assertConversion("eight hundred and seventy", 870);
        assertConversion("nine hundred and eighty", 980);
    }

    @Test
    public void translate_selection_of_other_numbers_below_a_million() {
        assertConversion("one thousand", 1000);
        assertConversion("two thousand five hundred", 2500);
        assertConversion("twenty thousand five hundred", 20500);
        assertConversion("two hundred thousand five hundred", 200500);
    }

    private void assertConversion(String expected, int input) {
        assertEquals(expected, numberToText.translate(input));
    }

}
