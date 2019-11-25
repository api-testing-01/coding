package org.fundacionjala.coding.carmen;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class AccountTest {

    @Test
    public void testGetAccountNumConverted1() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("carmen/cnumbers09.txt").getFile());
        Assert.assertEquals("123456789", Account.getAccountNumConverted(file));
    }

    @Test
    public void testGetAccountNumConverted2() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("carmen/cnumbers5.txt").getFile());
        Assert.assertEquals("555555559", Account.getAccountNumConverted(file));
    }

    @Test
    public void testGetAccountNumConverted3() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("carmen/cnumbers1.txt").getFile());
        Assert.assertEquals("111111111", Account.getAccountNumConverted(file));
    }

    @Test
    public void testCheckSum() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("carmen/accountCheckSum.txt").getFile());
        String convertedAccount = Account.getAccountNumConverted(file);
        Assert.assertEquals("345882865", AccountValidator.statusAccount(convertedAccount));
    }

    @Test
    public void statusErrorAccountTest() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("carmen/invalidAccount.txt").getFile());
        String account = Account.getAccountNumConverted(file);
        Assert.assertEquals("664371495 ERR", AccountValidator.statusAccount(account));
    }
}
