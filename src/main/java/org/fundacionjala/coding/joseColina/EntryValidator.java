package org.fundacionjala.coding.joseColina;

public class EntryValidator {
    private static final int RADIX_ELEVEN = 11;
    private int checksum;

    public EntryValidator(){
    }

    public Entry validateEntry(final Entry entry){
        Entry entryValidated = entry;
        String accountValidated = entry.getAccountNumber();
        if(entry.getAccountNumber().contains("?")){
            accountValidated += " ILL";
            entryValidated.setAccountNumber(accountValidated);
        }
        else if(!isChecksumValid(entry.getAccountNumber())){
            accountValidated += " ERR";
            entryValidated.setAccountNumber(accountValidated);
        }
        return entry;

    }
    public boolean isChecksumValid(final String account){
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
