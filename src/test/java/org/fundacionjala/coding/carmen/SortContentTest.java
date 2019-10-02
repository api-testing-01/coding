package org.fundacionjala.coding.carmen;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SortContentTest {
    @Test
    public void testTextSmallerThanSize3ReturnSameText() {
        assertEquals("the", SortContent.sortTheInnerContent("the"));
    }

    @Test
    public void testTextBiggerThanSize3ReturnTextReversedDescending() {
        assertEquals("srot", SortContent.sortTheInnerContent("sort"));
    }

    @Test
    public void testSentenceReturnTextReversedDescendingIfWordsSizeBiggerThan3() {
        assertEquals("wiat for me", SortContent.sortTheInnerContent("wait for me"));
        assertEquals("srot the inner ctonnet in dsnnieedcg oredr", SortContent.sortTheInnerContent("sort the inner content in descending order"));
        assertEquals("tihs ktaa is esay", SortContent.sortTheInnerContent("this kata is easy"));
    }

}
