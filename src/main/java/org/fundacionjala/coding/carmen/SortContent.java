package org.fundacionjala.coding.carmen;

import java.util.Arrays;
import java.util.Comparator;

final class SortContent {

    private static final int LIMIT = 3;

    private SortContent() {    }

    public static String sortTheInnerContent(final String sentenceInput) {
        String[] sentence = sentenceInput.split(" ");
        for (int i = 0; i < sentence.length; i++) {
            int wordSize = sentence[i].length();
            if (wordSize > LIMIT) {
                String innerString = sentence[i].substring(1, wordSize - 1);
                String firstChar = sentence[i].substring(0, 1);
                String lastChar = sentence[i].substring(wordSize - 1, wordSize);

                String[] innerArray = innerString.split("");
                Arrays.sort(innerArray, Comparator.reverseOrder());
                sentence[i] = firstChar + String.join("", innerArray) + lastChar;
            }
        }

        return String.join(" ", sentence);
    }
}
