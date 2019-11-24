package org.fundacionjala.coding.magali;

public class AccountNumberValidation {
    private final String accountNumber;
    private static final int MOD_ELEVEN = 11;
    private static final int NINE = 9;

    public AccountNumberValidation(final String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int checksumOf() {

        int checksum = 0;
        for (int i = 0; i < NINE; i++) {
            int digit = Integer.parseInt(accountNumber.substring(i, i + 1));
            checksum = checksum + digit * (NINE - i);
        }

        return checksum % MOD_ELEVEN;
    }

    public boolean isValid() {
        if (isIllegal()) {
            return false;
        }
        return checksumOf() == 0;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AccountNumberValidation that = (AccountNumberValidation) o;

        return accountNumber.equals(that.accountNumber);
    }

    @Override
    public int hashCode() {
        return accountNumber.hashCode();
    }

    public boolean isIllegal() {
        return accountNumber.contains("?");
    }

    @Override
    public String toString() {
        String suffix = "";

        if (!isValid()) {
            suffix = " ERR";
        }

        if (isIllegal()) {
            suffix = " ILL";
        }

        return accountNumber + suffix;
    }
}
