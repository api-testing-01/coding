package org.fundacionjala.coding.emely;

import org.junit.Assert;
import org.junit.Test;
import java.io.File;
import java.io.IOException;

public class FaxReaderTest {

    @Test
    public void testFaxReaderGetNumbersCompleteNumber() throws IOException {

        File file = new File("src/test/resources/emely/faxNumber.txt");
        String accountNumber = FaxReader.getNumbers(file);
        Assert.assertEquals("1234567890", accountNumber);
    }

    @Test
    public void testFaxReaderGetNumbersZeroNumber() throws IOException {

        File file = new File("src/test/resources/emely/faxNumberZero.txt");
        String accountNumber = FaxReader.getNumbers(file);
        Assert.assertEquals("0000000000", accountNumber);
    }

    @Test
    public void testFaxReaderGetNumbersOneNumber() throws IOException {

        File file = new File("src/test/resources/emely/faxNumberOne.txt");
        String accountNumber = FaxReader.getNumbers(file);
        Assert.assertEquals("1111111111", accountNumber);
    }
}
