package org.fundacionjala.coding.emely;

import org.junit.Assert;
import org.junit.Test;
import java.io.File;
import java.io.IOException;

public class FaxReaderTest {

    @Test
    public void testFaxReaderGetNumbers_CompleteNumber() throws IOException {

        File file = new File("src/test/resources/emely/faxNumber.txt");
        String accountNumber = FaxReader.getNumbers(file);
        Assert.assertEquals("The number cannot be read", "1234567890", accountNumber);
   }

    @Test
    public void testFaxReaderGetNumbers_ZeroNumber() throws IOException {

        File file = new File("src/test/resources/emely/faxNumberZero.txt");
        String accountNumber = FaxReader.getNumbers(file);
        Assert.assertEquals("The number cannot be read", "0000000000", accountNumber);
    }

    @Test
    public void testFaxReaderGetNumbers_OneNumber() throws IOException {

        File file = new File("src/test/resources/emely/faxNumberOne.txt");
        String accountNumber = FaxReader.getNumbers(file);
        Assert.assertEquals("The number cannot be read", "1111111111", accountNumber);
    }

/*
    @Test
    public void testParseFile_MultipleAccounts() throws IOException {

        File file = new File("src/test/resources/emely/faxNumber.txt");
        String accountNumber = faxReader.getNumbers(file);

        assertEquals("Could not parse all account numbers", 10, accountNumber);
    }
*/
/*
    private File getTestFile(String fileName) {

        URL testFileUrl = ClassLoader.getSystemResource(fileName);
        return new File(testFileUrl.getPath());
    }*/
}

