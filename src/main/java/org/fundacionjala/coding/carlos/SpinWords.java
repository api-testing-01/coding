package org.fundacionjala.coding.carlos;

public class SpinWords {
    public String spinWords(final String sentence) {
        final int size = 5;
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >= size) {
                 words[i] = new StringBuilder(words[i]).reverse().toString();
            }
        }
        return String.join(" ", words);
    }
}
