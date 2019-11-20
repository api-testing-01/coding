package org.fundacionjala.coding.magali;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class AccountNumberValidationTest {

    @Test
    public void testChecksum() {
        AccountNumberValidation accountNumber = new AccountNumberValidation("345882865");
        int checksum = accountNumber.checksumOf();
        Assert.assertThat(checksum, is(0));
    }

    @Test
    public void testIsValid() {
        AccountNumberValidation accountNumber = new AccountNumberValidation("345882865");
        boolean valid = accountNumber.isValid();
        Assert.assertTrue(valid);
    }

    @Test
    public void testIsIllegal() {
        AccountNumberValidation accountNumber = new AccountNumberValidation("3458??865");
        boolean illegal = accountNumber.isIllegal();
        Assert.assertTrue(illegal);
    }

    @Test
    public void testIsValidWithIllegalAccountNumber() {
        AccountNumberValidation accountNumber = new AccountNumberValidation("3458??865");
        boolean valid = accountNumber.isValid();
        Assert.assertFalse(valid);
    }
}
