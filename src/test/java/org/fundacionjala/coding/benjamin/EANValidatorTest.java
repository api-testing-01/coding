package org.fundacionjala.coding.benjamin;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Benjamin Huanca on 10/29/2019.
 * @version 1.0
 */
public class EANValidatorTest {
    @Test
    public void testValidateTrue() {

        String code = "4003301018398";
        Assert.assertEquals(true, EANValidator.validate(code));
    }
    @Test
    public void testValidateFalse() {

        String code = "4003301018392";
        Assert.assertEquals(false, EANValidator.validate(code));
    }
    @Test
    public void testValidateTrueChecksumZero() {

        String code = "4000000000600";
        Assert.assertEquals(true, EANValidator.validate(code));
    }
}
