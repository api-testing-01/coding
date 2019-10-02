package org.fundacionjala.coding.magali;
import java.util.*;

public class SortContent {

    public static String sortTheInnerContent(String words) {
        String[] wordArray = words.split(" ");
        String[] wordSorted = new String[wordArray.length];
        int i = 0;
        for (String word: wordArray) {
            if (word.length() > 3) {
                String sortedWord = word.substring(1, word.length() - 1);
                char[] sortedChars = sortedWord.toCharArray();
                Arrays.sort(sortedChars);

                for (int j = 0; j < sortedChars.length / 2; j++) {
                    char tmp = sortedChars[j];
                    int index = sortedChars.length - 1 - j;
                    sortedChars[j] = sortedChars[index];
                    sortedChars[index] = tmp;
                }

                wordSorted[i] = word.charAt(0) + new String(sortedChars) + word.charAt(word.length() - 1);
            } else {
                wordSorted[i] = word;
            }
            i++;
        }
        return String.join(" ", wordSorted);
    }
}


