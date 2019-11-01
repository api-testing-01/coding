package org.fundacionjala.coding.joseColina;

import java.util.HashMap;
import java.util.Map;

public class AccountReader {
    private static final int NUMBER_OF_ENTRY_DIGITS = 9;
    private static final int OFFSET_OF_DIGITS = 3;
    private Map<String, Integer> numbers;
    private String key0 = " _ " +
                          "| |" +
                          "|_|" +
                          "   " ;
    private String key1 =   "   " +
                            "  |" +
                            "  |" +
                            "   " ;
    public AccountReader(){
        numbers = new HashMap<>();
        numbers.put(key0, 0);
        numbers.put(key1, 1);
    }
    public void readEntry(final String[] entry){
        int startOfDigit = 0;
        String[] digits = new String[NUMBER_OF_ENTRY_DIGITS];
        for(int i =0; i < NUMBER_OF_ENTRY_DIGITS; i ++){
            digits[i] = entry[0].substring(startOfDigit, startOfDigit + OFFSET_OF_DIGITS);
            digits[i] += entry[1].substring(startOfDigit, startOfDigit + OFFSET_OF_DIGITS);
            digits[i] += entry[2].substring(startOfDigit, startOfDigit + OFFSET_OF_DIGITS);
            digits[i] += entry[3].substring(startOfDigit, startOfDigit + OFFSET_OF_DIGITS);
            startOfDigit += OFFSET_OF_DIGITS;
        }

        for(int i =0; i < NUMBER_OF_ENTRY_DIGITS; i ++){
            System.out.println("digit found: " + numbers.get(digits[i]));
        }
    }
    public static void main(String[] args){
        String line1 = " _  _     _  _  _     _  _ ";
        String line2 = "| || |  || || || |  || || |";
        String line3 = "|_||_|  ||_||_||_|  ||_||_|";
        String line4 = "                           ";
        String[] lines = {line1,line2,line3,line4};
        AccountReader reader = new AccountReader();
        reader.readEntry(lines);

    }
}
