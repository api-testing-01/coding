package org.fundacionjala.coding.joseColina;

import org.junit.Test;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TestAccountsReader {
    @Test
    public void testReadAccounts() {
        String resourcePath = Paths.get(".").toAbsolutePath().normalize().toString() + "\\src\\test\\resources\\joseColina\\";
        String filePath = resourcePath + "entries.txt";
        AccountsReader accountsReader = new AccountsReader();
        String s1 = "000000000 ERR";
        String s2 = "111111111 ERR";
        String[] expectedEntries = {s1, s2};
        List<Account> entries = accountsReader.readAccounts(filePath);
        String[] actualEntries = new String[entries.size()];
        for (int i = 0; i < entries.size(); i++) {
            actualEntries[i] = entries.get(i).getAccountNumber();
            System.out.println(actualEntries[i]);
        }
        assertTrue(Arrays.deepEquals(expectedEntries, actualEntries));
    }
}
