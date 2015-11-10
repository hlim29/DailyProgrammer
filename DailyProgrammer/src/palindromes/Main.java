package palindromes;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello! Please input a string for me to check whether if it's a palindrome or not");
		Scanner sc = new Scanner(System.in);
		
		String cleanedString = dropNonAlpha(sc.nextLine());
		String reversedInput = reverse(cleanedString);
		
		for (int i = 0; i < cleanedString.length(); i++){
			if (cleanedString.charAt(i) != reversedInput.charAt(i)){
				System.out.println("Not a palindrome");
				return;
			}
		}
		System.out.println("We have a palindrome!");
	}

	private static String dropNonAlpha(String input){
		return input.toLowerCase().replaceAll("[^A-z]", "");
	}
	
	private static String reverse(String input){
		StringBuffer sb = new StringBuffer();
		sb.append(input);
		sb.reverse();
		
		return sb.toString();
	}
	
}
