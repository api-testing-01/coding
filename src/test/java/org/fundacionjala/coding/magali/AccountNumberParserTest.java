package org.fundacionjala.coding.magali;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class AccountNumberParserTest {

    @Test
    public void getAccountNumberTest() throws IOException {
        File file = new File("src/test/resources/magali/account-numbers.txt");
        Assert.assertEquals("123456789", AccountNumberParser.accountNumberParser(file));
    }

    @Test
    public void getAccountNumberTest01() throws IOException {
        File file = new File("src/test/resources/magali/account-numbers1.txt");
        Assert.assertEquals("000000051", AccountNumberParser.accountNumberParser(file));
    }

    @Test
    public void getAccountNumberTest02() throws IOException {
        File file = new File("src/test/resources/magali/account-numbers2.txt");
        Assert.assertEquals("999999999", AccountNumberParser.accountNumberParser(file));
    }
}
