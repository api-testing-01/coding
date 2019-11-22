package org.fundacionjala.coding.marco;

public final class EANValidator {

    public static final int DIVIDABLE_BY_TEN = 10;
    public static final int TWELVE_DIGITS = 12;
    public static final int EVEN_POSITION_MULTIPLIER = 3;

    private EANValidator() {
    }

    public static boolean validate(final String eanCode) {
        int expected = Character.getNumericValue(eanCode.charAt(TWELVE_DIGITS));
        int actual = getControlDigit(eanCode.substring(0, TWELVE_DIGITS));

        return actual == expected;
    }

    private static int getControlDigit(final String code) {
        int total = 0;
        for (int i = 0; i < TWELVE_DIGITS; i++) {
            int digit = Character.getNumericValue(code.charAt(i));
            total += ((i + 1) % 2 == 0) ? digit * EVEN_POSITION_MULTIPLIER : digit;
        }
        return total % DIVIDABLE_BY_TEN == 0 ? 0 : DIVIDABLE_BY_TEN - (total % DIVIDABLE_BY_TEN);
    }
}
