package org.fundacionjala.coding.emely;

public class Validator {

    public static boolean validateAccount(String account) {
        boolean isValid = false;
        int multiplier = 2;
        String[] digits = account.split("");
        int total = Integer.parseInt(digits[digits.length-1]);
        for (int position=digits.length-1; position >=0; position--) {
            total = total + Integer.parseInt(digits[position])*multiplier;
            multiplier++;
        }
        if (total % 11 == 0){
            isValid = true;
        }
        return isValid;
    }

}
