package org.fundacionjala.coding.mary;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Mary Ricalde on 10/1/2019.
 */
public final class InnerContent {
    private static final int WORD_LENGTH = 3;

    private InnerContent() {
    }

    public static String sortTheInnerContent(final String words) {
        String result;

        String[] wordsList = words.split(" ");
        for (int i = 0; i < wordsList.length; i++) {
            if (wordsList[i].length() > WORD_LENGTH) {
                wordsList[i] = descentOrderText(wordsList[i]);
            }
        }
        result = String.join(" ", wordsList);

        return result;
    }

    public static String descentOrderText(final String text) {
        String result;
        int startIndex = 0;
        int endIndex = text.length() - 1;
        String innerContent = text.substring(startIndex + 1, endIndex);
        String[] innerContentList = innerContent.split("");
        Arrays.sort(innerContentList, Collections.reverseOrder());
        result = text.charAt(startIndex) + String.join("", innerContentList) + text.charAt(endIndex);

        return result;
    }
}
