package brokenKeyboard;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://www.reddit.com/r/dailyprogrammer/comments/3pcb3i/20151019_challenge_237_easy_broken_keyboard/
//Scenario published: 25 October 2015
//Coded: 25 October 2015
public class Main {
	private static List<String> words = new ArrayList<String>();
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws FileNotFoundException, IOException {
		loadFile();
		
		int iterations = sc.nextInt();
		sc.nextLine(); //nextInt ignores the newline character
		List<String> patterns = new ArrayList<String>();

		for (int i = 0; i < iterations; i++) {
			patterns.add(sc.nextLine());
		}
		for (String s : patterns) {
			printLongest(s);
		}
	}
	
	private static void loadFile() {
		String file = "C:\\enable1.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				words.add(line);
			}
		} catch (IOException e){
			e.printStackTrace();
		}
	}

	private static void printLongest(String pattern) {
		String maxLength = new String();
		
		for (String s : words){
			if (Solver.matches(s, pattern)) {
				maxLength = (s.length() > maxLength.length()) ? s : maxLength;
			}
		}
		
		System.out.println(maxLength);
	}
}
