package org.fundacionjala.coding.joseColina;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EANValidatorTest {
    private static EANValidator eanValidator;
    @BeforeAll
    public static void SetUp(){
        eanValidator = new EANValidator();
    }
    @Test
    public void test_01() {
        assertTrue(eanValidator.validate("9783815820865"));
    }

    @Test
    public void test_02() {
        assertFalse(eanValidator.validate("9783815820864"));
    }

    @Test
    public void test_03() {
        assertTrue(eanValidator.validate("9783827317100"));
    }
}
