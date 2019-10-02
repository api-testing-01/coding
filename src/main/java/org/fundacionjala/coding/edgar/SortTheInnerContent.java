package org.fundacionjala.coding.edgar;

import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

final class SortTheInnerContent {
    private SortTheInnerContent() {
    }

    private static final int Limit = 3;

    static String sortTheInnerContent(String words) {
        String[] arrayWords = words.split(" ");
        StringBuilder newWord = new StringBuilder();

        for (String str : arrayWords) {
            String temp = "";
            if (str.length() > Limit) {
                char[] letter = str.toCharArray();
                String reorderContent = str.substring(1, str.length() - 1).chars().mapToObj(e -> (char) e)
                        .sorted(Collections.reverseOrder()).collect(Collectors.toList()).stream()
                        .map(Objects::toString).collect(Collectors.joining(""));
                temp = letter[0] + reorderContent + letter[letter.length - 1] + " ";
            } else temp += str + " ";
            newWord.append(temp);
        }
        return newWord.toString().trim();
    }

}
