package typoglycemia.tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import typoglycemia.Word;

public class WordTest {

	@Test
	public void test_first_last_letters() {
		Word testWord = new Word("Typoglycemia");
		for (int i = 0; i < 100; i++) {
			String scrambledWord = testWord.scrambleWord();

			if (scrambledWord.charAt(0) != 'T' || scrambledWord.charAt(11) != 'a') {
				fail("Either the first or last letter is incorrect" + scrambledWord);
			}
		}
	}
	
	@Test
	public void test_nonalpha_end_letters(){
		Word testWord = new Word("Trailing,");
		for (int i = 0; i < 100; i++) {
			String scrambledWord = testWord.scrambleWord();

			if (scrambledWord.charAt(0) != 'T' || scrambledWord.charAt(7) != 'g') {
				fail("Either the first or last letter is incorrect" + scrambledWord);
			}
		}
	}
	
	@Test
	public void test_nonalpha_start_letters(){
		Word testWord = new Word(".Begin");
		for (int i = 0; i < 100; i++) {
			String scrambledWord = testWord.scrambleWord();

			if (scrambledWord.charAt(1) != 'B' || scrambledWord.charAt(5) != 'n') {
				fail("Either the first or last letter is incorrect" + scrambledWord);
			}
		}
	}

}
