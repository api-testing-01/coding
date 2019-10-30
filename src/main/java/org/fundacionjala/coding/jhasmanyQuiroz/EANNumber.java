package org.fundacionjala.coding.jhasmanyQuiroz;

public class EANNumber {
    private static final int CHECKSUM_MULTIPLIER = 10;
    public static final int ODD_DIGITS_MULTIPLIER = 3;

    public static boolean isEANNumber(final String eanNumber) {
        StringBuilder number = new StringBuilder(eanNumber.substring(0, eanNumber.length() - 1));
        int checksum = 0;
        int digit;

        for (int index = 0; index < eanNumber.length() - 1; index++) {
            digit = Character.getNumericValue(eanNumber.charAt(index));

            if (index % 2 == 0) {//even position (Starting in 0)
                checksum += digit;
            } else {//odd position
                checksum += digit * ODD_DIGITS_MULTIPLIER;
            }
        }


        number = (checksum % CHECKSUM_MULTIPLIER == 0)? number.append("0") :
                number.append(CHECKSUM_MULTIPLIER - (checksum % CHECKSUM_MULTIPLIER));

        return number.toString().equals(eanNumber);
    }
}
