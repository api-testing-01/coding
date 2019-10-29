package org.fundacionjala.coding.rfalconi;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class EANTest {
    @Test
    public void test() {
        assertEquals("4003301018398", new EAN().getChecksum("400330101839"));
        assertNotEquals("4003301018392", new EAN().getChecksum("400330101839"));
        assertEquals("1111111111116", new EAN().getChecksum("111111111111"));
    }
}
