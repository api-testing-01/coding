package org.fundacionjala.coding.joseColina;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EANValidatorTest {
    @Test
    public void testEavnValidatorWithCorrectChecksum() {
        assertTrue(EANValidator.validate("9783815820865"));
    }

    @Test
    public void testEavnValidatorWithWrongChecksum() {
        assertFalse(EANValidator.validate("9783815820864"));
    }

    @Test
    public void testEavnValidatorWithChecksumEqualsTo0() {
        assertTrue(EANValidator.validate("9783827317100"));
    }
}
