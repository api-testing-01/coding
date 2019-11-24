package org.fundacionjala.coding.joseCardozo.bankOCR;

import org.junit.Test;
import java.io.IOException;
import org.junit.Assert;

public class ReadAccountNumberTest {

    @Test
    public void getAccountNumber1() throws IOException {
        ReadAccountNumber readAccountNumber = new ReadAccountNumber();
        String actualAccountNumber = readAccountNumber.getAccountNumber("account.txt");
        final String expectedResult =  "111111111";
        Assert.assertEquals(expectedResult, actualAccountNumber);
    }

    @Test
    public void getAccountNumber0() throws IOException {
        ReadAccountNumber readAccountNumber = new ReadAccountNumber();
        String actualAccountNumber = readAccountNumber.getAccountNumber("account1.txt");
        final String expectedResult =  "000000000";
        Assert.assertEquals(expectedResult, actualAccountNumber);
    }

    @Test
    public void getAccountNumber2() throws IOException {
        ReadAccountNumber readAccountNumber = new ReadAccountNumber();
        String actualAccountNumber = readAccountNumber.getAccountNumber("account2.txt");
        final String expectedResult =  "222222222";
        Assert.assertEquals(expectedResult, actualAccountNumber);
    }
}
