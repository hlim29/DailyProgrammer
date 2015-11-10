package falloutHacking;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/*	Puzzle scenario:
 * 	https://www.reddit.com/r/dailyprogrammer/comments/3qjnil/20151028_challenge_238_intermediate_fallout/
 * 
 */

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		FileHandler f = new FileHandler();
		int difficulty = promptNumber("Please enter a difficulty setting (1-15)");
		String puzzle = f.getWord(difficulty);
		System.out.println(puzzle);
		Word game = new Word(puzzle);
		for (int i =0; i < 4 && !game.hasWon(); i++) {
			game.clearGuesses();
			game.submitGuess(prompt());
			System.out.println(game.getNumberOfCorrectGuesses());
		}
		if (game.hasWon()){
			System.out.println("You got it!");
		} else {
			System.out.println("You lost :( ");
		}
		System.out.print("The word was " + game.getWord());
		
	}

	private static String prompt() {
		System.out.println("Please enter a guess");
		return sc.nextLine();
	}
	
	private static int promptNumber(String message){
		System.out.println(message);
		int result = sc.nextInt();
		sc.nextLine();
		return result;
	}
}
