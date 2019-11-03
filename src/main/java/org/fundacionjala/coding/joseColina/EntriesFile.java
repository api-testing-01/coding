package org.fundacionjala.coding.joseColina;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EntriesFile {
    private static final int NUMBER_OF_LINES_FOR_ENTRY = 4;
    private List<Entry> entries;
    private String path;
    private EntryValidator entryValidator;

    public EntriesFile(String path){
        entries = new ArrayList<>();
        entryValidator =  new EntryValidator();
        this.path = path;
    }

    public void readEntries(){
        List<String> lines = new ArrayList<>();
        File file = new File(path);
        try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                for(int i = 0; i < NUMBER_OF_LINES_FOR_ENTRY; i++ ){
                    lines.add(scanner.nextLine());
                }
                entries.add(new Entry(lines));
                lines.clear();
            }
        }
        catch(Exception e){

        }
    }

    public List<Entry> getEntries(){
        return entries;
    }

    public void validateEntries(){
        for(int i =0; i < entries.size(); i++){
            Entry entryValidated = entryValidator.validateEntry(entries.get(i));
            entries.set(i, entryValidated);
        }
    }
}
