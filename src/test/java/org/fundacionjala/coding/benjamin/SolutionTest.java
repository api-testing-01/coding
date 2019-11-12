package org.fundacionjala.coding.benjamin;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 * @author Benjamin Huanca on 10/16/2019.
 * @version 1.0
 */
public class SolutionTest {
    @Test
    public void exampleTests() {
        assertEquals("srot the inner ctonnet in dsnnieedcg oredr",
                Kata.sortTheInnerContent("sort the inner content in descending order"));
        assertEquals("wiat for me", Kata.sortTheInnerContent("wait for me"));
        assertEquals("tihs ktaa is esay", Kata.sortTheInnerContent("this kata is easy"));
        assertEquals("t", Kata.sortTheInnerContent("t"));
    }
}
