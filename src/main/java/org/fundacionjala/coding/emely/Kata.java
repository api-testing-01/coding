package org.fundacionjala.coding.emely;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringJoiner;

public class Kata {
    private Kata(){

    }

    public static String sortTheInnerContent(String words)
    {
        String[] allWords = words.split(" ");
        char[] charArray;
        char[] sortedArray;
        StringJoiner sortedInnerSentence = new StringJoiner(" ");

        for (int i=0; i<allWords.length; i++){
            ArrayList<Character> inner = new ArrayList<>();
            charArray = allWords[i].toCharArray();
            sortedArray = new char[charArray.length];
            sortedArray[0] = charArray[0];
            String sortedInner;
            for(int j=1; j+1<charArray.length ; j++){
                inner.add(charArray[j]);
            }
            Collections.sort(inner, Collections.reverseOrder());
            for(int j=0; j<inner.size(); j++) {
                sortedArray[j + 1] = inner.get(j);
            }
            sortedArray[sortedArray.length-1] = charArray[charArray.length-1];
            sortedInner = String.valueOf(sortedArray);
            sortedInnerSentence.add(sortedInner);
            //sortedInnerSentence += sortedInner + " ";
        }
        words = sortedInnerSentence.toString();
        return words;
    }
}
