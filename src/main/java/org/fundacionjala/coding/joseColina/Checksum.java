package org.fundacionjala.coding.joseColina;

public class Checksum {
    private static final int RADIX_ELEVEN = 11;
    private int checksum;

    public Checksum(){
        checksum = 0;
    }

    public boolean isAccountValid(String account){
        boolean isValid = false;
        checksum = 0;
        int length = account.length();
        for (int i = 0; i < length; i++) {
            checksum += Character.getNumericValue(account.charAt(i)) * (length - i);
        }

        if(checksum % RADIX_ELEVEN == 0){
            isValid = true;
        }

        return isValid;
    }
}
