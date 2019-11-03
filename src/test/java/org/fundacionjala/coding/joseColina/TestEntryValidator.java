package org.fundacionjala.coding.joseColina;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestEntryValidator {
    @Test
    public void testChecksumValid(){
        String accountNumber = "999215817";
        EntryValidator entryValidator = new EntryValidator();
        assertTrue(entryValidator.isChecksumValid(accountNumber));
    }
    @Test
    public void testChecksumNotValid(){
        String accountNumber = "999215810";
        EntryValidator entryValidator = new EntryValidator();
        assertFalse(entryValidator.isChecksumValid(accountNumber));
    }
/*    @Test
    public void testEntryValidatorWithQuestionMarkInEntry(){
        String accountNumber = "999?15810";
        String expected = "999?15810 ILL";
        EntryValidator entryValidator = new EntryValidator();
        String actual = entryValidator.validateEntry(accountNumber);
        assertEquals(expected, actual);
    }
    @Test
    public void testEntryValidatorWitInvalidChecksum(){
        String accountNumber = "999215810";
        String expected = "999215810 ERR";
        EntryValidator entryValidator = new EntryValidator();
        String actual = entryValidator.validateEntry(accountNumber);
        assertEquals(expected, actual);
    }
    @Test
    public void testEntryValidatorWitValidChecksum(){
        String accountNumber = "999215817";
        String expected = "999215817";
        EntryValidator entryValidator = new EntryValidator();
        String actual = entryValidator.validateEntry(accountNumber);
        assertEquals(expected, actual);
    }*/
}
