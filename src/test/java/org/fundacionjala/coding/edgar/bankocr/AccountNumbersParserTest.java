package org.fundacionjala.coding.edgar.bankocr;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AccountNumbersParserTest {

    @Test
    public void testParseAccountNumber() {

        char [][] testAccountNumber = {
                {' ','_',' ', ' ','_',' ', ' ','_',' ', ' ','_',' ', ' ','_',' ', ' ','_',' ', ' ','_',' ', ' ', '_',' '
                        , ' ','_',' '},
                {'|',' ','|', '|',' ','|', '|',' ','|', '|',' ','|', '|',' ','|', '|',' ','|', '|',' ','|', '|', ' ','|'
                        , '|',' ','|'},
                {'|','_','|', '|','_','|', '|','_','|', '|','_','|', '|','_','|', '|','_','|', '|','_','|', '|', '_','|'
                        , '|','_','|'}
        };

        String accountNumber = AccountNumbersParser.parseAccountNumber(testAccountNumber);

        assertEquals("Cannot parse account number", "000000000", accountNumber);
    }

    @Test
    public void testParseDigit() {

        String sb = "Cannot parse digit";

        List<char[][]> testDigits = getTestDigits();

        assertEquals(sb, '0', AccountNumbersParser.parseDigit(testDigits.get(0)));
        assertEquals(sb, '1', AccountNumbersParser.parseDigit(testDigits.get(1)));
        assertEquals(sb, '2', AccountNumbersParser.parseDigit(testDigits.get(2)));
        assertEquals(sb, '3', AccountNumbersParser.parseDigit(testDigits.get(3)));
        assertEquals(sb, '4', AccountNumbersParser.parseDigit(testDigits.get(4)));
        assertEquals(sb, '5', AccountNumbersParser.parseDigit(testDigits.get(5)));
        assertEquals(sb, '6', AccountNumbersParser.parseDigit(testDigits.get(6)));
        assertEquals(sb, '7', AccountNumbersParser.parseDigit(testDigits.get(7)));
        assertEquals(sb, '8', AccountNumbersParser.parseDigit(testDigits.get(8)));
        assertEquals(sb, '9', AccountNumbersParser.parseDigit(testDigits.get(9)));
    }

    private List<char[][]> getTestDigits() {

        char[][] testDigit0 = new char[][] {
                {' ','_',' '},
                {'|',' ','|'},
                {'|','_','|'},
        };

        char[][] testDigit1 = new char[][] {
                {' ',' ',' '},
                {' ',' ','|'},
                {' ',' ','|'},
        };

        char[][] testDigit2 = new char[][] {
                {' ','_',' '},
                {' ','_','|'},
                {'|','_',' '},
        };

        char[][] testDigit3 = new char[][] {
                {' ','_',' '},
                {' ','_','|'},
                {' ','_','|'},
        };

        char[][] testDigit4 = new char[][] {
                {' ',' ',' '},
                {'|','_','|'},
                {' ',' ','|'},
        };

        char[][] testDigit5 = new char[][] {
                {' ','_',' '},
                {'|','_',' '},
                {' ','_','|'},
        };

        char[][] testDigit6 = new char[][] {
                {' ','_',' '},
                {'|','_',' '},
                {'|','_','|'},
        };

        char[][] testDigit7 = new char[][] {
                {' ','_',' '},
                {' ',' ','|'},
                {' ',' ','|'},
        };

        char[][] testDigit8 = new char[][] {
                {' ','_',' '},
                {'|','_','|'},
                {'|','_','|'},
        };

        char[][] testDigit9 = new char[][] {
                {' ','_',' '},
                {'|','_','|'},
                {' ','_','|'},
        };

        List<char[][]> testDigits = new ArrayList<>();
        testDigits.add(testDigit0);
        testDigits.add(testDigit1);
        testDigits.add(testDigit2);
        testDigits.add(testDigit3);
        testDigits.add(testDigit4);
        testDigits.add(testDigit5);
        testDigits.add(testDigit6);
        testDigits.add(testDigit7);
        testDigits.add(testDigit8);
        testDigits.add(testDigit9);

        return testDigits;
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseDigit_failure() {

        char[][] testDigit = new char[][] {
                {' ','_',' '},
                {'|','?','|'},
                {'|','_','|'},
        };

        AccountNumbersParser.parseDigit(testDigit);
    }
}

