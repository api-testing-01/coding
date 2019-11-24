package org.fundacionjala.coding.joseCardozo.bankOCR;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadAccountNumber {

    private static final String[] NUMBERS_WRAPPER = new String[]
            {" _ | ||_|", "     |  |", " _  _||_ ", " _  _| _|",
             "   |_|  |", " _ |_  _|", " _ |_ |_|", " _   |  |", " _ |_||_|", " _ |_| _|"};
    private static final String BASE_PATH = System.getProperty("user.dir")
            .concat("/src/main/java/org/fundacionjala/coding/joseCardozo/bankOCR/resource/");
    private static final int ARRAY_SIZE = 9;
    private static final int MOD = 11;
    private static final Logger LOGGER = Logger.getLogger(ReadAccountNumber.class.getName());

    public String getAccountNumber(final String fileName) throws IOException {
        String filePath = BASE_PATH.concat(fileName);
        String[] accountArrayOnFile = new String[ARRAY_SIZE];
        Arrays.fill(accountArrayOnFile, "");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
           String line;
           while ((line = bufferedReader.readLine()) != null) {
               String[] subStringArray = line.split("(?<=\\G...)");

               for (int i = 0; i < accountArrayOnFile.length; i++) {
                   accountArrayOnFile[i] += String.valueOf(subStringArray[i]);
               }
           }
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "An error occurred trying to read the file, the error is: " + e.getMessage());
        }

        return convertToAccountNumber(accountArrayOnFile);
    }

    private String convertToAccountNumber(final String[] accountArrayOnFile) {
        String result = "";
        for (String subString : accountArrayOnFile) {
            for (int i = 0; i < NUMBERS_WRAPPER.length; i++) {
                if (NUMBERS_WRAPPER[i].equals(subString)) {
                    result += String.format("%s", i);
                    break;
                }
            }
        }
        return result;
    }

    public boolean getCheckSumAccountNumber(final String fileName) throws IOException {
        char[] charArray = getAccountNumber(fileName).toCharArray();
        int[] accountNumbers = new int[ARRAY_SIZE];
        Arrays.setAll(accountNumbers, i -> (int) charArray[i]);
        int i = ARRAY_SIZE;
        int sum = 0;
        for (int num : accountNumbers) {
            if (i >= 2) {
                sum *= (num + i);
                i--;
            } else {
                sum *= num;
            }

        }

        return sum % MOD == 0;
    }
}
