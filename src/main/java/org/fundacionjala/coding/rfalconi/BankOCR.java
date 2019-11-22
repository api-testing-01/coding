package org.fundacionjala.coding.rfalconi;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BankOCR {

    private static final Logger LOGGER = Logger.getLogger("org.fundacionjala.coding.rfalconi.BankOCR");

    private static List<String> digits = Arrays.asList(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"});
    private static int MODULE = 11;
    public int sum = 0;

    public void userStory1() {

    }

    /**
     * Given an account id calculates the checksum to validate if the account number is valid or not
     *
     * @param accountId
     * @return
     */
    public boolean userStory2(final String accountId) {
        boolean result = true;
        int sum = 0;
        char[] digits = String.valueOf(accountId).toCharArray();
        int position = digits.length;
        if (isNumeric(accountId)) {
            for (int i = 0; i < digits.length; i++) {
                sum = sum + (Integer.parseInt(String.valueOf(digits[i])) * position);
                position--;
            }
            sum = sum % MODULE;
            LOGGER.log(Level.INFO, "Sum result {0}", sum);
            if (sum == 0)
                result = true;
            else
                result = false;
        } else {
            result = false;
        }

        return result;
    }

    public boolean userStory3(final String accountId) {
        String filename = "src\\test\\java\\org\\fundacionjala\\coding\\rfalconi\\bankOCR.txt";
        String accountLine = "";
        boolean result = true;
        if (isNumeric(accountId)) {
            userStory2(accountId);
            if (sum != 0) {
                accountLine = accountId.concat(" ERR");
                result = false;
            } else {
                accountLine = accountId;
                result = true;
            }
        } else {
            String newAccountId = replaceCharacter(accountId);
            accountLine = newAccountId.concat(" ILL");
            result = false;
        }
        try {
            FileWriter fileWriter = new FileWriter(filename, true);
            fileWriter.write(accountLine.concat("\n"));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException err) {
            LOGGER.log(Level.WARNING, "Error E/S: {0}", err);
        }
        LOGGER.log(Level.INFO, "Line added to file:: {0}", accountLine);
        return result;
    }

    public boolean isNumeric(final String accountId) {
        final char[] accountDigits = accountId.toCharArray();
        boolean isNumeric = false;
        for (int i = 0; i < accountDigits.length; i++) {
            if (digits.contains(String.valueOf(accountDigits[i]))) {
                isNumeric = true;
            } else {
                isNumeric = false;
                break;
            }
        }
        return isNumeric;
    }

    public String replaceCharacter(final String accountId) {
        final char[] accountDigits = accountId.toCharArray();
        for (int i = 0; i < accountDigits.length; i++) {
            if (!digits.contains(String.valueOf(accountDigits[i]))) {
                accountDigits[i] = '?';
            }
        }
        return String.valueOf(accountDigits);
    }
}
