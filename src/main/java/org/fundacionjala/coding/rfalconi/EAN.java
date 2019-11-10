package org.fundacionjala.coding.rfalconi;

import java.util.logging.Logger;
import java.util.logging.Level;

public class EAN {

    private static final Logger LOGGER = Logger.getLogger("org.fundacionjala.coding.rfalconi.EAN");
    private static final int TEN = 10;
    private static final int BARCODELENGTH = 13;
    private static final int CHECKSUMLENGTH = 12;

    public boolean getChecksum(final String barcode) {
        boolean valid = false;
        if (barcode.length() == BARCODELENGTH) {
            String newBarcode = barcode.substring(0, CHECKSUMLENGTH);
            int checksum = 0;
            int sum = this.getSum(barcode);
            if ((sum % TEN) != 0) {
                checksum = TEN - (sum % TEN);
            }
            newBarcode = newBarcode.concat(String.valueOf(checksum));

            LOGGER.log(Level.INFO, "Barcode: {0}", barcode);
            LOGGER.log(Level.INFO, "New Barcode: {0}", newBarcode);

            if (barcode.equals(newBarcode)) {
                valid = true;
            }
        } else {
            valid = false;
        }
        return valid;
    }

    public int getSum(final String barcode) {
        int sum = 0;
        final int pair = 3;
        int non = 1;

        char[] digitChar = barcode.toCharArray();
        for (int i = 0; i < digitChar.length - 1; i++) {
            if (i % 2 == 0) {
                sum = sum + (Integer.parseInt(String.valueOf(digitChar[i])) * non);
            } else {
                sum = sum + (Integer.parseInt(String.valueOf(digitChar[i])) * pair);
            }
        }
        return sum;
    }
}
