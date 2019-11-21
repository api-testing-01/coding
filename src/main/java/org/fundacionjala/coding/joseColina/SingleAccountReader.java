package org.fundacionjala.coding.joseColina;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleAccountReader {
    private static final int NUMBER_OF_DIGITS_BY_ENTRY = 9;
    private static final int WIDTH_OF_DIGITS = 3;
    private String accountNumber;
    private static final Map<String, Integer> MAP_OF_DIGITS = new HashMap<String, Integer>(){{
                        put(" _ " +
                            "| |" +
                            "|_|" +
                            "   ", 0);
                        put("   " +
                            "  |" +
                            "  |" +
                            "   " , 1);
                        put(" _ " +
                            " _|" +
                            "|_ " +
                            "   " , 2);
                        put(" _ " +
                            " _|" +
                            " _|" +
                            "   " , 3);
                        put("   " +
                            "|_|" +
                            "  |" +
                            "   " , 4);
                        put(" _ " +
                            "|_ " +
                            " _|" +
                            "   " , 5);
                        put(" _ " +
                            "|_ " +
                            "|_|" +
                            "   " , 6);
                        put(" _ " +
                            "  |" +
                            "  |" +
                            "   " , 7);
                        put(" _ " +
                            "|_|" +
                            "|_|" +
                            "   " , 8);
                        put(" _ " +
                            "|_|" +
                            " _|" +
                            "   ", 9);}};

    public SingleAccountReader(){}

    public String readAccountNumber(final List<String> entryLines){
        accountNumber =  "";
        int startOfDigit = 0;
        for(int i = 0; i < NUMBER_OF_DIGITS_BY_ENTRY; i ++){
            String stringOfDigit = "";
            for(String line : entryLines){
                stringOfDigit += line.substring(startOfDigit, startOfDigit + WIDTH_OF_DIGITS);
            }
            if(MAP_OF_DIGITS.get(stringOfDigit)!= null){
                accountNumber += MAP_OF_DIGITS.get(stringOfDigit);
            }
            else {
                accountNumber += "?";
            }
            startOfDigit += WIDTH_OF_DIGITS;

        }
        return accountNumber;
    }
}
