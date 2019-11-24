package org.fundacionjala.coding.miguel;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankOCRTest {
    private FileAccountReader accountReader = new FileAccountReader();

    @Test
    public void readNumberAccount() {
        String[] numberAccount = accountReader.readerAccountFile("account.txt");
        assertEquals("000000000", new BankOCR().translateNumberAccount(numberAccount));
    }

    @Test
    public void readNumberAccount01() {
        String[] numberAccount = accountReader.readerAccountFile("account_1.txt");
        assertEquals("111111111", new BankOCR().translateNumberAccount(numberAccount));
    }

    @Test
    public void readNumberAccount02() {
        String[] numberAccount = accountReader.readerAccountFile("account_2.txt");
        assertEquals("222222222", new BankOCR().translateNumberAccount(numberAccount));
    }

    @Test
    public void readNumberAccount03() {
        String[] numberAccount = accountReader.readerAccountFile("account_3.txt");
        assertEquals("333333333", new BankOCR().translateNumberAccount(numberAccount));
    }

    @Test
    public void readNumberAccount04() {
        String[] numberAccount = accountReader.readerAccountFile("account_4.txt");
        assertEquals("444444444", new BankOCR().translateNumberAccount(numberAccount));
    }

    @Test
    public void readNumberAccount05() {
        String[] numberAccount = accountReader.readerAccountFile("account_5.txt");
        assertEquals("555555555", new BankOCR().translateNumberAccount(numberAccount));
    }

    @Test
    public void readNumberAccount06() {
        String[] numberAccount = accountReader.readerAccountFile("account_6.txt");
        assertEquals("666666666", new BankOCR().translateNumberAccount(numberAccount));
    }

    @Test
    public void readNumberAccount07() {
        String[] numberAccount = accountReader.readerAccountFile("account_7.txt");
        assertEquals("777777777", new BankOCR().translateNumberAccount(numberAccount));
    }

    @Test
    public void readNumberAccount08() {
        String[] numberAccount = accountReader.readerAccountFile("account_8.txt");
        assertEquals("888888888", new BankOCR().translateNumberAccount(numberAccount));
    }

    @Test
    public void readNumberAccount09() {
        String[] numberAccount = accountReader.readerAccountFile("account_9.txt");
        assertEquals("999999999", new BankOCR().translateNumberAccount(numberAccount));
    }

    @Test
    public void readNumberAccount10() {
        String[] numberAccount = accountReader.readerAccountFile("account_10.txt");
        assertEquals("123456789", new BankOCR().translateNumberAccount(numberAccount));
    }

    @Test
    public void verifyNumberAccountAuthenticityTrue() {
        assertEquals(true, new BankOCR().verifyAuthenticity("345882865"));
    }

    @Test
    public void verifyNumberAccountAuthenticityFalse() {
        assertEquals(false, new BankOCR().verifyAuthenticity("345882868"));
    }

    @Test
    public void verifyAndPrintInFileValid() {
        String[] numberAccount = accountReader.readerAccountFile("account_valid.txt");
        assertEquals("345882865", new BankOCR().verifyAndPrintInFile(numberAccount));
    }

    @Test
    public void verifyAndPrintInFileInValid() {
        String[] numberAccount = accountReader.readerAccountFile("account_invalid.txt");
        assertEquals("345882868 ERR", new BankOCR().verifyAndPrintInFile(numberAccount));
    }

    @Test
    public void verifyAndPrintInFileIll() {
        String[] numberAccount = accountReader.readerAccountFile("account_ill.txt");
        assertEquals("34588286? ILL", new BankOCR().verifyAndPrintInFile(numberAccount));
    }
}
