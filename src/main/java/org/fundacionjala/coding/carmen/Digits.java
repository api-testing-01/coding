package org.fundacionjala.coding.carmen;

import java.util.HashMap;
import java.util.Map;

public final class Digits {
    public static final String ILLEGIBLE_DIGIT = "?";
    private static final Map<String, Character> NUMBERS;

    static {
        NUMBERS = new HashMap<>();
        NUMBERS.put(" _ | ||_|", '0');
        NUMBERS.put("     |  |", '1');
        NUMBERS.put(" _  _||_ ", '2');
        NUMBERS.put(" _  _| _|", '3');
        NUMBERS.put("   |_|  |", '4');
        NUMBERS.put(" _ |_  _|", '5');
        NUMBERS.put(" _ |_ |_|", '6');
        NUMBERS.put(" _   |  |", '7');
        NUMBERS.put(" _ |_||_|", '8');
        NUMBERS.put(" _ |_| _|", '9');
    }

    private Digits() {
    }

    public static String getNumberFromDigit(final String digit) {

        if (NUMBERS.containsKey(digit)) {
            return NUMBERS.get(digit).toString();
        } else {
            return "ILLEGIBLE_DIGIT";
        }
    }
}
