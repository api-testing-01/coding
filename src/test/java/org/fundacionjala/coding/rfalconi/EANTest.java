package org.fundacionjala.coding.rfalconi;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EANTest {
    @Test
    public void test() {
        assertEquals("4003301018398", new EAN().getChecksum("400330101839"));
        assertEquals("4203301018385", new EAN().getChecksum("420330101838"));
        assertEquals("1111111111116", new EAN().getChecksum("111111111111"));
    }
}
