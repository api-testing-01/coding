package org.fundacionjala.coding.benjamin;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * @author Benjamin Huanca on 10/16/2019.
 * @version 1.0
 */
public class DigitMatrix {
    private static final int DIMENSION = 3;

    /**
     * Retrieves de represented digit.
     *
     * @param matrix input
     * @return am integer digit
     */
    public char getCharacter(final char[][] matrix) {
        int keyGenerator = 0;
        char recognizedChar;
        ArrayList<Integer> keyArray = new ArrayList<>();

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                keyArray.add((matrix[row][column] == ' ') ? 0 : ((int) Math.pow(2, keyGenerator)));
                keyGenerator++;
            }
        }

        int key = 0;
        for (int value : keyArray) {
            key += value;
        }

        recognizedChar = getNumber(key);

        return recognizedChar;
    }

    /**
     * Decode all the matrix.
     *
     * @param matrix initial matrix.
     * @return decoded line.
     */
    public String decoder(final char[][] matrix) {
        int digitPosition = 0;
        char[][] tempMatrix = new char[matrix.length][DIMENSION];
        int columnCounter = 0;
        final int maxQuantityDigits = 9;
        final int columnsPerDigit = 3;
        ArrayList<Character> accountNumber = new ArrayList<>();

        while (digitPosition < maxQuantityDigits) {
            for (int row = 0; row < matrix.length; row++) {
                for (int column = columnsPerDigit * digitPosition; column < columnsPerDigit * (digitPosition + 1);
                     column++) {
                    tempMatrix[row][columnCounter] = matrix[row][column];
                    columnCounter++;
                }

                columnCounter = 0;

            }
            accountNumber.add(getCharacter(tempMatrix));
            digitPosition++;
        }
        StringBuilder accountNumberString = new StringBuilder();
        for (Character ch : accountNumber) {
            accountNumberString.append(ch);
        }
        return accountNumberString.toString();
    }

    /**
     * Retrieves the represented number.
     *
     * @param key to retrieve a number.
     * @return number as char.
     */

    private char getNumber(final int key) {

        // Creating an empty HashMap
        HashMap<Integer, Character> decimalValues = new HashMap<>();
        final int one = 288;
        final int two = 242;
        final int three = 434;
        final int four = 312;
        final int five = 410;
        final int six = 474;
        final int seven = 290;
        final int eight = 506;
        final int nine = 442;
        final int zero = 490;
        // Mapping int values to int keys
        decimalValues.put(one, '1');
        decimalValues.put(two, '2');
        decimalValues.put(three, '3');
        decimalValues.put(four, '4');
        decimalValues.put(five, '5');
        decimalValues.put(six, '6');
        decimalValues.put(seven, '7');
        decimalValues.put(eight, '8');
        decimalValues.put(nine, '9');
        decimalValues.put(zero, '0');

        return decimalValues.getOrDefault(key, '?');
    }
}
