package org.fundacionjala.coding.joseCardozo;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class EANValidatorTest {

    @Test
    public void test01() {
        assertTrue(EANValidator.validate("4003301018398"));
    }

    @Test
    public void test02() {
        assertFalse(EANValidator.validate("4003301018392"));
    }

    @Test
    public void test03() {
        assertTrue(EANValidator.validate("9783815820865"));
    }

    @Test
    public void test04() {
        assertFalse(EANValidator.validate("9783815820864"));
    }

    @Test
    public void test05() {
        assertFalse(EANValidator.validate("9783827317100"));
    }
}
