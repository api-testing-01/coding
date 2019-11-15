package org.fundacionjala.coding.magali;

import java.util.Arrays;

public final class SortContent {

    private static final int WORD_LENGTH = 3;

    private SortContent() {

    }

    public static String sortTheInnerContent(final String words) {
        String[] wordArray = words.split(" ");
        for (int i = 0; i < wordArray.length; i++) {
            if (wordArray[i].length() > WORD_LENGTH) {
                String sortedWord = wordArray[i].substring(1, wordArray[i].length() - 1);
                char[] sortedChars = sortedWord.toCharArray();
                Arrays.sort(sortedChars);
                for (int j = 0; j < sortedChars.length / 2; j++) {
                    char tmp = sortedChars[j];
                    int index = sortedChars.length - 1 - j;
                    sortedChars[j] = sortedChars[index];
                    sortedChars[index] = tmp;
                }
                wordArray[i] = wordArray[i].charAt(0) + new String(sortedChars)
                        + wordArray[i].charAt(wordArray[i].length() - 1);
            }
        }
        return String.join(" ", wordArray);
    }
}


