package org.fundacionjala.coding.benjamin;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

/**
 * @author Benjamin Huanca on 10/16/2019.
 * @version 1.0
 */
public class DigitMatrixTest {

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
        //Valid account number: "912345675";
        DigitMatrix digitMatrix = new DigitMatrix();
        digitMatrix.decoder(lcdMatrix);
        assertTrue(digitMatrix.validateChecksum());
    }
}
