package org.fundacionjala.coding.emely;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class FaxReader {

    private static final int ROWSNUMBER = 3;

    private FaxReader() {
    }

    public static String getNumbers(final File file) throws IOException {
        List<String> digits = readLines(file);
        return Digits.parse(digits);
    }

    private static List<String> readLines(final File file) throws IOException {

        List<String> lines = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);
            for (int i = 0; i < ROWSNUMBER; i++) {
                String line = scanner.nextLine();
                if (line != null) {
                    lines.add(line);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
