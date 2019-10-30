package org.fundacionjala.coding.jhasmanyQuiroz;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class EANNumberTest {
    @Test
    public void testEANNumberWithValidChecksum() {
        assertTrue(EANNumber.isEANNumber("4003301018398"));
    }

    @Test
    public void testEANNumberWithInvalidChecksum() {
        assertFalse(EANNumber.isEANNumber("4003301018392"));
    }
}
