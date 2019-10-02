package org.fundacionjala.coding.miguel;

public class SortInnerContent {
    public static final int MAX_CHAR = 26;
    public static final int LIMIT_WORDS = 4;

    public String sortInnerContent(final String sentence) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >= LIMIT_WORDS) {
                String body = new StringBuilder(words[i]).substring(1, words[i].length() - 1);
                body = sortDescending(body);
                words[i] = new StringBuilder(words[i]).replace(1, words[i].length() - 1, body).toString();
            }
        }
        return String.join(" ", words);
    }

    public String sortDescending(final String word) {
        int[] charCount = new int[MAX_CHAR];

        for (int i = 0; i < word.length(); i++) {
            charCount[word.charAt(i) - 'a']++;
        }

        String sorted = "";
        for (int i = MAX_CHAR - 1; i >= 0; i--) {
            for (int j = 0; j < charCount[i]; j++) {
               sorted = sorted + ((char) ('a' + i));
            }
        }
        return sorted;
    }
}
