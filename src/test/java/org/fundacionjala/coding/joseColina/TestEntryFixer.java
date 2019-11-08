package org.fundacionjala.coding.joseColina;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static org.junit.Assert.assertEquals;

public class TestEntryFixer {
    private static List<String> lines;
    @BeforeClass
    public static void SetUp(){
        String resourcePath = Paths.get(".").toAbsolutePath().normalize().toString() + "\\src\\test\\resources\\joseColina\\";
        String filePath = resourcePath + "entriesToBeFixed.txt";
        lines = new ArrayList<>();
        File file = new File(filePath);
        try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        }
        catch(Exception e){
            System.out.println("Error opening file: " + e.getMessage());
        }
    }
    @Test
    public void testILLinOneDigit(){
        Entry entry = new Entry(lines.subList(0, 4));
        EntryFixer fixer =  new EntryFixer();
        Entry entryFixed = fixer.fixEntry(entry);
        String actual = entryFixed.getAccountNumber();
        String expected = "";
//        assertEquals(actual, expected):
    }
}
