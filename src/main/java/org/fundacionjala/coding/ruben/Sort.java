package org.fundacionjala.coding.ruben;
import java.util.logging.Level;
import java.util.logging.Logger;

final class Sort {

    private static final Logger LOGGER = Logger.getLogger(Sort.class.getName());

    private Sort() {
        //not called
    }

    private static String sortTheInnerContent(final String sentence, final String regex) {
        String[] words = sentence.split(regex);
        StringBuilder newWord = new StringBuilder();
        for (String word : words) {
            String firstLetter = word.substring(0, 1);
            String lastLetter = word.substring(word.length() - 1);
            StringBuilder innerLetters = new StringBuilder(word.substring(1, word.length() - 1));
            for (int aux1 = 0; aux1 < innerLetters.length() - 1; aux1++) {
                for (int aux2 = aux1 + 1; aux2 < innerLetters.length(); aux2++) {
                    if (innerLetters.charAt(aux1) < innerLetters.charAt(aux2)) {
                        char temp = innerLetters.charAt(aux1);
                        innerLetters.setCharAt(aux1, innerLetters.charAt(aux2));
                        innerLetters.setCharAt(aux2, temp);
                    }
                }
            }
            newWord.append(firstLetter).append(innerLetters.toString()).append(lastLetter).append(regex);
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
