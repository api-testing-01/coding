package org.fundacionjala.coding.magali;

public final class EANValidator {
    private EANValidator() {
    }

    public static boolean validate(final String eanCode) {
        final int ten = 10;
        final int multiplier = 3;
        String[] numberArray = eanCode.split("");
        int sum = 0;
        for (int i = 0; i < numberArray.length - 1; i++) {
            int number = Integer.parseInt(numberArray[i]);
            if (i % 2 == 0) {
                sum += number;
            } else {
                sum += number * multiplier;
            }
        }
        int checksum = 0;
        if (sum % ten != 0) {
            checksum = ten - (sum % ten);
        }
        return checksum == Integer.parseInt(numberArray[numberArray.length - 1]);
    }
}
