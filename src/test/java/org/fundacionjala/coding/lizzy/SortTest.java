package org.fundacionjala.coding.lizzy;

import org.junit.Test;
import static org.fundacionjala.coding.lizzy.Sort.sortTheInnerContent;
import static org.junit.Assert.assertEquals;

public class SortTest {
    @Test
    public void exampleTests() {
        assertEquals("srot the inner ctonnet in dsnnieedcg oredr",
                sortTheInnerContent("sort the inner content in descending order"));
        assertEquals("wiat for me",
                sortTheInnerContent("wait for me"));
        assertEquals("tihs ktaa is esay",
                sortTheInnerContent("this kata is easy"));
    }
}
