package org.fundacionjala.coding.benjamin;

import java.util.Arrays;
/**
 * @author Benjamin Huanca on 10/16/2019.
 * @version 1.0
 */
final class Kata {
    /**
     * Private constructor.
     */
    private Kata() {
    }

    public static String sortTheInnerContent(final String words) {
        final int minimumCharLength = 2;
        final String delimiter = " ";
        final String[] phrase = words.split(delimiter);

        for (int i = 0; i < phrase.length; i++) {
            if (phrase[i].length() > minimumCharLength) {
                char[] tempArray = phrase[i].substring(1, phrase[i].length() - 1).toCharArray();
                Arrays.sort(tempArray);
                phrase[i] = phrase[i].charAt(0) + new StringBuilder().append(tempArray).reverse().toString()
                        + phrase[i].charAt(phrase[i].length() - 1);
            }
        }
        return String.join(delimiter, phrase);
    }
}
