package org.fundacionjala.coding.ruben;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void exampleTests() {
        assertEquals("srot the inner ctonnet in dsnnieedcg oredr", Sort.sortTheInnerContent("sort the inner content in descending order"));
        assertEquals("wiat for me", Sort.sortTheInnerContent("wait for me"));
        assertEquals("tihs ktaa is esay", Sort.sortTheInnerContent("this kata is easy"));
    }
}