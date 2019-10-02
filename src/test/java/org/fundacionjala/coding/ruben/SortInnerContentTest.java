package org.fundacionjala.coding.ruben;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SortInnerContentTest {

    @Test
    public void sentenceWithSpaceRegex() {
        assertEquals("srot the inner ctonnet in dsnnieedcg oredr ",
                Sort.validateSentence("sort the inner content in descending order", " "));
    }

    @Test
    public void sentenceWithAnotherRegex() {
        assertEquals("wiat-for-me-", Sort.validateSentence("wait-for-me", "-"));

    }
}
