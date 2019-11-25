package org.fundacionjala.coding.emely;

import org.junit.Assert;
import org.junit.Test;
import java.io.File;
import java.io.IOException;

public class ValidatorTest {

    @Test
    public void testValidatorValidateAccountValidNumber() throws IOException {

        File file = new File("src/test/resources/emely/faxNumberOne.txt");
        String accountNumber = FaxReader.getNumbers(file);
        Boolean isValid = Validator.validateAccount(accountNumber);
        Assert.assertTrue(isValid);
    }

    @Test
    public void testValidatorValidateAccountNoValidNumber() throws IOException {

        File file = new File("src/test/resources/emely/faxNumber.txt");
        String accountNumber = FaxReader.getNumbers(file);
        Boolean isValid = Validator.validateAccount(accountNumber);
        Assert.assertFalse(isValid);
    }
}
