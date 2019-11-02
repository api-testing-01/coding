package org.fundacionjala.coding.joseColina;

import org.junit.Assert;
import org.junit.Test;

public class TestChecksum {
    @Test
    public void testChecksumValid(){
        String accountNumber = "999215810";
        Checksum checksum = new Checksum();
        Assert.assertTrue(checksum.isAccountValid(accountNumber));
    }
}
