package org.fundacionjala.coding.joseColina;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SingleAccountFixer {
    private static final int WIDTH_OF_DIGIT = 3;

    public Account fixAccount(final Account account) {
        Account accountFixed = new Account(account);
        List<String> entryLines = new ArrayList<>(account.getLines());
        List<String> accountsResults = new ArrayList<>();
        for (int i = 0; i < entryLines.size() - 1; i++) {
            int offset = 0;
            int lengthOfLine = entryLines.get(i).length();
            for (int j = 0; j < lengthOfLine; j++) {
                List<String> linesFixed = getLinesFixed(i, j, offset, entryLines);
                Account accountValidated = new Account(linesFixed);
                String accountNumber = accountValidated.getAccountNumber();
                if (!accountNumber.contains("ILL") && !accountNumber.contains("ERR")) {
                    accountsResults.add(accountNumber);
                }
                offset = (j / WIDTH_OF_DIGIT) * WIDTH_OF_DIGIT;
            }
        }
        accountsResults = sortResults(accountsResults);
        String accountConcatenated = concatResults(account.getAccountNumber(), accountsResults);
        accountFixed.setAccountNumber(accountConcatenated);
        System.out.println(accountFixed.getAccountNumber());
        return accountFixed;
    }

    private List<String> sortResults(final List<String> results) {
        List<String> sortedResults = results.stream().sorted().collect(Collectors.toList());
        return sortedResults;
    }

    private List<String> getLinesFixed(int numberOfLine, int positionOfChar, int offset, List<String> entryLines) {
        List<String> linesResults = new ArrayList<>(entryLines);
        StringBuilder lineFixed = new StringBuilder(entryLines.get(numberOfLine));
        String replaceSymbol = "";
        if (lineFixed.charAt(positionOfChar) != ' ') {
            replaceSymbol = " ";
        } else if (positionOfChar == ++offset) {
            replaceSymbol = "_";
        } else {
            replaceSymbol = "|";
        }
        lineFixed.replace(positionOfChar, positionOfChar + 1, replaceSymbol);
        linesResults.set(numberOfLine, lineFixed.toString());
        return linesResults;
    }

    private String concatResults(final String accountNumber, final List<String> results) {
        String accountResult = accountNumber;
        if (!results.isEmpty()) {
            accountResult = accountResult.substring(0, accountResult.length() - 4);
            if (results.size() > 1) {
                accountResult = accountResult + " AMB [";
                for (int i = 0; i < results.size(); i++) {
                    accountResult += "'" + results.get(i) + "', ";
                }
                accountResult = accountResult.substring(0, accountResult.length() - 2) + "]";
            } else {
                accountResult = results.get(0);
            }

        }
        return accountResult;
    }
}
