package org.fundacionjala.coding.lizzy;

public class Sort {
    public static String sortTheInnerContent(String sentence)
    {
        String[] words = sentence.split(" ");
        StringBuilder sorted = new StringBuilder();
        for (String word: words) {
            String first = word.substring(0, 1);
            String last = word.substring(word.length() -1);
            StringBuilder middle = new StringBuilder(word.substring(1, word.length() -1));
            for (int i = 0; i < middle.length() - 1; i++) {
                for (int j = i + 1; j < middle.length(); j++) {
                    if (middle.charAt(i) < middle.charAt(j)) {
                        char temp = middle.charAt(i);
                        middle.setCharAt(i, middle.charAt(j));
                        middle.setCharAt(j, temp);
                    }
                }
            }
            sorted.append(first + middle.toString() + last + " ");
        }
        return sorted.toString().trim();
    }

    public static void main(String[] args) {
        String result = sortTheInnerContent("lizzy mendivil");
        System.out.println(result);
    }
}
