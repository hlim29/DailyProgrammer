package typoglycemia;

import java.util.concurrent.ThreadLocalRandom;

public class Word {
	private String word;
	private int firstLetterIndex;
	private int lastLetterIndex;

	public Word(String word) {
		this.word = word;
		setupLetterIndices();
	}

	private void setupLetterIndices() {
		for (int i = 0; i < word.length(); i++){
			
			if (Character.isLetter(word.charAt(i))){
				firstLetterIndex = i;
				break;
			}
			
		}
		
		for (int i = word.length()-1; i > 0; i--){
			if (Character.isLetter(word.charAt(i))){
				lastLetterIndex = i;
				break;
			}
		}
	}

	public String scrambleWord() {
		StringBuffer result = new StringBuffer();
		result.append(word);
		for (int i = ++firstLetterIndex; i < lastLetterIndex; i++) {
			int random = (int)(ThreadLocalRandom.current().nextInt(firstLetterIndex, lastLetterIndex));
			char temp = result.charAt(i);
			result.setCharAt(i, result.charAt(random));
			result.setCharAt(random, temp);
		}
		return result.toString();
	}
}
