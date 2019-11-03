package org.fundacionjala.coding.joseColina;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestChecksum {
    @Test
    public void testChecksumValid(){
        String accountNumber = "999215817";
        Checksum checksum = new Checksum();
        assertTrue(checksum.isAccountValid(accountNumber));
    }
    @Test
    public void testChecksumNotValid(){
        String accountNumber = "999215810";
        Checksum checksum = new Checksum();
        assertFalse(checksum.isAccountValid(accountNumber));
    }
}
