package org.fundacionjala.coding.joseColina;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountsReader {
    private static final int NUMBER_OF_LINES_PER_ENTRY = 4;
    private List<Account> accounts;
//    private SingleAccountReader accountReader;
    //private AccountValidator accountValidator;
    private String path;
    private File file;
    private Scanner scanner;

    public AccountsReader(String path){
        accounts = new ArrayList<>();
//        accountReader = new SingleAccountReader();
//        accountValidator =  new AccountValidator();
        this.path = path;
    }

    public List<Account> readAccounts(String path){
        cleanAccounts();
        this.path = path;
        List<List> entryLines = readEntryLines();
        for(List<String> lines : entryLines){
            Account account = new Account(lines);
            accounts.add(account);
        }
        return accounts;
    }

    public List<List> readEntryLines(){
        List<String> accountLines = new ArrayList<>();
        List<List> entries = new ArrayList<>();
        file = new File(path);
        try{
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                for(int i = 0; i < NUMBER_OF_LINES_PER_ENTRY; i++ ){
                    accountLines.add(scanner.nextLine());
                }
//                accounts.add(new Account(accountLines));
                entries.add(new ArrayList(accountLines));
                accountLines.clear();
            }
        }
        catch(Exception e){
            System.out.println("Error reading file: " + e.getMessage());
        }
        return entries;
    }

    public List<Account> getAccounts(){
        return accounts;
    }

    public void cleanAccounts(){
        accounts.clear();
    }

//    public void validateEntries(){
//        for(int i = 0; i < accounts.size(); i++){
//            Account accountValidated = accountValidator.validateAccountNumber(accounts.get(i));
//            accounts.set(i, accountValidated);
//        }
//    }

    public void writeToFile(String path){
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
