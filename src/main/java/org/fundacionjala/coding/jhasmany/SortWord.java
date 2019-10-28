package org.fundacionjala.coding.jhasmany;

import java.util.Arrays;
import java.util.Collections;

public class SortWord {
    public String sortTheInnerContent(final String words) {
        String[] wordList = words.split(" ");
        StringBuilder response = new StringBuilder();
        int secondIndex = 1, penultimateIndex;
        StringBuilder aux;
        int LIMIT = 5;

        if (words.length() > LIMIT) {
            for (String word : wordList) {
                penultimateIndex = word.length() - 1;
                aux = new StringBuilder(word);

                // Deleting the first and the last character
                String innerWord = word.substring(secondIndex, penultimateIndex);
                String[] tempArray = innerWord.split("");
                Arrays.sort(tempArray, Collections.reverseOrder());

                String newWord = String.join("", tempArray);
                aux = aux.replace(secondIndex, penultimateIndex, newWord);

                response = response.append(aux).append(" ");
            }
        }

        return response.toString();
    }
}
