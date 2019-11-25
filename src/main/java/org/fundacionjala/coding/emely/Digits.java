package org.fundacionjala.coding.emely;

import java.util.List;

public final class Digits {

    private static final int ROWSNUMBER = 3;
    private static final int DIGITNUMBER = 3;
    private static final int OPTIONS = 10;

    private Digits() {
    }

    private static String info =
            " _     _  _     _  _  _  _  _ "
                    + "| |  | _| _||_||_ |_   ||_||_|"
                    + "|_|  ||_  _|  | _||_|  ||_| _|"
                    + "                              ";

    public static String parse(final List<String> data) {
        if (data.size() % ROWSNUMBER != 0) {
            throw new IllegalArgumentException("Number of input rows must be a positive multiple of " + ROWSNUMBER);
        }

        StringBuilder[] res = new StringBuilder[data.size() / ROWSNUMBER];

        for (int row = 0; row < data.size() / ROWSNUMBER; row++) {
            res[row] = new StringBuilder();
            for (int col = 0; col < data.get(row).length() / DIGITNUMBER; col++) {
                for (int i = 0; i < OPTIONS; i++) {
                    boolean found = true;
                    found = compareDigits(data, row, col, i);
                    if (found) {
                        res[row].append(i);
                        break;
                    }
                    if (i == OPTIONS - 1) {
                        res[row].append('?');
                    }
                }
            }
        }
        return String.join(",", res);
    }

    private static boolean compareDigits(final List<String> data, int row, int col, int options) {
        boolean found = true;
        for (int j = 0; j < DIGITNUMBER; j++) {
            if (!data.get(DIGITNUMBER * row + j).substring(DIGITNUMBER * col, DIGITNUMBER * (col + 1))
                    .equals(info.substring(DIGITNUMBER * (OPTIONS * j + options),
                            DIGITNUMBER * (OPTIONS * j + options + 1)))) {
                found = false;
                break;
            }
        }
        return found;
    }
}
