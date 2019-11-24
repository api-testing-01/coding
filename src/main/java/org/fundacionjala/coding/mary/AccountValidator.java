package org.fundacionjala.coding.mary;

public final class AccountValidator {
    private static final int MOD_11 = 11;

    private AccountValidator() {
    }

    public static String checkLegibleAccount(final String accountNumber) {
        return (accountNumber.contains(DigitNumber.ILLEGIBLE_DIGIT)) ? accountNumber + " ILL" : accountNumber;
    }

    public static String statusAccount(final String accountNumber) {
        return (validChecksum(accountNumber)) ? accountNumber : accountNumber + " ERR";
    }

    private static boolean validChecksum(final String account) {
        int sum = 0;
        int multiplierIndex = 1;
        String[] digits = account.split("");

        for (int index = digits.length - 1; index > 0; index--) {
            multiplierIndex++;
            int number = Integer.parseInt(digits[index]);
            sum += number * (multiplierIndex);
        }
        sum += Integer.parseInt(digits[0]);

        return sum % MOD_11 == 0;
    }
}
