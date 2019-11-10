package org.fundacionjala.coding.rfalconi;

import org.junit.Test;

import static org.junit.Assert.*;

public class EANTest {
    @Test
    public void test() {
        EAN ean = new EAN ();
        assertFalse("4003301018398", ean.getChecksum("400330101839"));
        assertTrue("4003301018398", ean.getChecksum("4003301018398"));
        assertFalse("4003301018392", ean.getChecksum("4003301018392"));
        assertTrue("1111111111116", ean.getChecksum("1111111111116"));
    }
}
