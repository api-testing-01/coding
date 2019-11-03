package org.fundacionjala.coding.joseColina;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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

    public void writeToFile(String path){
        String allEntries = "";
        for(Entry entry : entries){
            allEntries += entry.getAccountNumber() + "\n";
        }
        try {
            Files.write(Paths.get(path), allEntries.getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
