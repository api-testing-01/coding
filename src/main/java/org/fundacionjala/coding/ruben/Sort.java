package org.fundacionjala.coding.ruben;

final class Sort {

    private Sort() {
        //not called
    }

    private static String sortTheInnerContent(final String sentence, final String regex) {
        String[] words = sentence.split(regex);
        StringBuilder newWord = new StringBuilder();
        for (String word : words) {
            String firstLetter = word.substring(0, 1);
            String lastLetter = word.substring(word.length() - 1);
            StringBuilder innerLetters = new StringBuilder(word.substring(1, word.length() - 1));
            for (int aux1 = 0; aux1 < innerLetters.length() - 1; aux1++) {
                for (int aux2 = aux1 + 1; aux2 < innerLetters.length(); aux2++) {
                    if (innerLetters.charAt(aux1) < innerLetters.charAt(aux2)) {
                        char temp = innerLetters.charAt(aux1);
                        innerLetters.setCharAt(aux1, innerLetters.charAt(aux2));
                        innerLetters.setCharAt(aux2, temp);
                    }
                }
            }
            newWord.append(firstLetter).append(innerLetters.toString()).append(lastLetter).append(regex);
        }
        return String.join(regex, newWord);
    }

    public static String validateSentence(final String sentence, final String regex) {
        if (sentence.isEmpty()) {
            System.out.println("error, sentence is empty");
        } else {
            sortTheInnerContent(sentence, regex);
        }
        return sortTheInnerContent(sentence, regex);
    }
}
