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
}
