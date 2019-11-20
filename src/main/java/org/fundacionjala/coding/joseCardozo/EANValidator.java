package org.fundacionjala.coding.joseCardozo;

public final class EANValidator {
    private static final int EAN_CODE_LENGTH = 13;

    private EANValidator() {
    }

    private static int[] toIntArray(final char[] charArray) {
        final int decimalBase = 10;
        int[] numbers = new int[EAN_CODE_LENGTH];
        for (int i = 0; i < charArray.length; i++) {
            numbers[i] = Character.digit(charArray[i], decimalBase);
        }
        return numbers;
    }

    public static boolean validate(final String eanCode) {
        final int three = 3;
        int[] numbers = toIntArray(eanCode.toCharArray());
        int sum = 0;

        for (int i = 0; i < numbers.length - 1; i++) {
            sum += numbers[i] % 2 == 0 ? numbers[i] : numbers[i] * three;
        }
        return checkSum(sum, numbers[EAN_CODE_LENGTH - 1]);
    }

    private static boolean checkSum(int sum, int lastDigit) {
        final int modToCheckSum = 10;
        int mod10 = sum % modToCheckSum;
        int checksum = (mod10 == 0) ? 0 : modToCheckSum - mod10;
        return checksum == lastDigit;
    }
}
