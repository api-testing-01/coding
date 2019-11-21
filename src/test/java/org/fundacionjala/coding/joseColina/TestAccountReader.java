package org.fundacionjala.coding.joseColina;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class TestAccountReader {
    private static List<String> lines;

    @BeforeClass
    public static void SetUp(){
        String resourcePath = Paths.get(".").toAbsolutePath().normalize().toString() + "\\src\\test\\resources\\joseColina\\";
        String filePath = resourcePath + "digits0-9.txt";
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
    public void testEntryReaderWith000000000(){
        List<String> linesFor0 = lines.subList(0, 4);
        SingleAccountReader reader = new SingleAccountReader();
        String expected = "000000000";
        String actual = reader.readAccountNumber(linesFor0);
        assertEquals(expected, actual);
    }
    @Test
    public void testEntryReaderWith111111111(){
        List<String> linesFor1 = lines.subList(4, 8);
        SingleAccountReader reader = new SingleAccountReader();
        String expected = "111111111";
        String actual = reader.readAccountNumber(linesFor1);
        assertEquals(expected, actual);
    }
    @Test
    public void testEntryReaderWith222222222(){
        List<String> linesFor2 = lines.subList(8, 12);
        SingleAccountReader reader = new SingleAccountReader();
        String expected = "222222222";
        String actual = reader.readAccountNumber(linesFor2);
        assertEquals(expected, actual);
    }
    @Test
    public void testEntryReaderWith333333333(){
        List<String> linesFor3 = lines.subList(12, 16);
        SingleAccountReader reader = new SingleAccountReader();
        String expected = "333333333";
        String actual = reader.readAccountNumber(linesFor3);
        assertEquals(expected, actual);
    }
    @Test
    public void testEntryReaderWith444444444(){
        List<String> linesFor4 = lines.subList(16, 20);
        SingleAccountReader reader = new SingleAccountReader();
        String expected = "444444444";
        String actual = reader.readAccountNumber(linesFor4);
        assertEquals(expected, actual);
    }
    @Test
    public void testEntryReaderWith555555555(){
        List<String> linesFor5 = lines.subList(20, 24);
        SingleAccountReader reader = new SingleAccountReader();
        String expected = "555555555";
        String actual = reader.readAccountNumber(linesFor5);
        assertEquals(expected, actual);
    }
    @Test
    public void testEntryReaderWith666666666(){
        List<String> linesFor6 = lines.subList(24, 28);
        SingleAccountReader reader = new SingleAccountReader();
        String expected = "666666666";
        String actual = reader.readAccountNumber(linesFor6);
        assertEquals(expected, actual);
    }
    @Test
    public void testEntryReaderWith777777777(){
        List<String> linesFor7 = lines.subList(28, 32);
        SingleAccountReader reader = new SingleAccountReader();
        String expected = "777777777";
        String actual = reader.readAccountNumber(linesFor7);
        assertEquals(expected, actual);
    }
    @Test
    public void testEntryReaderWith888888888(){
        List<String> linesFor8 = lines.subList(32, 36);
        SingleAccountReader reader = new SingleAccountReader();
        String expected = "888888888";
        String actual = reader.readAccountNumber(linesFor8);
        assertEquals(expected, actual);
    }
    @Test
    public void testEntryReaderWith999999999(){
        List<String> linesFor9 = lines.subList(36, 40);
        SingleAccountReader reader = new SingleAccountReader();
        String expected = "999999999";
        String actual = reader.readAccountNumber(linesFor9);
        assertEquals(expected, actual);
    }
    @Test
    public void testEntryReaderWith123456789(){
        List<String> linesFor1_9 = lines.subList(40, 44);
        SingleAccountReader reader = new SingleAccountReader();
        String expected = "123456789";
        String actual = reader.readAccountNumber(linesFor1_9);
        assertEquals(expected, actual);
    }
    @Test
    public void testEntryReaderWithNonValidPattern(){
        String line1 = "                           ";
        String line2 = "  |  |  |  |  |  |  |  |  |";
        String line3 = "  |  |  |  | _|  |  |  |  |";
        String line4 = "                           ";
        List<String> lines = new ArrayList<>();
        lines.add(line1);
        lines.add(line2);
        lines.add(line3);
        lines.add(line4);
        SingleAccountReader reader = new SingleAccountReader();
        String expected = "1111?1111";
        String actual = reader.readAccountNumber(lines);
        assertEquals(expected, actual);
    }
}