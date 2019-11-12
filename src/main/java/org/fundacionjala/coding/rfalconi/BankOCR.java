package org.fundacionjala.coding.rfalconi;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BankOCR {

    private static final Logger LOGGER = Logger.getLogger("org.fundacionjala.coding.rfalconi.BankOCR");

    private static int MODULE = 11;

    public void userStory1() {

    }

    /**
     * Given an account id calculates the checksum to validate if the account number is valid or not
     * @param accountId
     * @return
     */
    public int userStory2(final String accountId) {
        int sum = 0;
        char[] digits = String.valueOf(accountId).toCharArray();
        int position = digits.length;
        for (int i = 0; i < digits.length; i++) {
            sum = sum + (Integer.parseInt(String.valueOf(digits[i])) * position);
            position--;
        }
        sum = sum % MODULE;
        LOGGER.log( Level.INFO, "Sum result {0}", sum);
        return sum;
    }

    public boolean validateUserStory2(final String accountId){
        if (isNumeric(accountId)) {
            int sum = userStory2(accountId);
            if (sum == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public String userStory3(final String accountId) {
        String filename = "src\\test\\java\\org\\fundacionjala\\coding\\rfalconi\\bankOCR.txt";
        String accountLine ="";
        try {
            FileWriter fileWriter = new FileWriter(filename, true);
            if (accountId.contains("?")) {
                accountLine = accountId.concat(" ILL");
                fileWriter.write(accountLine.concat("\n"));
            } else {
                if(userStory2(accountId) != 0) {
                    accountLine = accountId.concat(" ERR");
                    fileWriter.write(accountLine.concat("\n"));
                } else {
                    accountLine = accountId;
                    fileWriter.write(accountLine.concat("\n"));
                }
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException err) {
            System.out.println("Error E/S: " + err);
        }
        LOGGER.log( Level.INFO, "Line added to file:: {0}", accountLine);
        return accountLine;
    }

    public boolean isNumeric(final String accountId){
        final List <String> digits = Arrays.asList(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"});
        final char[] accountDigits = accountId.toCharArray();

        boolean isNumeric = false;
        for (int i = 0; i < accountDigits.length; i++) {
            if(digits.contains(String.valueOf(accountDigits[i]))){
                isNumeric = true;
            } else{
                isNumeric = false;
                break;
            }
        }
        return isNumeric;
    }

    public void fileReader(final String filename) {
        try {
            FileReader fileReader = new FileReader(filename);
            int valor = fileReader.read();
            while (valor != -1) {
                System.out.print((char) valor);
                valor = fileReader.read();
            }
            fileReader.close();
        } catch (IOException err) {
            System.out.println("Error E/S: " + err);
        }

    }
}
