package org.fundacionjala.coding.joseColina;

import java.util.List;

public class Entry {
    private List<String> entryLines;
    private String accountNumber;
    private EntryReader entryReader;

    public Entry(List<String> entryLines){
        this.entryLines = entryLines;
        entryReader = new EntryReader();
        accountNumber = generateAccountNumber();
    }

    private String generateAccountNumber(){
        return entryReader.readAccountNumber(entryLines);
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }

    public List<String> getLines(){
        return entryLines;
    }
}
