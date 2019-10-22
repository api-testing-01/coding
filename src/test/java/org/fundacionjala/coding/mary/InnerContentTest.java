package org.fundacionjala.coding.mary;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for {@link InnerContent}.
 */
public class InnerContentTest {

    /**
     * Verify sorting of inner content of a string in descending order.
     */
    @Test
    public void innerContentTests() {
        Assert.assertEquals("srot the inner ctonnet in dsnnieedcg oredr", InnerContent.sortTheInnerContent(
                "sort the inner content in descending order"));
        assertEquals("wiat for me", InnerContent.sortTheInnerContent("wait for me"));
        assertEquals("tihs ktaa is esay", InnerContent.sortTheInnerContent("this kata is easy"));
    }
}
