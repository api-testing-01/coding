package org.fundacionjala.coding.emely;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FaxReader {

    public static String getNumbers(File file) throws IOException {
        List<String> digits = readLines(file);
        String result = Digits.parse(digits);
        return result;
    }

    private static List<String> readLines(File file) throws IOException {

        List<String> lines = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);
            for (int i = 0; i < 3; i++) {
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
