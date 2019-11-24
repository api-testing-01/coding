package org.fundacionjala.coding.ruben;

import java.util.HashMap;
import java.util.Map;

public final class Numbers {

    private static final int NUMBER_ZERO = 0;
    private static final int NUMBER_ONE = 1;
    private static final int NUMBER_TWO = 2;
    private static final int NUMBER_THREE = 3;
    private static final int NUMBER_FOUR = 4;
    private static final int NUMBER_FIVE = 5;
    private static final int NUMBER_SIX = 6;
    private static final int NUMBER_SEVEN = 7;
    private static final int NUMBER_EIGHT = 8;
    private static final int NUMBER_NINE = 9;

    private Numbers() {
        // private constructor
    }

    private static Map<String, Integer> accountNumbers;

    static {
        accountNumbers = new HashMap<>();
        accountNumbers.put(" _ | ||_|", NUMBER_ZERO);
        accountNumbers.put("     |  |", NUMBER_ONE);
        accountNumbers.put(" _  _||_ ", NUMBER_TWO);
        accountNumbers.put(" _  _| _|", NUMBER_THREE);
        accountNumbers.put("   |_|  |", NUMBER_FOUR);
        accountNumbers.put(" _ |_  _|", NUMBER_FIVE);
        accountNumbers.put(" _ |_ |_|", NUMBER_SIX);
        accountNumbers.put(" _   |  |", NUMBER_SEVEN);
        accountNumbers.put(" _ |_||_|", NUMBER_EIGHT);
        accountNumbers.put(" _ |_| _|", NUMBER_NINE);
    }

    public static String getNumber(final String number) {
        String strNumber = null;
        if (accountNumbers.containsKey(number)) {
            strNumber = accountNumbers.get(number).toString();
        } else {
            strNumber = "?";
        }
        return strNumber;
    }
}
