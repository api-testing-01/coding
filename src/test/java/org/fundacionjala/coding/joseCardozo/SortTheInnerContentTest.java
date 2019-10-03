package org.fundacionjala.coding.joseCardozo;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SortTheInnerContentTest {

    @Test
    public void sortTheInnerContent() {
        Assert.assertEquals("srot the inner ctonnet in dsnnieedcg oredr",
                new SortTheInnerContent().sortTheInnerContent("sort the inner content in descending order"));
        assertEquals("wiat for me", new SortTheInnerContent().sortTheInnerContent("wait for me"));
        assertEquals("tihs ktaa is esay", new SortTheInnerContent().sortTheInnerContent("this kata is easy"));
    }
}
