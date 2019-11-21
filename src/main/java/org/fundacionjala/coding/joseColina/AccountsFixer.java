package org.fundacionjala.coding.joseColina;

import java.util.ArrayList;
import java.util.List;

public class AccountsFixer {
    private SingleAccountFixer fixer;

    public AccountsFixer() {
        fixer = new SingleAccountFixer();
    }

    public List<Account> fixAccounts(List<Account> accounts) {
        List<Account> accountsFixed = new ArrayList<>();
        for (Account account : accounts) {
            if (!account.isValid()) {
                accountsFixed.add(fixer.fixAccount(account));
            } else {
                accountsFixed.add(new Account(account));
            }
        }
        return accountsFixed;
    }
}
