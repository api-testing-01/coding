package org.fundacionjala.coding.magali;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SortContentTest {

    @Test
    public void test() {
        assertEquals("srot the inner ctonnet", SortContent.sortTheInnerContent("sort the inner content"));
        assertEquals("wiat for me", SortContent.sortTheInnerContent("wait for me"));
        assertEquals("tihs ktaa is esay", SortContent.sortTheInnerContent("this kata is easy"));
    }
}
