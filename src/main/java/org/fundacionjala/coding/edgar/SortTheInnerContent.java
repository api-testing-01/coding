package org.fundacionjala.coding.edgar;

import java.util.*;

public class SortTheInnerContent {
    private SortTheInnerContent() {
    }

    public static String sortTheInnerContent(String words) {
        List<String> listOfWords = Arrays.asList(words.split(" "));

        words = "";
        for (String tempWord : listOfWords) {
            if (tempWord.length() <= 3) {
                words += tempWord + " ";
            }
            else {
                ArrayList<String> tempLetters = new ArrayList<>(Arrays.asList(tempWord.split("")));
                String firstLetter = tempLetters.get(0);
               String lastLetter = tempLetters.get(tempLetters.size() - 1);

                tempLetters.remove(0);
                tempLetters.remove(tempLetters.size() - 1);
                Collections.sort(tempLetters);
                Collections.reverse(tempLetters);

                String partOfWord = "";
                for (String letter : tempLetters) {
                    partOfWord += letter;
                }

                tempWord = firstLetter + partOfWord + lastLetter;

                words += tempWord + " ";
            }
        }
        return words.trim();
    }

}
