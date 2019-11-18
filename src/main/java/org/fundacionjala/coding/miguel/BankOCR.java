package org.fundacionjala.coding.miguel;

import java.util.Arrays;

public class BankOCR {
    public static final String[] NUMBER_MAP = new String[]
            {" _ | ||_|", "     |  |", " _  _||_ ", " _  _| _|",
            "   |_|  |", " _ |_  _|", " _ |_ |_|", " _   |  |", " _ |_||_|", " _ |_| _|"};
    private static final int NUMBERS_SIZE = 9;
    private static final int LINES_SIZE = 3;
    private static final int DIVISIBLE = 11;
    private FileAccountReader accountWriter = new FileAccountReader();

    public String translateNumberAccount(final String[] numberAccount) {
        String[] numbers = new String[NUMBERS_SIZE];
        Arrays.fill(numbers, "");
        String result = "";

        for (int i = 0; i < LINES_SIZE; i++) {
            String[] subStringArray = numberAccount[i].split("(?<=\\G...)");
            for (int j = 0; j < numbers.length; j++) {
                numbers[j] += String.valueOf(subStringArray[j]);
            }
        }

        for (int i = 0; i < NUMBERS_SIZE; i++) {
            result += convertStringToNumber(numbers[i]);
        }
        return result;
    }

    public String convertStringToNumber(final String number) {
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < (NUMBERS_SIZE + 1); j++) {
            if (number.equals(NUMBER_MAP[j])) {
                result.append(j);
                return result.toString();
            }
        }
        result.append("?");
        return result.toString();
    }

    public boolean verifyAuthenticity(final String numberAccount) {
        String reverseSubString = new StringBuilder(numberAccount).reverse().toString();
        char[] subString = reverseSubString.toCharArray();
        int result = 0;
        int index = 1;
        for (int i = 0; i < subString.length; i++) {
            int digit = Character.getNumericValue(subString[i]);
            result = result + index * digit;
            index++;
        }
        return (result % DIVISIBLE == 0);
    }

    public String verifyAndPrintInFile(final String[] numberAccount) {
        String isValid = "";
        String isAccountNumber = translateNumberAccount(numberAccount);
        if (!isAccountNumber.contains("?")) {
            isValid =  verifyAuthenticity(isAccountNumber) ? isAccountNumber : isAccountNumber + " ERR";
        } else {
            isValid = isAccountNumber + " ILL";
        }
        accountWriter.writeAccountFile(isValid);
        return isValid;
    }
}
