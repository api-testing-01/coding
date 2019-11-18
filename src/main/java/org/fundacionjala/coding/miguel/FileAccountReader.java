package org.fundacionjala.coding.miguel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class FileAccountReader {
    private static final String BASE_PATH = System.getProperty("user.dir")
            .concat("/src/main/java/org/fundacionjala/coding/miguel/resource/");
    private static final int ARRAY_SIZE = 3;

     public String[] readerAccountFile(final String fileName) throws IOException {
         String filePath = BASE_PATH.concat(fileName);
         FileReader fileReader = new FileReader(filePath);
         BufferedReader bufferedReader = new BufferedReader(fileReader);
         String[] accountArrayOnFile = new String[ARRAY_SIZE];
         Arrays.fill(accountArrayOnFile, "");

         try {
             String line;
             int index = 0;
             while ((line = bufferedReader.readLine()) != null) {
                 accountArrayOnFile[index] = line;
                 index++;
             }
         } finally {
             fileReader.close();
         }
         return accountArrayOnFile;
     }

     public void writeAccountFile(final String account) throws  IOException {
         String filename = BASE_PATH.concat("write_accounts.txt");
        try {
            FileWriter fileWriter = new FileWriter(filename, true);
            fileWriter.write(account.concat("\n"));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException err) {
            System.out.println("Error E/S: {0}" + err);
        }
    }
}
