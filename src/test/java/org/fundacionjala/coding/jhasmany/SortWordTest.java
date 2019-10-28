package org.fundacionjala.coding.jhasmany;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SortWordTest {
    @Test
    public void testSortInnerContentWithEmptyWord() {
        SortWord sortWord = new SortWord();
        String actualResult = sortWord.sortTheInnerContent("");
        System.out.println("Is empty? " + actualResult.isEmpty());

        assertTrue("", actualResult.isEmpty());
    }

    @Test
    public void testSortInnerContentWords() {
        SortWord sortWord = new SortWord();
        assertEquals("srot the inner ctonnet in dsnnieedcg oredr ",
                sortWord.sortTheInnerContent("sort the inner content in descending order"));
        assertEquals("wiat for me ", sortWord.sortTheInnerContent("wait for me"));
        assertEquals("tihs ktaa is esay ", sortWord.sortTheInnerContent("this kata is easy"));
    }
}
