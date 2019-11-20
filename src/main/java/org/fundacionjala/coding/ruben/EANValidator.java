package org.fundacionjala.coding.ruben;

public final class EANValidator {

<<<<<<< HEAD
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
=======
    public static final int ODD_NUMBER_MULTIPLIER = 3;
    public static final int CHECKSUM_CALCULATOR = 10;

    private EANValidator() {
        // private constructor
    }

    public static boolean validate(final String eanCode) {
        String[] result = eanCode.split("");
        int[] eanNumbers = new int[eanCode.length()];
        int sum = 0;
        for (int count = 0; count < result.length; count++) {
            eanNumbers[count] = Integer.parseInt(result[count]);
        }
        for (int count = 1; count < eanNumbers.length - 1; count = count + 2) {
            eanNumbers[count] = eanNumbers[count] * ODD_NUMBER_MULTIPLIER;
        }
        for (int count = 0; count < eanNumbers.length - 1; count++) {
            sum = sum + eanNumbers[count];
        }
        int checkSum = CHECKSUM_CALCULATOR - (sum % CHECKSUM_CALCULATOR);
        if (checkSum == eanNumbers[eanNumbers.length - 1]) {
            return true;
        } else {
            return checkSum == CHECKSUM_CALCULATOR && eanNumbers[result.length - 1] == 0;
        }
>>>>>>> b521de959ac1d1e9045496e60de85cd339142d8f
    }
}
