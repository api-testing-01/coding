package org.fundacionjala.coding.benjamin;

/**
 * @author Benjamin Huanca on 10/29/2019.
 * @version 1.0
 */
public final class EANValidator {
    private EANValidator() {
    }
    public static boolean validate(final String code) {
        char[] codeToCharArray = code.toCharArray();
        final int evenMultiplier = 3;
        int sum = 0;
        for (int i = 0; i <= codeToCharArray.length - 2; i++) {
            sum += ((i + 1) % 2 == 0 ? Character.getNumericValue(codeToCharArray[i]) * evenMultiplier
                    : Character.getNumericValue(codeToCharArray[i]));
        }
        return (getChecksum(sum) == Character.getNumericValue(codeToCharArray[codeToCharArray.length - 1]));
    }

    private static int getChecksum(final int sum) {
        final int checksumGenerator = 10;
        return (sum % checksumGenerator == 0 ? 0 : checksumGenerator - (sum % checksumGenerator));
    }

}
