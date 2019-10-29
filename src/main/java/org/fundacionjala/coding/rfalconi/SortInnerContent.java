package org.fundacionjala.coding.rfalconi;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * SortInnerContent
 * You have to sort the inner content of every word of a string in descending order.
 * The inner content is the content of a word without first and the last char.
 * Some examples:
 * "sort the inner content in descending order" -> "srot the inner ctonnet in dsnnieedcg oredr"
 */

public class SortInnerContent {

    private static final Logger LOGGER = Logger.getLogger("org.fundacionjala.coding.rfalconi.SortInnerContent");

    public String sortInnerContent(final String phrase) {
        LOGGER.log(Level.INFO, "Original phrase: {0}", phrase);
        String[] content = phrase.split(" ");
        for (int i = 0; i < content.length; i++) {
            char[] word = content[i].toCharArray();
            if (word.length > 1) {
                Arrays.sort(word, 1, word.length - 1);
                content[i] = new String(word);
            }
        }
        String newphrase = String.join(" ", content);
        LOGGER.log(Level.INFO, "Phrase with re-ordered content: {0}" , newphrase);
        return newphrase;
    }
}
