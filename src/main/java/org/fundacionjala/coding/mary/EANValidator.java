package org.fundacionjala.coding.mary;

public final class EANValidator {
    private static final int MOD_10 = 10;
    private static final int TOTAL = 10;
    private static final int MULTIPLIED_BY_3 = 3;

    private EANValidator() {
    }

    public static boolean validate(final String eanCode) {
        return Character.getNumericValue(eanCode.charAt(eanCode.length() - 1)) == checksum(eanCode);
    }

    private static int checksum(final String eanCode) {
        int sum = 0;
        String[] digits = eanCode.split("");

        for (int index = 0; index < digits.length - 1; index++) {
            int number = Integer.parseInt(digits[index]);
            sum += (index + 1) % 2 != 0 ? number : number * MULTIPLIED_BY_3;
        }

        return sum % MOD_10 == 0 ? 0 : TOTAL - (sum % MOD_10);
    }
}

