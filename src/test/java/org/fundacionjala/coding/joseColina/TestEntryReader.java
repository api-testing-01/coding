package org.fundacionjala.coding.joseColina;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class TestEntryReader {
    @Test
    public void testEntryReaderWith000000000(){
        String line1 = " _  _  _  _  _  _  _  _  _ ";
        String line2 = "| || || || || || || || || |";
        String line3 = "|_||_||_||_||_||_||_||_||_|";
        String line4 = "                           ";
        String[] lines = {line1,line2,line3,line4};
        EntryReader reader = new EntryReader();
        int[] expected = {0,0,0,0,0,0,0,0,0};
        int[] actual = reader.readAccountNumber(lines);
        assertTrue(Arrays.equals(expected,actual));
    }
    @Test
    public void testEntryReaderWith111111111(){
        String line1 = "                           ";
        String line2 = "  |  |  |  |  |  |  |  |  |";
        String line3 = "  |  |  |  |  |  |  |  |  |";
        String line4 = "                           ";
        String[] lines = {line1,line2,line3,line4};
        EntryReader reader = new EntryReader();
        int[] expected = {1,1,1,1,1,1,1,1,1};
        int[] actual = reader.readAccountNumber(lines);
        assertTrue(Arrays.equals(expected,actual));
    }
}