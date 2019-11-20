package org.fundacionjala.coding.ruben;

public final class EANValidator {

    private static final int MULTIPLIER_NUMBER = 3;
    private static final int MOD_NUMBER = 10;
    private static final int LAST_DIGIT = 12;

    private EANValidator() {
        //private class
    }

    public static boolean validate(final String eanCode) {
        int sum = 0;

        for (int count = 0; count < eanCode.split("").length - 1; count++) {
            int number = Character.getNumericValue(eanCode.charAt(count));
            if (count % 2 == 0) {
                sum = sum + number;
            } else {
                sum = sum + number * MULTIPLIER_NUMBER;
            }
        }

        int checkSum = (sum % MOD_NUMBER);
        return checkSum == Character.getNumericValue(eanCode.charAt(LAST_DIGIT));
    }
}
