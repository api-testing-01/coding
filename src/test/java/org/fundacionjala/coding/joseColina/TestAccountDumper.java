package org.fundacionjala.coding.joseColina;

import org.junit.Test;

import java.nio.file.Paths;

public class TestAccountDumper {
    @Test
    public void testWriteToFile(){
        String resourcePath = Paths.get(".").toAbsolutePath().normalize().toString() + "\\src\\test\\resources\\joseColina\\";
        String filePath = resourcePath + "entries.txt";
        String filePathToWrite = resourcePath + "results.txt";
        AccountsReader accounts = new AccountsReader();
        AccountsDumper accountsWriter = new AccountsDumper();
        accountsWriter.writeToFile(filePathToWrite, accounts.readAccounts(filePath));

    }
}
