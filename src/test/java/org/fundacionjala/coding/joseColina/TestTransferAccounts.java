package org.fundacionjala.coding.joseColina;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertTrue;

public class TestTransferAccounts {
    private static String resourcePath;
    private static String inputFile;
    private static String actualResultPath;
    private static String expectedPath;
    private static File actualFile;
    private static File expectedFile;
    private static List<String> actualList;
    private static List<String> expectedList;

    @BeforeClass
    public static void SetUp(){
        resourcePath = Paths.get(".").toAbsolutePath().normalize().toString() + "\\src\\test\\resources\\joseColina\\";
        inputFile = resourcePath + "input.txt";
        actualResultPath = resourcePath + "output.txt";
        expectedPath = resourcePath + "expected.txt";
        actualFile = new File(actualResultPath);
        expectedFile = new File(expectedPath);
        if(actualFile.exists() && !actualFile.isDirectory()){
            actualFile.delete();
        }
        try{
            actualFile.createNewFile();
        }
        catch(Exception e){
            System.out.println("Error creating file: " + e.getMessage());
        }
    }

    @Test
    public void testTransferAccounts(){
        TransferAccounts transferAccounts = new TransferAccounts();
        transferAccounts.transferAccounts(inputFile, actualResultPath);
        actualList = new ArrayList<>();
        expectedList = new ArrayList<>();
        readFiles();
        Object[] actual = actualList.toArray();
        Object[] expected = expectedList.toArray();
        assertTrue(Arrays.deepEquals(actual, expected));

    }

    public void readFiles(){
        try{
            Scanner actualScanner = new Scanner(actualFile);
            Scanner expectedScanner = new Scanner(expectedFile);
            while (actualScanner.hasNextLine()) {
                actualList.add(actualScanner.nextLine());
            }
            while (expectedScanner.hasNextLine()) {
                expectedList.add(expectedScanner.nextLine());
            }
        }
        catch(Exception e){
            System.out.println("Error opening file: " + e.getMessage());
            Assert.fail();
        }

    }
}
