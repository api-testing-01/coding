package org.fundacionjala.coding.luiscachi;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EANValitadionTest {
    @Test
    public void testIsEanNumber() {
        String eanNumber = "4003301018398";
        EANNumberValidation eanValidation = new EANNumberValidation();
        boolean result = eanValidation.eanValidation(eanNumber);
        assertEquals(true, result);
    }

    @Test
    public void testIsNotEanNumber() {
        String eanNumber = "4003301018392";
        EANNumberValidation eanValidation = new EANNumberValidation();
        boolean result = eanValidation.eanValidation(eanNumber);
        assertEquals(false, result);
    }

    @Test
    public void testIsEANNumber0000000000000() {
        String eanNumber = "0000000000000";
        EANNumberValidation eanValidation = new EANNumberValidation();
        boolean result = eanValidation.eanValidation(eanNumber);
        assertEquals(true, result);
    }
    @Test
    public void testIsEANNumber123() {
        String eanNumber = "123";
        EANNumberValidation eanValidation = new EANNumberValidation();
        boolean result = eanValidation.eanValidation(eanNumber);
        assertEquals(false, result);
    }

    @Test
    public void testIsEANNumberALargeNumber() {
        String eanNumber = "9876543216821654654";
        EANNumberValidation eanValidation = new EANNumberValidation();
        boolean result = eanValidation.eanValidation(eanNumber);
        assertEquals(false, result);
    }
}
