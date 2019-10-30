package org.fundacionjala.coding.edgar;

public final class EanValidator {
    private static final int TEN = 10;
    private static final int THIRTEEN = 13;
    private EanValidator() {
    }

    public static boolean validate(final String eanCode) {
        int sum = 0;

        for (int i = 0; i < THIRTEEN; i++) {
            sum += (eanCode.charAt(i) - '0') * (((i & 1) << 1) | 1);

        }
        return (sum % TEN) == 0;
    }
}
