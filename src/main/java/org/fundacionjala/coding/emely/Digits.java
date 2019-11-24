package org.fundacionjala.coding.emely;

import java.util.List;

public final class Digits {

    private static String info =
            " _     _  _     _  _  _  _  _ " +
                    "| |  | _| _||_||_ |_   ||_||_|" +
                    "|_|  ||_  _|  | _||_|  ||_| _|" +
                    "                              ";

    public static String parse(List<String> data) {
        if (data.size() % 3 != 0)
            throw new IllegalArgumentException("Number of input rows must be a positive multiple of 3");

        StringBuilder res[] = new StringBuilder[data.size() / 3];

        for (int row = 0; row < data.size() / 3; row++) {
            res[row] = new StringBuilder();
            for (int col = 0; col < data.get(row).length() / 3; col++) {
                for (int i = 0; i < 10; i++) {
                    boolean found = true;
                    for (int j = 0; j < 3; j++) {
                        if (!data.get(4 * row + j).substring(3 * col, 3 * (col + 1))
                                .equals(info.substring(3 * (10 * j + i), 3 * (10 * j + i + 1)))) {
                            found = false;
                            break;
                        }
                    }
                    if (found) {
                        res[row].append(i);
                        break;
                    }
                    if (i == 9) res[row].append('?');
                }
            }
        }
        return String.join(",", res);
    }
}
