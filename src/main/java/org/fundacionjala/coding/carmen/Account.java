package org.fundacionjala.coding.carmen;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

final class Account {
    private static final int LIMIT_COLS = 3;
    private static final int INDEX_NEXT_NUM = 4;
    private static final int LIMIT_NUMS = 9;

    private Account() {
    }

    public static String getAccountNumConverted(final File accountNumbersFile) throws IOException {
        final List<String> content = Files.readAllLines(accountNumbersFile.toPath());
        List<List<String>> contentParsed = new LinkedList<List<String>>();

        //for read more than line of numbers, future implementation.
        for (int lineIndex = 0; lineIndex < content.size(); lineIndex += INDEX_NEXT_NUM) {
            contentParsed.add(splitByNumber(content.get(lineIndex)));
            contentParsed.add(splitByNumber(content.get(lineIndex + 1)));
            contentParsed.add(splitByNumber(content.get(lineIndex + 2)));
        }
        return getAccountParsed(contentParsed);
    }

    public static String getAccountParsed(final List<List<String>> contentParsed) {
        StringBuilder accountNumber = new StringBuilder();
        String row1 = "";
        String row2 = "";
        String row3 = "";
        for (int numIndex = 0; numIndex < LIMIT_NUMS; numIndex++) {

            if (contentParsed.get(0).size() != 0) {
                row1 = fixDigit(contentParsed.get(0).get(numIndex));
            } else {
                row1 = "   ";
            }

            row2 = fixDigit(contentParsed.get(1).get(numIndex));
            row3 = fixDigit(contentParsed.get(2).get(numIndex));

            String digit = row1 + row2 + row3;
            accountNumber.append(Digits.getNumberFromDigit(digit));
        }
        return accountNumber.toString();
    }

    public static String fixDigit(final String text) {
        String result = "";
        if (text.equals(" _")) {
            result = " _ ";
        } else {
            if (text.equals("|_")) {
                result = "|_ ";
            } else {
                result = text;
            }
        }
        return result;
    }

    public static List<String> splitByNumber(final String text) {
        List<String> list = new ArrayList<String>();
        int index = 0;
        while (index < text.length()) {
            list.add(text.substring(index, Math.min(index + LIMIT_COLS, text.length())));
            index = index + LIMIT_COLS;
        }
        return list;
    }
}
