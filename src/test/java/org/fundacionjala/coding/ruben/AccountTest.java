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

    @Test
    public void getAccountZerosTest() throws FileNotFoundException {
        File file = new File("src/test/resources/ruben/accountZeros.txt");
        Assert.assertEquals("000000000", Account.getAccountNumber(file));
    }

    @Test
    public void getAccountChecksumTest() throws FileNotFoundException {
        File file = new File("src/test/resources/ruben/accountChecksum.txt");
        String accountNumber = Account.getAccountNumber(file);
        Assert.assertTrue(AccountChecksum.validateChecksum(accountNumber));
    }

    @Test
    public void getAccountIllegibleTest() throws FileNotFoundException {
        File file = new File("src/test/resources/ruben/accountIllegible.txt");
        String accountNumber = Account.getAccountNumber(file);
        Assert.assertEquals("1234?678? ILL", AccountChecksum.checkLegibleAccount(accountNumber));
    }

    @Test
    public void getAccountLegibleTest() throws FileNotFoundException {
        File file = new File("src/test/resources/ruben/account123456789.txt");
        String accountNumber = Account.getAccountNumber(file);
        Assert.assertEquals("123456789", AccountChecksum.checkLegibleAccount(accountNumber));
    }

    @Test
    public void getAccountErrorTest() throws FileNotFoundException {
        File file = new File("src/test/resources/ruben/accountError.txt");
        String accountNumber = Account.getAccountNumber(file);
        Assert.assertEquals("664371495 ERR", AccountChecksum.checkValidAccount(accountNumber));
    }
}
