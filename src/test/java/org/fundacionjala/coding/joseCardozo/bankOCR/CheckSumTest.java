package org.fundacionjala.coding.joseCardozo.bankOCR;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class CheckSumTest {
    @Test
    public void checkSumAccount() throws IOException {
        ReadAccountNumber readAccountNumber = new ReadAccountNumber();
        boolean isActualAccountValid = readAccountNumber.getCheckSumAccountNumber("checkSummAccount1.txt");
        Assert.assertTrue(isActualAccountValid);
    }

    @Test
    public void checkSumAccount1() throws IOException {
        ReadAccountNumber readAccountNumber = new ReadAccountNumber();
        boolean isActualAccountValid = readAccountNumber.getCheckSumAccountNumber("checkSummAccount2.txt");
        Assert.assertFalse(isActualAccountValid);
    }
}
