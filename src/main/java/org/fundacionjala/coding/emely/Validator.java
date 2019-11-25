package org.fundacionjala.coding.emely;

public final class Validator {

    private static final int MOD_11 = 11;

    private Validator() {
    }

    public static boolean validateAccount(final String account) {
        boolean isValid = false;
        int multiplier = 2;
        String[] digits = account.split("");
        int total = Integer.parseInt(digits[digits.length - 1]);
        for (int position = digits.length - 1; position >= 0; position--) {
            total = total + Integer.parseInt(digits[position]) * multiplier;
            multiplier++;
        }
        if (total % MOD_11 == 0) {
            isValid = true;
        }
        return isValid;
    }

}
