package org.fundacionjala.coding.emely;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class KataTest {
    @Test
    public void exampleTests() {
        Assert.assertEquals("srot the inner ctonnet in dsnnieedcg oredr", Kata.sortTheInnerContent("sort the inner content in descending order"));
        assertEquals("wiat for me", Kata.sortTheInnerContent("wait for me"));
        assertEquals("tihs ktaa is esay", Kata.sortTheInnerContent("this kata is esay"));
    }
}