package org.fundacionjala.coding.joseCardozo.bankOCR;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ReadAccountNumber {

    private static final String[] NUMBERS_WRAPPER = new String[]
            {" _ | ||_|", "     |  |", " _  _||_ ", " _  _| _|",
             "   |_|  |", " _ |_  _|", " _ |_ |_|", " _   |  |", " _ |_||_|", " _ |_| _|"};
    private static final String BASE_PATH = System.getProperty("user.dir")
            .concat("\\src\\main\\java\\org\\fundacionjala\\coding\\joseCardozo\\bankOCR\\resource\\");
    private static final int ARRAY_SIZE = 9;

    public String getAccountNumber(final String fileName) throws IOException {
        String filePath = BASE_PATH.concat(fileName);
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String[] accountArrayOnFile = new String[ARRAY_SIZE];
        Arrays.fill(accountArrayOnFile, "");

        try {
           String line;
           while ((line = bufferedReader.readLine()) != null) {
               String[] subStringArray = line.split("(?<=\\G...)");

               for (int i = 0; i < accountArrayOnFile.length; i++) {
                   accountArrayOnFile[i] += String.valueOf(subStringArray[i]);
               }
           }
        } finally {
            fileReader.close();
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
}
