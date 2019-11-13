package org.fundacionjala.coding.ruben;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Account {

    public static String getAccountNumber(File file) throws FileNotFoundException {
        StringBuilder accountNumber = new StringBuilder();
        List<String> digits = getAccountDigits(file);
        for (String digit : digits) {
            accountNumber.append(Numbers.getNumber(digit));
        }
        return accountNumber.toString();
    }

    private static List<String> getAccountDigits(File file) throws FileNotFoundException {
        List<String> digits = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        for (int aux1 = 0; aux1 < 3 ; aux1++) {
            String line = scanner.nextLine();
            if (line != null) {
                int aux2 = 0;
                for (String digit : String.format("%-27s", line).split(
                        "(?<=\\G.{3})")) {
                    try {
                        digits.set(aux2, digits.get(aux2).concat(digit));
                    } catch (IndexOutOfBoundsException e) {
                        digits.add(digit);
                    }
                    aux2++;
                }
            }
        }
        return digits;
    }
}
