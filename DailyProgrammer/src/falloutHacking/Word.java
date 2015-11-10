package falloutHacking;

import java.util.ArrayList;
import java.util.List;

public class Word {
	private String word;
	private int guesses;
	private List<Integer> correctGuesses = new ArrayList<Integer>();

	public Word(String word) {
		this.word = word.toLowerCase(); //The user won't be shown the word, therefore, casing won't matter
	}
	
	public void submitGuess(String guess){
		int maxIteration = Math.min(guess.length(), word.length());
		guess = guess.toLowerCase();
		for (int i = 0; i < maxIteration; i++){
			if (guess.charAt(i)==word.charAt(i) && !correctGuesses.contains(i)){
				correctGuesses.add(i);
			}
		}
	}
	
	public void clearGuesses(){
		correctGuesses = new ArrayList<Integer>();
	}
	
	public String correctResults(){
		StringBuffer sb = new StringBuffer();
		for (int i : correctGuesses){
			sb.append(i);
			sb.append(",");
		}
		return sb.toString();
	}
	
	public String getNumberOfCorrectGuesses(){
		return correctGuesses.size() + "/" + word.length() + " correct letters";
	}
	
	public boolean hasWon(){
		return word.length()==correctGuesses.size();
	}
	
	public String getWord(){
		return word;
	}
}
