package org.fundacionjala.coding.edgar;

public  class EanValidator {
    public static boolean validate(final String eanCode) {
        int sum = 0;

        for (int i = 0; i < 13; i++)
            sum += (eanCode.charAt(i) - '0') * (((i & 1) << 1) | 1);

        return (sum % 10) == 0;
    }
}
