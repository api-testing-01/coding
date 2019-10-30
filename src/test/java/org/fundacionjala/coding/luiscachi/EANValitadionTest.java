package org.fundacionjala.coding.luiscachi;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EANValitadionTest {
    @Test
    public void testIsEanNumber(){
        String EANNumber = "4003301018398";
        EANValidation eanValidation = new EANValidation();
        boolean result = eanValidation.EANValidation(EANNumber);
        assertEquals(true, result);
    }

    @Test
    public void testIsNotEanNumber(){
        String EANNumber = "4003301018392";
        EANValidation eanValidation = new EANValidation();
        boolean result = eanValidation.EANValidation(EANNumber);
        assertEquals(false, result);
    }

    @Test
    public void testIsEANNumber0000000000000(){
        String EANNumber = "0000000000000";
        EANValidation eanValidation = new EANValidation();
        boolean result = eanValidation.EANValidation(EANNumber);
        assertEquals(true, result);
    }
    @Test
    public void testIsEANNumber123(){
        String EANNumber = "123";
        EANValidation eanValidation = new EANValidation();
        boolean result = eanValidation.EANValidation(EANNumber);
        assertEquals(false, result);
    }

    @Test
    public void testIsEANNumberALargeNumber(){
        String EANNumber = "9876543216821654654";
        EANValidation eanValidation = new EANValidation();
        boolean result = eanValidation.EANValidation(EANNumber);
        assertEquals(false, result);
    }
}
