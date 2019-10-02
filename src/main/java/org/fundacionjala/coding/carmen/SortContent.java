package org.fundacionjala.coding.carmen;

import java.util.Arrays;

final class SortContent {

    private SortContent() {    }

    public static String sortTheInnerContent(final String sentenceInput) {
        String[] sentence = sentenceInput.split(" ");
        for (int i = 0; i < sentence.length; i++) {
            int wordSize = sentence[i].length();
            String innerString = sentence[i].substring(1, wordSize - 1);
            String firstChar = sentence[i].substring(0, 1);
            String lastChar = sentence[i].substring(wordSize - 1, wordSize);

            char[] arr = innerString.toCharArray();
            Arrays.sort(arr);
            innerString = new StringBuilder(String.valueOf(arr)).reverse().toString();

            sentence[i] = firstChar + innerString + lastChar;
        }

        return String.join(" ", sentence);
    }
}
