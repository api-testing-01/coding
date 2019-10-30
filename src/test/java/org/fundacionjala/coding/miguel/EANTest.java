package org.fundacionjala.coding.miguel;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EANTest {
    @Test
    public void eanValidateTest() {
        assertTrue(new EAN().eanValidate("4003301018398"));
        assertFalse(new EAN().eanValidate("4003301018392"));
    }
}