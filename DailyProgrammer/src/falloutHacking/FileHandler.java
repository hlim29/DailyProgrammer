package falloutHacking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

	private File file = new File("src/falloutHacking/enable1.txt");
	private List<String> dictionary = new ArrayList<String>();
	
	//Loads the enable1.txt dictionary file in memory
	public FileHandler() throws IOException{
		FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            dictionary.add(line);
        }
        bufferedReader.close();
     
	}
	
	//Retrieves a random word based on its length
	public String getWord(int length){
		String word = new String();
		while (word.length() != length){
			int randomNumber = (int)(Math.random()*dictionary.size());
			word = dictionary.get(randomNumber);
		}
		return word;
	}
}
