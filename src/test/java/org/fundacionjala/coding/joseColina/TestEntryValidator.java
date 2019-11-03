package org.fundacionjala.coding.joseColina;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestEntryValidator {
    private static List<String> lines;
    private static EntryValidator entryValidator;
    @BeforeClass
    public static void setup(){
        entryValidator = new EntryValidator();
        String resourcePath = Paths.get(".").toAbsolutePath().normalize().toString() + "\\src\\test\\resources\\";
        String filePath = resourcePath + "entriesToValidate.txt";
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
    public void testChecksumValid(){
        String accountNumber = "999215817";
        assertTrue(entryValidator.isChecksumValid(accountNumber));
    }
    @Test
    public void testChecksumNotValid(){
        String accountNumber = "999215810";
        assertFalse(entryValidator.isChecksumValid(accountNumber));
    }
    @Test
    public void testEntryValidatorWithQuestionMarkInEntry(){
        Entry entry = new Entry(lines.subList(0, 4));
        String expected = "999??58?0 ILL";
        String actual = entryValidator.validateEntry(entry).getAccountNumber();
        assertEquals(expected, actual);
    }
    @Test
    public void testEntryValidatorWitInvalidChecksum(){
        Entry entry = new Entry(lines.subList(4, 8));
        String expected = "999215810 ERR";
        String actual = entryValidator.validateEntry(entry).getAccountNumber();
        assertEquals(expected, actual);
    }
    @Test
    public void testEntryValidatorWithValidChecksum(){
        Entry entry = new Entry(lines.subList(8, 12));
        String expected = "999215817";
        String actual = entryValidator.validateEntry(entry).getAccountNumber();
        assertEquals(expected, actual);
    }
}
