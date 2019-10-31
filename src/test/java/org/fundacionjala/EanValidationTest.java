package org.fundacionjala;

import static org.junit.Assert.*;

import org.junit.Test;

public class EanValidationTest {

    @Test
    public void testEanValidationForValidEANnumber() {
        EanValidation eanVal = new EanValidation();
        assertTrue(eanVal.validator(4003301018398L));
    }

    @Test
    public void testEanValidationForNoValidEANnumber() {
        EanValidation eanVal = new EanValidation();
        assertFalse(eanVal.validator(4003301018399L));
    }

    @Test
    public void testEanValidationOddSum() {
        EanValidation eanVal = new EanValidation();
        assertEquals(8, eanVal.oddSum(234628));
    }

    @Test
    public void testEanValidationEvenSum() {
        EanValidation eanVal = new EanValidation();
        assertEquals(42, eanVal.evenSum(2345463));
    }
}