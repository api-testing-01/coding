package org.fundacionjala.coding.ruben;

import java.util.HashMap;
import java.util.Map;

public class Numbers {

    private static Map<String, Integer> Numbers;

    static {
        Numbers = new HashMap<>();
        Numbers.put(" _ | ||_|", 0);
        Numbers.put("     |  |", 1);
        Numbers.put(" _  _||_ ", 2);
        Numbers.put(" _  _| _|", 3);
        Numbers.put("   |_|  |", 4);
        Numbers.put(" _ |_  _|", 5);
        Numbers.put(" _ |_ |_|", 6);
        Numbers.put(" _   |  |", 7);
        Numbers.put(" _ |_||_|", 8);
        Numbers.put(" _ |_| _|", 9);
    }

    public static String getNumber(String number) {
        String strNumber = null;
        if (Numbers.containsKey(number)) {
            strNumber = Numbers.get(number).toString();
        } else {
            strNumber = "?";
        }
        return strNumber;
    }
}
