package org.fundacionjala.coding.joseColina;

public class EANValidator {

    public static boolean validate(final String EAVNnumber){
        boolean result = false;
        int checksum = 0;
        int[] digits = getDigits(EAVNnumber);
        int lastDigit = digits[digits.length - 1];
        int sum = calculateSum(digits);
        if (sum%10 != 0){
            checksum = 10 - sum%10;
        }
        if (checksum == lastDigit){
            result = true;
        }
        return result;
    }

    private static int calculateSum(int[] digits) {
        int result = 0;
        int[] multiplier = {1, 3};
        for(int i = 0; i < digits.length - 1; i++){
            result += digits[i] * multiplier[i % 2];
        }
        return result;
    }

    private static int[] getDigits(final String EAVNnumber) {
        int[] result = new int[EAVNnumber.length()];
        for(int i = 0; i < result.length; i++){
            result[i] = Character.getNumericValue(EAVNnumber.charAt(i));
        }

        return result;
    }
}
