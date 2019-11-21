package org.fundacionjala.coding.joseColina;

import java.util.List;

public class TransferAccounts {
    private AccountsReader reader;
    private AccountsDumper writer;
    private AccountsFixer fixer;
    private String inputPath;
    private String outputPath;

    public TransferAccounts(){
        reader = new AccountsReader();
        writer =  new AccountsDumper();
        fixer = new AccountsFixer();
    }

    public void transferAccounts(final String inputPath,final String outputPath){
        this.inputPath = inputPath;
        this.outputPath = outputPath;
        List<Account> accounts = reader.readAccounts(inputPath);
        accounts = fixer.fixAccounts(accounts);
        writer.writeToFile(outputPath, accounts);
    }
}
