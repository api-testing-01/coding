package org.fundacionjala.coding.joseColina;

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

public class TestAccountValidator {
    private static List<String> lines;
    private static AccountValidator accountValidator;
    @BeforeClass
    public static void setup(){
        accountValidator = new AccountValidator();
        String resourcePath = Paths.get(".").toAbsolutePath().normalize().toString() + "\\src\\test\\resources\\";
        String filePath = resourcePath + "joseColina/entriesToValidate.txt";
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
        assertTrue(accountValidator.isChecksumValid(accountNumber));
    }
    @Test
    public void testChecksumNotValid(){
        String accountNumber = "999215810";
        assertFalse(accountValidator.isChecksumValid(accountNumber));
    }
    @Test
    public void testEntryValidatorWithQuestionMarkInEntry(){
//        Account account = new Account(lines.subList(0, 4));
        String accountNumber = "999??58?0";
        String expected = "999??58?0 ILL";
        String actual = accountValidator.validateAccountNumber(accountNumber);
        assertEquals(expected, actual);
    }
    @Test
    public void testEntryValidatorWitInvalidChecksum(){
//        Account account = new Account(lines.subList(4, 8));
        String accountNumber = "999215810";
        String expected = "999215810 ERR";
        String actual = accountValidator.validateAccountNumber(accountNumber);
        assertEquals(expected, actual);
    }
    @Test
    public void testEntryValidatorWithValidChecksum(){
//        Account account = new Account(lines.subList(8, 12));
        String accountNumber = "999215817";
        String expected = "999215817";
        String actual = accountValidator.validateAccountNumber(accountNumber);
        assertEquals(expected, actual);
    }
}
