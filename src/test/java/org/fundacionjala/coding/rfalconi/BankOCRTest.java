package org.fundacionjala.coding.rfalconi;

import org.junit.Assert;
import org.junit.Test;

public class BankOCRTest {

    @Test
    public void userStory2Test() {
        BankOCR ocr = new BankOCR();
        Assert.assertTrue("Account is valid", ocr.validateUserStory2("345882865"));
        Assert.assertTrue("Account is valid", ocr.validateUserStory2("457508000"));
        Assert.assertFalse("Account is not valid", ocr.validateUserStory2("6643714>5"));
    }

    @Test
    public void userStory3Test() {
        BankOCR ocr = new BankOCR();
        Assert.assertEquals("345882865", ocr.userStory3("345882865"));
        Assert.assertEquals("664371495 ERR", ocr.userStory3("664371495"));
        Assert.assertEquals("66437149? ILL", ocr.userStory3("66437149A"));

    }
}
