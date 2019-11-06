package org.fundacionjala.coding.joseColina;

import java.util.ArrayList;
import java.util.List;

public class EntryFixer {

    public Entry fixEntry(final Entry entry){
        Entry entryFixed = entry;
        List<String> entryLines = entry.getLines();
        List<String> results = new ArrayList<>();
        EntryValidator validator = new EntryValidator();
        String replaceSymbol = "";
        StringBuilder lineToFix;
        for (int i=0; i < entryLines.size(); i++){
            int offset = 0;
            String line = entryLines.get(i);
            for(int j= 0; j < line.length(); j++){
                lineToFix = new StringBuilder(line);
                if(line.charAt(j) != ' '){
                    replaceSymbol = " ";
                } else if(i == (offset + 1)){
                    replaceSymbol = "_";
                }
                else{
                    replaceSymbol = "|";
                }
                lineToFix.replace(j, j +1, replaceSymbol);
                List<String> linesToTest = entryLines;
                linesToTest.set(j, lineToFix.toString());
                Entry entryToTest = new Entry(linesToTest);
                Entry entryValidated = validator.validateEntry(entryToTest);
                String account = entryValidated.getAccountNumber();
                if(!account.contains("ILL") && !account.contains("ERR")){
                    results.add(account);
                }
                offset += 3;
            }
        }
        if(!results.isEmpty()){
            String accountResult;
            if(results.size() > 1){
                accountResult = entry.getAccountNumber() + " AMB [";
                for(int i =0; i< results.size(); i++){
                    accountResult +=  "'" + results.get(i) + "', ";
                }
                accountResult = accountResult.substring(0, accountResult.length() - 2) + "]";
            }
            else{
                accountResult = results.get(0);
            }
            entryFixed.setAccountNumber(accountResult);
        }
        return entryFixed;
    }
}
