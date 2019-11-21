package org.fundacionjala.coding.joseColina;

public class AccountValidator {
    private static final int RADIX_ELEVEN = 11;
    private int checksum;

    public AccountValidator(){
    }

    public String validateAccountNumber(final String account){
        String accountValidated = account;
        if(accountValidated.contains("?")){
            accountValidated += " ILL";
        }
        else if(!isChecksumValid(accountValidated)){
            accountValidated += " ERR";
        }
        return accountValidated;

    }
    public boolean isChecksumValid(final String account){
        boolean isValid = false;
        checksum = 0;
        int length = account.length();
        for (int i = 0; i < length; i++) {
            checksum += Character.getNumericValue(account.charAt(i)) * (length - i);
        }
        if(checksum % RADIX_ELEVEN == 0 && checksum != 0){
            isValid = true;
        }

        return isValid;
    }
}
