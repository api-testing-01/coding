package org.fundacionjala.coding.marco;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EANValidatorTest {

    @Test
    public void validateTest() {
        assertTrue(EANValidator.validate("9783815820865"));
    }

    @Test
    public void validateTestNegative() {
        assertFalse(EANValidator.validate("9783815820864"));
    }

    @Test
    public void validateTestZeroControlDigit() {
        assertTrue(EANValidator.validate("9783827317100"));
    }
}

