package org.fundacionjala.coding.rfalconi;

import java.util.logging.Logger;

public class ean {

    private static final Logger LOGGER = Logger.getLogger("org.fundacionjala.coding.rfalconi.ean");

    public int getChecksum (String barcode){
        char [] digitChar = barcode.toCharArray();
        int sum=0;
        for (int i=0; i < digitChar.lenght; i+2){
            sum = sum + (Integer.parseInt(String.valueOf(digitChar[i]))*1);
        }
        
        for (int i=1; i < digitChar.lenght; i+2){
            sum = sum + (Integer.parseInt(String.valueOf(digitChar[i]))*3);
        }
        return sum;
    }
    
    public boolean isDividableByTen(int sum){
        if ((sum % 10) = 0)
            return true;
        else
            return false;
    }
}
