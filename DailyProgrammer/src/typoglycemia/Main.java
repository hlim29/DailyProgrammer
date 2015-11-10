package typoglycemia;

import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		System.out.println("Hello!");
		System.out.println("Please enter a sentence for me to scramble:");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] words = input.split(" ");
		
		output(words);
	}
	
	private static void output(String[] words){
		for (String s : words){
			System.out.print(new Word(s).scrambleWord());
			System.out.print(" ");
		}
		System.out.println();
	}
}
