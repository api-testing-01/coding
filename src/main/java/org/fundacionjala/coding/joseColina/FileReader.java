package org.fundacionjala.coding.joseColina;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    private static final int ENTRY_SIZE = 4;

    public List<String[]> readEntries(final String filePath){
        List<String[]> entries = new ArrayList<>();
        File file = new File(filePath);
        try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] entry = new String[ENTRY_SIZE];
                for(int i = 0; i < ENTRY_SIZE; i++ ){
                    entry[i] = scanner.nextLine();
                }
                entries.add(entry);
            }

        }
        catch(Exception e){

        }

       return entries;
    }
}
