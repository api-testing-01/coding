package org.fundacionjala.coding.benjamin;

import java.util.Arrays;

/**
 * Class to solve Katas.
 *
 * @author Benjamin Huanca on 9/30/2019.
 * @version 1.0
 */
final class Kata {
    /**
     * Private contructor.
     */
    private Kata() {
    }

    public static String sortTheInnerContent(final String words) {
        final int minimumCharLength = 2;
        final String delimiter = " ";
        final String[] phrase = words.split(delimiter);
        String[] sortedString = new String[phrase.length];

        for (int i = 0; i < phrase.length; i++) {
            if (phrase[i].length() > minimumCharLength) {
                char[] tempArray = phrase[i].substring(1, phrase[i].length() - 1).toCharArray();
                Arrays.sort(tempArray);
                StringBuilder reverse = new StringBuilder();
                reverse.append(tempArray);
                sortedString[i] = phrase[i].charAt(0) + reverse.reverse().toString()
                        + phrase[i].charAt(phrase[i].length() - 1);
            } else {
                sortedString[i] = phrase[i];
            }

        }
        return String.join(delimiter, sortedString);
    }
}
