package org.fundacionjala.coding;

import java.util.Arrays;

public class InnerContentSorter {

	private final int MIN_WORD_SIZE = 2;
	private final String SEPARATOR = " ";
	
	public String sortInnerContent(String originalPhrase) {
		if (originalPhrase == null) {
			return null;
		}
		
		String trimmedPhrase = originalPhrase.trim();
		int phraseSize = trimmedPhrase.length();
		if (phraseSize <= MIN_WORD_SIZE) {
			return trimmedPhrase;
		}
		
		String[] phraseArray = trimmedPhrase.split(SEPARATOR);
		String currentWord = "";
		String currentSortedWord = "";
		String currentInnerWord = "";
		char[] currentInnerWordChars = null;
		char[] tempCurrentInnerWordChars = null;
		int currentWordSize = 0;
		int tempCurrentInnerWordCharsSize = 0;
		
		for (int i = 0; i < phraseArray.length; i++) {
			currentWord = phraseArray[i];
			currentWordSize = currentWord.length();
			if (currentWordSize > MIN_WORD_SIZE) {
				currentInnerWord = currentWord.substring(1, currentWordSize - 1);
				tempCurrentInnerWordChars = currentInnerWord.toCharArray();
				Arrays.sort(tempCurrentInnerWordChars);
				tempCurrentInnerWordCharsSize = tempCurrentInnerWordChars.length;
				currentInnerWordChars = new char[tempCurrentInnerWordCharsSize];
				for (int j = 0, k = tempCurrentInnerWordCharsSize - 1; j < tempCurrentInnerWordCharsSize; j++, k--) {
					currentInnerWordChars[j] = tempCurrentInnerWordChars[k];
				}
				currentSortedWord = currentWord.charAt(0) + new String(currentInnerWordChars) + currentWord.charAt(currentWordSize - 1);
				phraseArray[i] = currentSortedWord;
			}
		}
		
		return String.join(SEPARATOR, phraseArray);
	}
}
