package org.fundacionjala.coding;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Test for {@link Library}.
 */

public class SorterInnerContentTest {
    /**
     * Verify some library method.
     */
    @Test
    public void testSortInnerContentWithASingleWOrd() {
        SorterInnerContent sorter = new SorterInnerContent();
        String sourceText = "descending";
        String expectedSorted = "dsnnieedcg";
        assertEquals(expectedSorted, sorter.sortInnerContent(sourceText));
    }
    @Test
    public void testSortInnerContentWithASingleWordWith1Char() {
        SorterInnerContent sorter = new SorterInnerContent();
        String sourceText = "s";
        String expectedSorted = "s";
        assertEquals(expectedSorted, sorter.sortInnerContent(sourceText));
    }
    @Test
    public void testSortInnerContentWithASingleWordWith2Chars() {
        SorterInnerContent sorter = new SorterInnerContent();
        String sourceText = "in";
        String expectedSorted = "in";
        assertEquals(expectedSorted, sorter.sortInnerContent(sourceText));
    }
    @Test
    public void testSortInnerContentWithASingleWordWith3Char() {
        SorterInnerContent sorter = new SorterInnerContent();
        String sourceText = "sun";
        String expectedSorted = "sun";
        assertEquals(expectedSorted, sorter.sortInnerContent(sourceText));
    }
    @Test
    public void testSortInnerContentWithManyWords() {
        SorterInnerContent sorter = new SorterInnerContent();
        String sourceText = "sort the inner content in descending order";
        String expectedSorted = "srot the inner ctonnet in dsnnieedcg oredr";
        assertEquals(expectedSorted, sorter.sortInnerContent(sourceText));
    }
}
