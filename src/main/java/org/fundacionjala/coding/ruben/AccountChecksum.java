package org.fundacionjala.coding.ruben;

public class AccountChecksum {

    private static final int MODAL = 11;
    private static final String ILLEGIBLE = "?";

    private AccountChecksum() {
        // private constructor
    }

    public static boolean validateChecksum(final String account) {
        String[] digits = account.split("");
        int sum = 0;
        int multiplier = 1;

        for (int index = digits.length - 1; index > 0; index--) {
            multiplier++;
            int number = Integer.parseInt(digits[index]);
            sum += number * (multiplier);
        }
        sum += Integer.parseInt(digits[0]);

        return sum % MODAL == 0;
    }

    public static String checkLegibleAccount(final String account) {
        return (account.contains(ILLEGIBLE)) ? account + " ILL" : account;
    }

    public static String checkValidAccount(final String account) {
        String accountNumber = "";
        if (validateChecksum(account)) {
            accountNumber = account;
        } else {
            accountNumber = account + " ERR";
        }
        return accountNumber;
    }
}
