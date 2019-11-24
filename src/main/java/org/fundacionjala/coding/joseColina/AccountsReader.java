package org.fundacionjala.coding.joseColina;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountsReader {
    private static final int NUMBER_OF_LINES_PER_ENTRY = 4;
    private List<Account> accounts;
    private String path;
    private File file;
    private Scanner scanner;

    public AccountsReader() {
        accounts = new ArrayList<>();
    }

    public List<Account> readAccounts(final String path) {
        cleanAccounts();
        this.path = path;
        List<List> entryLines = readEntryLines();
        for (List<String> lines : entryLines) {
            Account account = new Account(lines);
            accounts.add(account);
        }
        return accounts;
    }

    public List<List> readEntryLines() {
        List<String> accountLines = new ArrayList<>();
        List<List> entries = new ArrayList<>();
        file = new File(path);
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                for (int i = 0; i < NUMBER_OF_LINES_PER_ENTRY; i++) {
                    accountLines.add(scanner.nextLine());
                }
                entries.add(new ArrayList(accountLines));
                accountLines.clear();
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return entries;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void cleanAccounts() {
        accounts.clear();
    }

}
