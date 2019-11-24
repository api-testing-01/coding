package org.fundacionjala.coding.magali;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

final class AccountNumberParser {

    private static final int LIMIT = 3;

    private AccountNumberParser() {
    }

    public static String accountNumberParser(final File file) throws IOException {
        StringBuilder accountNumber = new StringBuilder();
        List<String> digits = readAccountNumberLines(file);
        for (String digit : digits) {
            accountNumber.append(Digits.numberFromChar(digit));
        }
        return accountNumber.toString();
    }

    private static List<String> readAccountNumberLines(final File inputFile) throws IOException {
        List<String> digits = new ArrayList<>();
        try (Scanner reader = new Scanner(inputFile)) {
            for (int i = 0; i < LIMIT; i++) {
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
        }
        return digits;
    }
}
