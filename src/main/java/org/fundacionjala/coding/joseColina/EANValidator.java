package org.fundacionjala.coding.joseColina;

public final class EANValidator {
    private static final int RADIX_TEN = 10;
    private static final int ODD_MULTIPLIER = 1;
    private static final int EVEN_MULTIPLIER = 3;

    private EANValidator() {
    }
    public static boolean validate(final String eavnNumber) {
        boolean result = false;
        int checkSum = 0;
        int[] digits = getDigits(eavnNumber);
        int lastDigit = digits[digits.length - 1];
        int sum = calculateSum(digits);
        if (sum % RADIX_TEN != 0) {
            checkSum = RADIX_TEN - sum % RADIX_TEN;
        }
        if (checkSum == lastDigit) {
            result = true;
        }
        return result;
    }

    private static int calculateSum(final int[] digits) {
        int result = 0;
        int[] multiplier = {ODD_MULTIPLIER, EVEN_MULTIPLIER};
        for (int i = 0; i < digits.length - 1; i++) {
            result += digits[i] * multiplier[i % 2];
        }
        return result;
    }

    private static int[] getDigits(final String eavnNnumber) {
        int[] result = new int[eavnNnumber.length()];
        for (int i = 0; i < result.length; i++) {
            result[i] = Character.getNumericValue(eavnNnumber.charAt(i));
        }

        return result;
    }
}
