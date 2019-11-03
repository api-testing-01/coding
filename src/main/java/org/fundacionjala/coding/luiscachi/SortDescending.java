package org.fundacionjala.coding.luiscachi;

import java.util.Arrays;


public class SortDescending {
    public String sortDescending(final String sortDescending) {
        final int maxWordLength = 3;
        String[] wordsToSort = sortDescending.split(" ");
        for (int i = 0; i < wordsToSort.length; i++) {
            if (wordsToSort[i].length() > maxWordLength) {
                String wordToSort = wordsToSort[i].substring(1, wordsToSort[i].length() - 1);
                char[] arrayToSort = wordToSort.toCharArray();
                Arrays.sort(arrayToSort);
                String wordSort =  new String(arrayToSort);
                String sortDes = new StringBuilder(wordSort).reverse().toString();
                wordsToSort[i] = wordsToSort[i].charAt(0) + sortDes
                        + wordsToSort[i].charAt(wordsToSort[i].length() - 1);
            }
        }
        return String.join(" ", wordsToSort);
    }
}
