package org.fundacionjala.coding.rfalconi;

import org.junit.Assert;
import org.junit.Test;

public class BankOCRTest {

    @Test
    public void userStory2Test() {
        BankOCR ocr = new BankOCR();
        Assert.assertTrue("Account is valid ", ocr.userStory2("345882865"));
        Assert.assertTrue("Account is valid ", ocr.userStory2("457508000"));
        Assert.assertFalse("Account is valid ", ocr.userStory2("457508005"));
        Assert.assertFalse("Account is not valid ", ocr.userStory2("6643714>5"));
    }

    @Test
    public void userStory3Test() {
        BankOCR ocr = new BankOCR();
        Assert.assertTrue("Account is valid ", ocr.userStory3("345882865"));
        Assert.assertTrue("Account is valid ", ocr.userStory3("664371495"));
        Assert.assertFalse("Account is The account is illegible ", ocr.userStory3("66437149A"));
        Assert.assertFalse("Account is The account is illegible ", ocr.userStory3("6643E149A"));
    }
}
