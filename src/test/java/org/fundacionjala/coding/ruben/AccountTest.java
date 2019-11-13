package org.fundacionjala.coding.ruben;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

public class AccountTest {

    @Test
    public void getAccountNumberTest() throws FileNotFoundException {
        File file = new File("src/test/resources/ruben/account123456789.txt");
        Assert.assertEquals("123456789", Account.getAccountNumber(file));
    }
}