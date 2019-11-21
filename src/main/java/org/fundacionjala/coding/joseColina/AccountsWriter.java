package org.fundacionjala.coding.joseColina;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class AccountsWriter {

    public void writeToFile(String path, List<Account> accounts){
        String allEntries = "";
        for(Account account : accounts){
            allEntries += account.getAccountNumber() + "\n";
        }
        try {
            Files.write(Paths.get(path), allEntries.getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
