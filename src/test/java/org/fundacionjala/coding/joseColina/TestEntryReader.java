package org.fundacionjala.coding.joseColina;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestEntryReader {
    @Test
    public void testEntryReaderWith000000000(){
        String line1 = " _  _  _  _  _  _  _  _  _ ";
        String line2 = "| || || || || || || || || |";
        String line3 = "|_||_||_||_||_||_||_||_||_|";
        String line4 = "                           ";
        String[] lines = {line1,line2,line3,line4};
        EntryReader reader = new EntryReader();
        String expected = "000000000";
        String actual = reader.readAccountNumber(lines);
        assertEquals(expected, actual);
    }
    @Test
    public void testEntryReaderWith111111111(){
        String line1 = "                           ";
        String line2 = "  |  |  |  |  |  |  |  |  |";
        String line3 = "  |  |  |  |  |  |  |  |  |";
        String line4 = "                           ";
        String[] lines = {line1,line2,line3,line4};
        EntryReader reader = new EntryReader();
        String expected = "111111111";
        String actual = reader.readAccountNumber(lines);
        assertEquals(expected, actual);
    }
}