package org.fundacionjala.coding.joseColina;

import org.junit.Test;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TestEntriesFile {
    @Test
    public void testReadEntries(){
        String resourcePath = Paths.get(".").toAbsolutePath().normalize().toString() + "\\src\\test\\resources\\joseColina\\";
        String filePath = resourcePath + "entries.txt";
        EntriesFile entriesFile = new EntriesFile(filePath);
        String s1 = "000000000";
        String s2 = "111111111";
        String[] expectedEntries = {s1, s2};
        entriesFile.readEntries();
        List<Entry> entries = entriesFile.getEntries();
        String[] actualEntries = new String[entries.size()];
        for(int i =0; i < entries.size(); i++){
            actualEntries[i] = entries.get(i).getAccountNumber();
        }
        assertTrue(Arrays.deepEquals(expectedEntries, actualEntries));
    }
    @Test
    public void testWriteToFile(){
        String resourcePath = Paths.get(".").toAbsolutePath().normalize().toString() + "\\src\\test\\resources\\joseColina\\";
        String filePath = resourcePath + "entries.txt";
        String filePathToWrite = resourcePath + "results.txt";
        EntriesFile entriesFile = new EntriesFile(filePath);
        entriesFile.readEntries();
        entriesFile.validateEntries();
        entriesFile.writeToFile(filePathToWrite);

    }
}
