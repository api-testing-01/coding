package org.fundacionjala.coding.mary;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class OCRAccount {
    private static final int CHARACTER_LIMIT = 3;

    private OCRAccount() {
    }

    public static String getAccountNumber(final File file) throws IOException {
        StringBuilder accountNumber = new StringBuilder();
        List<String> digits = getAccountLines(file);
        for (String digit: digits) {
            accountNumber.append(DigitNumber.getNumberFromDigit(digit));
        }
        return accountNumber.toString();
    }

    private static List<String> getAccountLines(final File inputFile) throws IOException {
        Scanner reader = new Scanner(inputFile);
        List<String> digits = new ArrayList<>();
        for (int i = 0; i < CHARACTER_LIMIT; i++) {
            String line = reader.nextLine();
            if (line != null) {
                int j = 0;
                for (String digit : String.format("%-27s", line).split(
                        "(?<=\\G.{3})")) {
                    try {
                        digits.set(j, digits.get(j).concat(digit));
                    } catch (IndexOutOfBoundsException e) {
                        digits.add(digit);
                    }
                    j++;
                }
            }
        }
        return digits;
    }
}
