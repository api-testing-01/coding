package org.fundacionjala.coding.miguel;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SorterInnerContentTest {
    @Test
    public void test() {
        assertEquals("srot the inner ctonnet in dsnnieedcg oredr", new SortInnerContent()
                .sortInnerContent("sort the inner content in descending order"));
        assertEquals("wiat for me", new SortInnerContent().sortInnerContent("wait for me"));
        assertEquals("tihs ktaa is esay", new SortInnerContent()
                .sortInnerContent("this kata is easy"));
    }
}
