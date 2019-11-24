package org.fundacionjala.coding.benjamin;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Benjamin Huanca on 10/16/2019.
 * @version 1.0
 */
public class DigitMatrixTest {
    private static final String FILE_NAME = "/accounts.txt";

    @Test
    public void getCharactersNumberTest() {
        char[][] characterMatrix = {{' ', '_', ' '}, {' ', '_', '|'}, {' ', '_', '|'}, {' ', ' ', ' '}};
        DigitMatrix digitMatrix = new DigitMatrix();
        char expected = '3';
        assertEquals(expected, digitMatrix.getCharacter(characterMatrix));
    }

    @Test
    public void getCharactersLTest() {
        char[][] characterMatrix = {{' ', '_', ' '}, {' ', ' ', '|'}, {' ', '_', '|'}, {' ', ' ', ' '}};
        DigitMatrix digitMatrix = new DigitMatrix();
        char expected = '?';
        assertEquals(expected, digitMatrix.getCharacter(characterMatrix));
    }

    @Test
    public void decode0To8Test() {
        char[][] lcdMatrix = {
                {' ', '_', ' ', ' ', ' ', ' ', ' ', '_', ' ', ' ', '_', ' ', ' ', ' ', ' ', ' ', '_', ' ',
                        ' ', '_', ' ', ' ', '_', ' ', ' ', '_', ' '},
                {'|', ' ', '|', ' ', ' ', '|', ' ', '_', '|', ' ', '_', '|', '|', '_', '|', '|', '_', ' ',
                        '|', '_', ' ', ' ', ' ', '|', '|', '_', '|'},
                {'|', '_', '|', ' ', ' ', '|', '|', '_', ' ', ' ', '_', '|', ' ', ' ', '|', ' ', '_', '|',
                        '|', '_', '|', ' ', ' ', '|', '|', '_', '|'},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
                        ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}};
        String expected = "012345678";
        DigitMatrix digitMatrix = new DigitMatrix();
        assertEquals(expected, digitMatrix.decoder(lcdMatrix));
    }

    @Test
    public void decode912345678Test() {
        char[][] lcdMatrix = {
                {' ', '_', ' ', ' ', ' ', ' ', ' ', '_', ' ', ' ', '_', ' ', ' ', ' ', ' ', ' ', '_', ' ',
                        ' ', '_', ' ', ' ', '_', ' ', ' ', '_', ' '},
                {'|', '_', '|', ' ', ' ', '|', ' ', '_', '|', ' ', '_', '|', '|', '_', '|', '|', '_', ' ',
                        '|', '_', ' ', ' ', ' ', '|', '|', '_', '|'},
                {' ', '_', '|', ' ', ' ', '|', '|', '_', ' ', ' ', '_', '|', ' ', ' ', '|', ' ', '_', '|',
                        '|', '_', '|', ' ', ' ', '|', '|', '_', '|'},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
                        ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
        };
        String expected = "912345678";
        DigitMatrix digitMatrix = new DigitMatrix();
        assertEquals(expected, digitMatrix.decoder(lcdMatrix));
    }

    @Test
    public void checksumInvalidTest() {
        char[][] lcdMatrix = {
                {' ', '_', ' ', ' ', ' ', ' ', ' ', '_', ' ', ' ', '_', ' ', ' ', ' ', ' ', ' ', '_', ' ',
                        ' ', '_', ' ', ' ', '_', ' ', ' ', '_', ' '},
                {'|', '_', '|', ' ', ' ', '|', ' ', '_', '|', ' ', '_', '|', '|', '_', '|', '|', '_', ' ',
                        '|', '_', ' ', ' ', ' ', '|', '|', '_', '|'},
                {' ', '_', '|', ' ', ' ', '|', '|', '_', ' ', ' ', '_', '|', ' ', ' ', '|', ' ', '_', '|',
                        '|', '_', '|', ' ', ' ', '|', '|', '_', '|'},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
                        ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
        };
        //Invalid account number: "912345678"
        DigitMatrix digitMatrix = new DigitMatrix();
        digitMatrix.decoder(lcdMatrix);
        assertFalse(digitMatrix.validateChecksum());
    }

    @Test
    public void checksumValidTest() {
        char[][] lcdMatrix = {
                {' ', '_', ' ', ' ', ' ', ' ', ' ', '_', ' ', ' ', '_', ' ', ' ', ' ', ' ', ' ', '_', ' ',
                        ' ', '_', ' ', ' ', '_', ' ', ' ', '_', ' '},
                {'|', '_', '|', ' ', ' ', '|', ' ', '_', '|', ' ', '_', '|', '|', '_', '|', '|', '_', ' ',
                        '|', '_', ' ', ' ', ' ', '|', '|', '_', ' '},
                {' ', '_', '|', ' ', ' ', '|', '|', '_', ' ', ' ', '_', '|', ' ', ' ', '|', ' ', '_', '|',
                        '|', '_', '|', ' ', ' ', '|', ' ', '_', '|'},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
                        ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
        };
        //Valid account number: "912345675"
        DigitMatrix digitMatrix = new DigitMatrix();
        digitMatrix.decoder(lcdMatrix);
        assertTrue(digitMatrix.validateChecksum());
    }

    @Test
    public void addingValidAccountToTheFile() {
        ArrayList<String> accountsList;
        char[][] lcdMatrix = {
                {' ', '_', ' ', ' ', ' ', ' ', ' ', '_', ' ', ' ', '_', ' ', ' ', ' ', ' ', ' ', '_', ' ',
                        ' ', '_', ' ', ' ', '_', ' ', ' ', '_', ' '},
                {'|', '_', '|', ' ', ' ', '|', ' ', '_', '|', ' ', '_', '|', '|', '_', '|', '|', '_', ' ',
                        '|', '_', ' ', ' ', ' ', '|', '|', '_', ' '},
                {' ', '_', '|', ' ', ' ', '|', '|', '_', ' ', ' ', '_', '|', ' ', ' ', '|', ' ', '_', '|',
                        '|', '_', '|', ' ', ' ', '|', ' ', '_', '|'},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
                        ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
        };
        //Valid account number: "912345675"
        DigitMatrix digitMatrix = new DigitMatrix();
        digitMatrix.decoder(lcdMatrix);
        digitMatrix.addAccountToAFile(FILE_NAME);
        accountsList = digitMatrix.readAccountsFile(FILE_NAME);
        assertEquals("912345675", accountsList.get(0));
        digitMatrix.deleteFile(FILE_NAME);
    }

    @Test
    public void addingInvalidAccountToTheFile() {
        ArrayList<String> accountsList;
        char[][] lcdMatrix = {
                {' ', '_', ' ', ' ', ' ', ' ', ' ', '_', ' ', ' ', '_', ' ', ' ', ' ', ' ', ' ', '_', ' ',
                        ' ', '_', ' ', ' ', '_', ' ', ' ', '_', ' '},
                {'|', '_', '|', ' ', ' ', '|', ' ', '_', '|', ' ', '_', '|', '|', '_', '|', '|', '_', ' ',
                        '|', '_', ' ', ' ', ' ', '|', '|', '_', '|'},
                {' ', '_', '|', ' ', ' ', '|', '|', '_', ' ', ' ', '_', '|', ' ', ' ', '|', ' ', '_', '|',
                        '|', '_', '|', ' ', ' ', '|', '|', '_', '|'},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
                        ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
        };
        //Invalid account number: "912345678"
        DigitMatrix digitMatrix = new DigitMatrix();
        digitMatrix.decoder(lcdMatrix);
        digitMatrix.addAccountToAFile(FILE_NAME);
        accountsList = digitMatrix.readAccountsFile(FILE_NAME);
        assertEquals("912345678 ERR", accountsList.get(0));
        digitMatrix.deleteFile(FILE_NAME);
    }

    @Test
    public void addingUnrecognizedAccountToTheFile() {
        ArrayList<String> accountsList;
        char[][] lcdMatrix = {
                {' ', '_', ' ', ' ', ' ', ' ', ' ', '_', ' ', ' ', '_', ' ', ' ', ' ', ' ', ' ', '_', ' ',
                        ' ', '_', ' ', ' ', '_', ' ', ' ', ' ', ' '},
                {'|', '_', '|', ' ', ' ', '|', ' ', '_', '|', ' ', '_', '|', '|', '_', '|', '|', '_', ' ',
                        '|', '_', ' ', ' ', ' ', '|', '|', '_', '|'},
                {' ', '_', '|', ' ', ' ', '|', '|', '_', ' ', ' ', '_', '|', ' ', ' ', '|', ' ', '_', '|',
                        '|', '_', '|', ' ', ' ', '|', '|', '_', '|'},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
                        ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
        };
        //Unrecognized account number: "91234567?"
        DigitMatrix digitMatrix = new DigitMatrix();
        digitMatrix.decoder(lcdMatrix);
        digitMatrix.addAccountToAFile(FILE_NAME);
        accountsList = digitMatrix.readAccountsFile(FILE_NAME);
        assertEquals("91234567? ILL", accountsList.get(0));
        digitMatrix.deleteFile(FILE_NAME);
    }

    @Test(expected = RuntimeException.class)
    public void testIOException() {
        String filename = "";
        DigitMatrix digitMatrix = new DigitMatrix();
        digitMatrix.addAccountToAFile(filename);
    }

    @Test(expected = RuntimeException.class)
    public void testFileNotFoundException() {
        String filename = "\\.text";
        DigitMatrix digitMatrix = new DigitMatrix();
        digitMatrix.readAccountsFile(filename);
    }

    @Test(expected = RuntimeException.class)
    public void testDeleteFileFalse() {
        String filename = "";
        DigitMatrix digitMatrix = new DigitMatrix();
        digitMatrix.deleteFile(filename);
    }
}
