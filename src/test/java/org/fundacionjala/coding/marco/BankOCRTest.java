package org.fundacionjala.coding.marco;

import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.junit.Test;

public class BankOCRTest {

    @Test
    public void getAccountNumbersTest() throws IOException {

        File testFile = getTestFile("account-numbers.txt");
        List<String> accountNumbers = BankOCR.getAccountNumbers(testFile);
        int indexLine = 0;

        assertEquals("Cannot parse account number", "000000000", accountNumbers.get(indexLine++));
        assertEquals("Cannot parse account number", "111111111", accountNumbers.get(indexLine++));
        assertEquals("Cannot parse account number", "222222222", accountNumbers.get(indexLine++));
        assertEquals("Cannot parse account number", "333333333", accountNumbers.get(indexLine++));
        assertEquals("Cannot parse account number", "444444444", accountNumbers.get(indexLine++));
        assertEquals("Cannot parse account number", "555555555", accountNumbers.get(indexLine++));
        assertEquals("Cannot parse account number", "666666666", accountNumbers.get(indexLine++));
        assertEquals("Cannot parse account number", "777777777", accountNumbers.get(indexLine++));
        assertEquals("Cannot parse account number", "888888888", accountNumbers.get(indexLine++));
        assertEquals("Cannot parse account number", "999999999", accountNumbers.get(indexLine++));
        assertEquals("Cannot parse account number", "123456789", accountNumbers.get(indexLine++));
    }

    private File getTestFile(final String fileName) {

        URL testFileUrl = ClassLoader.getSystemResource(fileName);
        return new File(testFileUrl.getPath());
    }

}
