package org.fundacionjala.coding;

public class SorterInnerContent {
    public static final int MINIMUM_LENGHT_OF_WORD = 3;

    public String sortInnerContent(String text) {
        String result = "";
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            int wordLength = words[i].length();
            if (wordLength > MINIMUM_LENGHT_OF_WORD) {
                StringBuilder innerWord = new StringBuilder(words[i].substring(1, wordLength - 1));
                innerWord = sortDescending(innerWord);
                words[i] = innerWord.append(words[i].charAt(wordLength - 1)).insert(0, words[i].charAt(0)).toString();
            }
        }
        result = String.join(" ", words);
        return result;
    }

    private StringBuilder sortDescending(StringBuilder text) {
        StringBuilder sorted = new StringBuilder();
        sorted.append(text.charAt(0));
        for (int j = 1; j < text.length(); j++) {
            for (int k = 0; k < sorted.length(); k++) {
                if (text.charAt(j) > sorted.charAt(k)) {
                    sorted.insert(k, text.charAt(j));
                    break;
                } else if (k == sorted.length() - 1) {
                    sorted.append(text.charAt(j));
                    break;
                }
            }
        }
        return sorted;
    }
}
