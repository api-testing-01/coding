package org.fundacionjala.coding.joseColina;

import java.util.ArrayList;
import java.util.List;

public class EntryFixer {
    private static final int WIDTH_OF_DIGIT = 3;

    public Entry fixEntry(final Entry entry){
        Entry entryFixed = new Entry(entry.getLines());
        List<String> entryLines = new ArrayList<>(entry.getLines());
        List<String> accountsResults = new ArrayList<>();
        EntryValidator validator = new EntryValidator();
        for (int i=0; i < entryLines.size() - 1; i++){
            int offset = 0;
            int lengthOfLine = entryLines.get(i).length();
            for(int j= 0; j < lengthOfLine; j++){
                List<String> linesFixed = getLinesFixed(i, j, offset, entryLines);

                System.out.println(linesFixed.get(0).toString());
                System.out.println(linesFixed.get(1).toString());
                System.out.println(linesFixed.get(2).toString());
                System.out.println(linesFixed.get(3).toString());

                Entry entryValidated = validator.validateEntry(new Entry(linesFixed));
                String account = entryValidated.getAccountNumber();
                if(!account.contains("ILL") && !account.contains("ERR")){
                    accountsResults.add(account);
                }
                offset = (j/WIDTH_OF_DIGIT)*WIDTH_OF_DIGIT;
            }
        }
        String accountConcatenated = concatResults(entry.getAccountNumber(), accountsResults);
        entryFixed.setAccountNumber(accountConcatenated);
        System.out.println(entryFixed.getAccountNumber());
        return entryFixed;
    }

    private List<String> getLinesFixed(int numberOfLine, int positionOfChar, int offset, List<String> entryLines) {
        List<String> linesResults = new ArrayList<>(entryLines);
        StringBuilder lineFixed = new StringBuilder(entryLines.get(numberOfLine));
        String replaceSymbol = "";
        if(lineFixed.charAt(positionOfChar) != ' '){
            replaceSymbol = " ";
        } else if(positionOfChar == ++offset ){
            replaceSymbol = "_";
        }
        else{
            replaceSymbol = "|";
        }
        lineFixed.replace(positionOfChar, positionOfChar +1, replaceSymbol);
        linesResults.set(numberOfLine, lineFixed.toString());
        return linesResults;
    }

    private String concatResults(final String accountNumber, final List<String> results) {
        String accountResult = accountNumber;
        if(!results.isEmpty()){
            if(results.size() > 1){
                accountResult = accountNumber + " AMB [";
                for(int i =0; i< results.size(); i++){
                    accountResult +=  "'" + results.get(i) + "', ";
                }
                accountResult = accountResult.substring(0, accountResult.length() - 2) + "]";
            }
            else{
                accountResult = results.get(0);
            }

        }
        return accountResult;
    }
}
