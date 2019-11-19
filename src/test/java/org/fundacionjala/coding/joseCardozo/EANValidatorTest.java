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
        assertTrue(EANValidator.validate("4000000000600"));
    }
}
