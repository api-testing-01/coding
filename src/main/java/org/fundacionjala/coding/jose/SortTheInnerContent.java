package org.fundacionjala.coding.jose;

import java.util.Arrays;
import java.util.Collections;

public class SortTheInnerContent {
    public static String sortTheInnerContent(String sentence)
    {
        String[] words = sentence.split(" ");
        System.out.println(sentence);
        for (int i = 0; i < words.length; i++) {
            int wordSize = words[i].length();
            if (wordSize > 3){
                char[] subString =words[i].substring(1, wordSize - 1).toCharArray();
                Arrays.sort(subString);
                String sortString = Arrays.toString(subString).substring(1, 3*subString.length -1).replaceAll(", ","");
                String reverseSubString = new StringBuilder(sortString).reverse().toString();
                words[i] = new StringBuilder(words[i]).replace(1,wordSize - 1, reverseSubString).toString();
            }
        }
        return String.join(" ", words);
    }
}
