package org.fundacionjala.coding.rfalconi;

import java.util.logging.Logger;
import java.util.logging.Level;

public class EAN {

    private static final Logger LOGGER = Logger.getLogger("org.fundacionjala.coding.rfalconi.EAN");
    private static final int TEN = 10;

    public String getChecksum(final String barcode) {
        int checksum = 0;
        int[] digits = this.getDigits(barcode);
        int sum = this.getSum(digits);
        if (!isDividableByTen(sum)) {
            checksum = TEN - (sum % TEN);
        }
        LOGGER.log(Level.INFO, "Checksum is {0}", checksum);
        return barcode.concat(String.valueOf(checksum));
    }

    public int getSum(final int[] barcode) {
        int sum = 0;
        int index = 0;
        final int counter = 2;
        final int par = 3;
        int impar = 1;
        while (barcode.length > index) {
            sum = sum + (barcode[index] * impar);
            index = index + counter;
        }
        index = 1;
        while (barcode.length > index) {
            sum = sum + (barcode[index] * par);
            index = index + counter;
        }
        return sum;
    }

    public int[] getDigits(final String barcode) {
        char[] digitChar = barcode.toCharArray();
        int[] digits = new int[barcode.length()];
        for (int i = 0; i < digitChar.length; i++) {
            digits[i] = Integer.parseInt(String.valueOf(digitChar[i]));
        }
        return  digits;
    }

    public boolean isDividableByTen(final int sum) {
        return ((sum % TEN) == 0);
    }
}
