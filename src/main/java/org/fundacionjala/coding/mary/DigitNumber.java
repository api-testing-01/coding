package org.fundacionjala.coding.mary;

import java.util.HashMap;
import java.util.Map;

public final class DigitNumber {
    public static final String ILLEGIBLE_DIGIT = "?";
    private static final Map<String, Character> NUMBERS = new HashMap<String, Character>() {
        {
            put(" _ | ||_|", '0');
            put("     |  |", '1');
            put(" _  _||_ ", '2');
            put(" _  _| _|", '3');
            put("   |_|  |", '4');
            put(" _ |_  _|", '5');
            put(" _ |_ |_|", '6');
            put(" _   |  |", '7');
            put(" _ |_||_|", '8');
            put(" _ |_| _|", '9');
        }
    };

    private DigitNumber() {
    }

    public static String getNumberFromDigit(final String digit) {
        return NUMBERS.containsKey(digit) ? NUMBERS.get(digit).toString() : ILLEGIBLE_DIGIT;
    }
}
