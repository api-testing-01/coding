package org.fundacionjala.coding.ruben;

public class EANValidator {

    public static boolean validate(final String eanCode) {
        String[] result = eanCode.split("");
        int[] eanNumbers = new int[eanCode.length()];
        int sum =0;
        for (int count = 0; count < result.length; count++) {
            eanNumbers[count] = Integer.parseInt(result[count]);
        }
        for (int count = 0; count < eanNumbers.length-1; count++) {
            if(eanNumbers[count]%2 == 0) {
                sum = sum + eanNumbers[count];
            } else {
                sum = sum + eanNumbers[count]*3;
            }
        }
        int checkSum = 10 - (sum % 10);
        System.out.println(checkSum);
        if(checkSum == eanNumbers[eanNumbers.length-1]) {
            return true;
        } else {
            return false;
        }
    }
}
