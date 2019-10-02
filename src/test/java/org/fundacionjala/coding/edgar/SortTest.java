package org.fundacionjala.coding.edgar;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SortTest {
    @Test
    public void exampleTests() {
        assertEquals("srot the inner ctonnet in dsnnieedcg oredr",
                SortTheInnerContent.sortTheInnerContent("sort the inner content in descending order"));
        assertEquals("wiat for me", SortTheInnerContent.sortTheInnerContent("wait for me"));
        assertEquals("wzyt", SortTheInnerContent.sortTheInnerContent("wyzt"));
        assertEquals("tihs ktaa is esay", SortTheInnerContent.sortTheInnerContent("this kata is easy"));
    }
}
