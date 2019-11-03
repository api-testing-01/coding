package org.fundacionjala.coding.joseColina;

import java.util.HashMap;
import java.util.Map;

public class EntryReader {
    private static final int NUMBER_OF_ENTRY_DIGITS = 9;
    private static final int OFFSET_OF_DIGITS = 3;
    private Map<String, Integer> numbers;
    private String[] digit;
    private String accountNumber;
    private String key0 = " _ " +
                          "| |" +
                          "|_|" +
                          "   " ;
    private String key1 =   "   " +
                            "  |" +
                            "  |" +
                            "   " ;
    public EntryReader(){
        numbers = new HashMap<>();
        numbers.put(key0, 0);
        numbers.put(key1, 1);
        accountNumber =  "";
        digit = new String[NUMBER_OF_ENTRY_DIGITS];
        for(int i =0; i < NUMBER_OF_ENTRY_DIGITS; i ++){
            digit[i] = "";
        }
    }
    public String readAccountNumber(final String[] entry){
        accountNumber =  "";
        int startOfDigit = 0;
        for(int i =0; i < NUMBER_OF_ENTRY_DIGITS; i ++){
            for(String line : entry){
                digit[i] += line.substring(startOfDigit, startOfDigit + OFFSET_OF_DIGITS);
            }
            accountNumber += numbers.get(digit[i]);
            startOfDigit += OFFSET_OF_DIGITS;
        }
        return accountNumber;
    }
}
