package org.fundacionjala.coding.magali;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public final class EANValidatorTest {

    @Test
    public void test1() {
        assertTrue(EANValidator.validate("9783815820865"));
    }

    @Test
    public void test2() {
        assertFalse(EANValidator.validate("9783815820864"));
    }

    @Test
    public void test3() {
        assertTrue(EANValidator.validate("9783827317100"));
    }
}
