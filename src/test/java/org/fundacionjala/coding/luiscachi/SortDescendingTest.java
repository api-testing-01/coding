package org.fundacionjala.coding.luiscachi;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SortDescendingTest {

    @Test
    public void testSortDescendingASingleWord() {
        SortDescending sort = new SortDescending();
        String actual = "descending";
        String expected = "dsnnieedcg";
        assertEquals(expected, sort.sortDescending(actual));
    }

    @Test
    public void testSortDescendingSingleChar() {
        SortDescending sort = new SortDescending();
        String actual = "a";
        String expected = "a";
        assertEquals(expected, sort.sortDescending(actual));
    }

    @Test
    public void testSortDescendingSmallWord() {
        SortDescending sort = new SortDescending();
        String actual = "cow";
        String expected = "cow";
        assertEquals(expected, sort.sortDescending(actual));
    }

    @Test
    public void testSortDescendingAPhrase() {
        SortDescending sort = new SortDescending();
        String actual = "wait for me";
        String expected = "wiat for me";
        assertEquals(expected, sort.sortDescending(actual));
    }

    @Test
    public void testSortDescendingKataExample() {
        SortDescending sort = new SortDescending();
        String actual = "sort the inner content in descending order";
        String expected = "srot the inner ctonnet in dsnnieedcg oredr";
        assertEquals(expected, sort.sortDescending(actual));
    }
}
