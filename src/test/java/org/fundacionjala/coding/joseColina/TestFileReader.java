package org.fundacionjala.coding.joseColina;

import org.junit.Test;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TestFileReader {
    @Test
    public void testReadEntries(){
        FileReader fileReader = new FileReader();
        String resourcePath = Paths.get(".").toAbsolutePath().normalize().toString() + "\\src\\test\\resources\\";
        String filePath = resourcePath + "entries.txt";
        String[] s1 = { " _  _  _  _  _  _  _  _  _ ",
                        "| || || || || || || || || |",
                        "|_||_||_||_||_||_||_||_||_|",
                        "                            "};
        String[] s2 = {"                           ",
                        "  |  |  |  |  |  |  |  |  |",
                        "  |  |  |  |  |  |  |  |  |",
                        "                           "};
        Object[] expectedEntries = {s1, s2};
        List<String[]> entriesList = fileReader.readEntries(filePath);
        Object[] actualEntries = entriesList.toArray();
        assertTrue(Arrays.deepEquals(expectedEntries, actualEntries));
    }
}
