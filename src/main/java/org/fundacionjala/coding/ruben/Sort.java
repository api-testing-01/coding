package org.fundacionjala.coding.ruben;
import java.util.Arrays;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

final class Sort {

    private static final Logger LOGGER = Logger.getLogger(Sort.class.getName());

    private Sort() {
        //not called
    }

    public static String sortTheInnerContent(final String sentence, final String regex) {
        String[] words = sentence.split(regex);
        StringBuilder newWord = new StringBuilder();
        for (String word : words) {
            String firstLetter = word.substring(0, 1);
            String lastLetter = word.substring(word.length() - 1);
            if (word.length() == 1) {
                String[] innerLetters = word.substring(1, 1).split("");
                Arrays.sort(innerLetters, Comparator.reverseOrder());
                newWord.append(firstLetter).append(String.join("", innerLetters)).append(regex);
            } else {
                String[] innerLetters = word.substring(1, word.length() - 1).split("");
                Arrays.sort(innerLetters, Comparator.reverseOrder());
                newWord.append(firstLetter).append(String.join("", innerLetters)).append(lastLetter).append(regex);
            }
        }
        return newWord.substring(0, newWord.length() - 1);
    }

    public static String validateSentence(final String sentence, final String regex) {

        if (sentence.length() > 2) {
            sortTheInnerContent(sentence, regex);
        } else {
            LOGGER.log(Level.WARNING, "Please enter a complete sentence");
        }
        return sortTheInnerContent(sentence, regex);
    }
}
