package org.fundacionjala.coding.ruben;

public final class EANValidator {

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
    }
}
