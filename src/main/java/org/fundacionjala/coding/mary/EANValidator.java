package org.fundacionjala.coding.mary;

public final class EANValidator {
    private static final int MOD_10 = 10;
    private static final int TOTAL = 10;
    private static final int MULTIPLIED_BY_3 = 3;

    private EANValidator() {
    }

    public static boolean validate(final String eanCode) {
        double validateCode = (Double.parseDouble(eanCode)) % MOD_10;
        return (validateCode == checksum(eanCode)) ? true : false;
    }

    private static int checksum(final String eanCode) {
        int sum = 0;
        int checksum = 0;
        String[] digits = eanCode.split("");
        int[] numbers = new int[digits.length];

        for (int index = 0; index < digits.length; index++) {
            numbers[index] = Integer.parseInt(digits[index]);
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            if ((i + 1) % 2 != 0) {
                sum = sum + numbers[i];
            } else {
                sum = sum + (numbers[i] * MULTIPLIED_BY_3);
            }
        }

        if ((sum % MOD_10) != 0) {
            checksum = TOTAL - (sum % MOD_10);
        }

        return checksum;
    }
}

