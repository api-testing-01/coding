package org.fundacionjala.coding.joseColina;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import static org.junit.Assert.assertTrue;

public class TestSingleAccountFixer {
    private static List<String> lines;
    private static int NUMBER_OF_LINES = 4;
    @BeforeClass
    public static void SetUp(){
        String resourcePath = Paths.get(".").toAbsolutePath().normalize().toString() + "\\src\\test\\resources\\joseColina\\";
        String filePath = resourcePath + "entriesToBeFixed.txt";
        lines = new ArrayList<>();
        File file = new File(filePath);
        try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        }
        catch(Exception e){
            System.out.println("Error opening file: " + e.getMessage());
        }
    }
    @Test
    public void testFixEntryWithASingleResult(){
        List<String> results = new ArrayList<>();
        SingleAccountFixer fixer =  new SingleAccountFixer();
        for(int i = 0; i < 16; i+=4){
            Account account = new Account(lines.subList(i, i + NUMBER_OF_LINES));
            Account accountFixed = fixer.fixAccount(account);
            results.add(accountFixed.getAccountNumber());
        }
        Object[] actual = results.toArray();
        Object[] expected = {"711111111", "777777177", "200800000", "333393333"};
        assertTrue(Arrays.deepEquals(actual, expected));
    }
    @Test
    public void testFixEntryWithSeveralResults(){
        List<String> results = new ArrayList<>();
        SingleAccountFixer fixer =  new SingleAccountFixer();
        for(int i = 16; i < 36; i+=4){
            Account account = new Account(lines.subList(i, i + NUMBER_OF_LINES));
            Account accountFixed = fixer.fixAccount(account);
            results.add(accountFixed.getAccountNumber());
        }
        Object[] actual = results.toArray();
        Object[] expected = {"888888888 AMB ['888886888', '888888880', '888888988']",
                "555555555 AMB ['555655555', '559555555']",
                "666666666 AMB ['666566666', '686666666']",
                "999999999 AMB ['899999999', '993999999', '999959999']",
                "490067715 AMB ['490067115', '490067719', '490867715']"};
        assertTrue(Arrays.deepEquals(actual, expected));
    }
    @Test
    public void testFixEntryWithSingleResultFromILL(){
        List<String> results = new ArrayList<>();
        SingleAccountFixer fixer =  new SingleAccountFixer();
        for(int i = 36; i < 48; i+=4){
            Account account = new Account(lines.subList(i, i + NUMBER_OF_LINES));
            Account accountFixed = fixer.fixAccount(account);
            results.add(accountFixed.getAccountNumber());
        }
        Object[] actual = results.toArray();
        Object[] expected = {"123456789", "000000051", "490867715"};
        assertTrue(Arrays.deepEquals(actual, expected));
    }
}
