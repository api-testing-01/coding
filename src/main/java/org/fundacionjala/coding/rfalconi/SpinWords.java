package org.fundacionjala.coding.rfalconi;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SpinWords {

    private static final int LIMIT_SPIN_WORD = 5;

    public String spinWords(final String sentence) {
        return Arrays.stream(sentence.split(" "))
                .map(word -> word.length() >= LIMIT_SPIN_WORD ? new StringBuilder(word).reverse().toString() : word)
                .collect(Collectors.joining(" "));
    }
}
