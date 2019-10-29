package org.fundacionjala.coding.marco;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public final class BankOCR {
    private static final int NUMBER_OF_DIGIT_COLS = 3;
    private static final int NUMBER_OF_DIGIT_ROWS = 3;
    private static final int NUMBER_OF_DIGITS = 9;
    private static char number = '0';

    private BankOCR() {
    }

    public static List<String> getAccountNumbers(final File accountNumbersFile) throws IOException {

        final List<String> accountNumbers = new ArrayList<>();
        List<String> content = Files.readAllLines(accountNumbersFile.toPath());

        for (int lineIndex = 0; lineIndex < content.size(); lineIndex += NUMBER_OF_DIGIT_ROWS + 1) {
            char[][] accountEntry = new char[NUMBER_OF_DIGIT_ROWS][NUMBER_OF_DIGIT_COLS];
            accountEntry[0] = content.get(lineIndex).toCharArray();
            accountEntry[1] = content.get(lineIndex + 1).toCharArray();
            accountEntry[2] = content.get(lineIndex + 2).toCharArray();
            accountNumbers.add(parseAccountNumber(accountEntry));
        }
        return accountNumbers;
    }

    public static String parseAccountNumber(final char[][] accountNumber) {

        StringBuilder sb = new StringBuilder();

        for (int digitIndex = 0; digitIndex < NUMBER_OF_DIGITS; digitIndex++) {
            char[][] digit = new char[NUMBER_OF_DIGIT_ROWS][NUMBER_OF_DIGIT_COLS];

            int digitStartIndex = digitIndex * NUMBER_OF_DIGIT_COLS;
            int digitEndIndex = digitStartIndex + NUMBER_OF_DIGIT_COLS;

            for (int rowIndex = 0; rowIndex < NUMBER_OF_DIGIT_ROWS; rowIndex++) {
                digit[rowIndex] = Arrays.copyOfRange(accountNumber[rowIndex], digitStartIndex, digitEndIndex);
            }
            parseDigits(digit);
            sb.append(number);
        }

        return sb.toString();
    }

    private static void parseDigits(final char[][] data) {
        Map<String, ParseDigit> strategyMap = new HashMap<>();
        strategyMap.put(Arrays.deepToString(Digits.ZERO), () -> number = '0');
        strategyMap.put(Arrays.deepToString(Digits.ONE), () -> number = '1');
        strategyMap.put(Arrays.deepToString(Digits.TWO), () -> number = '2');
        strategyMap.put(Arrays.deepToString(Digits.THREE), () -> number = '3');
        strategyMap.put(Arrays.deepToString(Digits.FOUR), () -> number = '4');
        strategyMap.put(Arrays.deepToString(Digits.FIVE), () -> number = '5');
        strategyMap.put(Arrays.deepToString(Digits.SIX), () -> number = '6');
        strategyMap.put(Arrays.deepToString(Digits.SEVEN), () -> number = '7');
        strategyMap.put(Arrays.deepToString(Digits.EIGHT), () -> number = '8');
        strategyMap.put(Arrays.deepToString(Digits.NINE), () -> number = '9');

        strategyMap.get(Arrays.deepToString(data)).execute();
    }
}
