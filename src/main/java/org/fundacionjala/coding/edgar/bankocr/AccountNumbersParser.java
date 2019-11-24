package org.fundacionjala.coding.edgar.bankocr;

import java.util.Arrays;

public final class AccountNumbersParser {
    private AccountNumbersParser() {
    }

    private static final int NUMBER_OF_DIGIT_COLS = 3;
    private static final int NUMBER_OF_DIGIT_ROWS = 3;
    private static final int NUMBER_OF_DIGITS = 9;

    static String parseAccountNumber(final char[][] accountNumber) {

        StringBuilder sb = new StringBuilder();

        for (int digitIndex = 0; digitIndex < NUMBER_OF_DIGITS; digitIndex++) {
            char[][] digit = new char[NUMBER_OF_DIGIT_ROWS][NUMBER_OF_DIGIT_COLS];

            int digitStartIndex = digitIndex * NUMBER_OF_DIGIT_COLS;
            int digitEndIndex = digitStartIndex + NUMBER_OF_DIGIT_COLS;

            for (int rowIndex = 0; rowIndex < NUMBER_OF_DIGIT_ROWS; rowIndex++) {
                digit[rowIndex] = Arrays.copyOfRange(accountNumber[rowIndex], digitStartIndex, digitEndIndex);
            }

            sb.append(parseDigit(digit));
        }

        return sb.toString();
    }

    static char parseDigit(final char[][] digit) {

        if (Arrays.deepEquals(digit, Digits.ZERO)) {
            return '0';
        } else if (Arrays.deepEquals(digit, Digits.ONE)) {
            return '1';
        } else if (Arrays.deepEquals(digit, Digits.TWO)) {
            return '2';
        } else if (Arrays.deepEquals(digit, Digits.THREE)) {
            return '3';
        } else if (Arrays.deepEquals(digit, Digits.FOUR)) {
            return '4';
        } else if (Arrays.deepEquals(digit, Digits.FIVE)) {
            return '5';
        } else if (Arrays.deepEquals(digit, Digits.SIX)) {
            return '6';
        } else if (Arrays.deepEquals(digit, Digits.SEVEN)) {
            return '7';
        } else if (Arrays.deepEquals(digit, Digits.EIGHT)) {
            return '8';
        } else if (Arrays.deepEquals(digit, Digits.NINE)) {
            return '9';
        } else {
            throw new IllegalArgumentException("Cannot parse digit " + Arrays.deepToString(digit));
        }
    }
}
