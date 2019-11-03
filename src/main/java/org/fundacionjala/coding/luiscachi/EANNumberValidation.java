package org.fundacionjala.coding.luiscachi;

public class EANNumberValidation {
    private final int moduleNumber = 10;
    private final int eanLength = 13;

    public boolean eanValidation(final String eanNum) {
        final int evenMultiplier = 3;
        String[] numbers = eanNum.split("");
        int eannumber = 0;
        int checkSum = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            int digit = Integer.parseInt(numbers[i]);
            if (i % 2 == 0) {
                checkSum += digit;
            } else {
                checkSum += digit * evenMultiplier;
            }
        }
        if (checkSum % moduleNumber != 0) {
            eannumber = moduleNumber - (checkSum % moduleNumber);
        }
        if (numbers.length == eanLength
                && eannumber == Integer.parseInt(numbers[numbers.length - 1])) {
            return true;
        }
        return false;
    }
}
