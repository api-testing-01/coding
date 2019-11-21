package org.fundacionjala.coding.joseColina;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private List<String> entryLines;
    private String accountNumber;
    private SingleAccountReader accountReader;
    private AccountValidator validator;
    private boolean isValid;

    public Account(final Account account) {
        accountNumber = account.getAccountNumber();
        entryLines = new ArrayList<>(account.getLines());
        isValid = account.isValid();
    }

    public Account(final List<String> entryLines) {
        this.entryLines = new ArrayList<>(entryLines);
        accountReader = new SingleAccountReader();
        validator = new AccountValidator();
        init();
    }

    private void init() {
        isValid = true;
        accountNumber = generateAccountNumber();
        accountNumber = validator.validateAccountNumber(accountNumber);
        if (accountNumber.contains("ILL") || accountNumber.contains("ERR")) {
            isValid = false;
        }
    }

    private String generateAccountNumber() {
        return accountReader.readAccountNumber(entryLines);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public List<String> getLines() {
        return entryLines;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setEntryLines(List<String> entryLines) {
        this.entryLines = new ArrayList<>(entryLines);
    }

    public boolean isValid() {
        return isValid;
    }
}
