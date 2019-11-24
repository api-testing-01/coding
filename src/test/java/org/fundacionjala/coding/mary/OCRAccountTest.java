package org.fundacionjala.coding.mary;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class OCRAccountTest {

    @Test
    public void getAccountNumberTest() throws IOException {
        File file = new File("src/test/resources/mary/accountNumber.txt");
        Assert.assertEquals("123456789", OCRAccount.getAccountNumber(file));
    }

    @Test
    public void getZeroAccountNumberTest() throws IOException {
        File file = new File("src/test/resources/mary/zeroAccount.txt");
        Assert.assertEquals("000000000", OCRAccount.getAccountNumber(file));
    }

    @Test
    public void statusErrorAccountTest() throws IOException {
        File file = new File("src/test/resources/mary/invalidAccount.txt");
        String account = OCRAccount.getAccountNumber(file);
        Assert.assertEquals("664371495 ERR", AccountValidator.statusAccount(account));
    }

    @Test
    public void validStatusAccountTest() throws IOException {
        File file = new File("src/test/resources/mary/validAccountNumber.txt");
        String account = OCRAccount.getAccountNumber(file);
        Assert.assertEquals("345882865", AccountValidator.statusAccount(account));
    }

    @Test
    public void legibleAccountNumberTest() throws IOException {
        File file = new File("src/test/resources/mary/accountNumber.txt");
        String account = OCRAccount.getAccountNumber(file);
        Assert.assertEquals("123456789", AccountValidator.checkLegibleAccount(account));
    }

    @Test
    public void illegibleAccountNumberTest() throws IOException {
        File file = new File("src/test/resources/mary/illegibleAccount.txt");
        String account = OCRAccount.getAccountNumber(file);
        Assert.assertEquals("1234?678? ILL", AccountValidator.checkLegibleAccount(account));
    }
}
