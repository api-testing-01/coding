package org.fundacionjala.coding.jose;

import java.util.Arrays;

public class SortTheInnerContent {
    public String sortTheInnerContent(final String sentence) {
        final int minumumWords = 3;
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            int wordSize = words[i].length();
            if (wordSize > minumumWords) {
                char[] subString = words[i].substring(1, wordSize - 1).toCharArray();
                Arrays.sort(subString);
                String sortString = String.valueOf(subString);
                String reverseSubString = new StringBuilder(sortString).reverse().toString();
                words[i] = new StringBuilder(words[i]).replace(1, wordSize - 1, reverseSubString).toString();
            }
        }
        return String.join(" ", words);
    }
}
