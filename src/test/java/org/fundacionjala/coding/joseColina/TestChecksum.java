package org.fundacionjala.coding.joseColina;

import org.junit.Assert;
import org.junit.Test;

public class TestChecksum {
    @Test
    public void testChecksumValid(){
        String accountNumber = "999215817";
        Checksum checksum = new Checksum();
        Assert.assertTrue(checksum.isAccountValid(accountNumber));
    }
    @Test
    public void testChecksumNotValid(){
        String accountNumber = "999215810";
        Checksum checksum = new Checksum();
        Assert.assertFalse(checksum.isAccountValid(accountNumber));
    }
}
