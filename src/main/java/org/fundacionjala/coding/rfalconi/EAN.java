package org.fundacionjala.coding.rfalconi;

import java.util.logging.Logger;
import java.util.logging.Level;

public class EAN {

    private static final Logger LOGGER = Logger.getLogger("org.fundacionjala.coding.rfalconi.EAN");

    public String getChecksum (String barcode){
        int checksum=0;
        int [] digits = this.getDigits(barcode);
        int sum = this.getSum(digits);
        if (!isDividableByTen(sum)){
            checksum = 10 - (sum % 10);
        }
        LOGGER.log(Level.INFO, "Checksum is {0}", checksum);
        return barcode.concat(String.valueOf(checksum));
    }

    public int getSum(int [] barcode){
        int sum=0;
        int index=0;
        while (barcode.length > index){
            sum = sum + (barcode[index]*1);
            index = index +2;
        }
        index =1;
        while (barcode.length > index){
            sum = sum + (barcode[index]*3);
            index = index +2;
        }
        return sum;
    }

    public int[] getDigits(String barcode){
        char [] digitChar = barcode.toCharArray();
        int [] digits = new int [barcode.length()];
        for (int i=0; i < digitChar.length; i++){
            digits[i]=Integer.parseInt(String.valueOf(digitChar[i]));
        }
        return  digits;
    }
    
    public boolean isDividableByTen(int sum){
        if ((sum % 10) == 0)
            return true;
        else
            return false;
    }
}
