package module_2_assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountWords {

	static void countEachWord(String fileName, Map<String, Integer> words) throws FileNotFoundException {
		Scanner file = new Scanner(new File(fileName));
		while(file.hasNext()) {
			String word = file.next();
			Integer count = words.get(word);
			if(count != null)
			{
				count++;
			}
			else {
				count = 1;
			}
			words.put(word, count);
			
		}
		file.close();
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {

		Map<String, Integer> words = new HashMap<String, Integer>();
		countEachWord("C:\\Users\\trist\\Desktop\\Software Dev 1\\Module-2-Assignment\\Module 2 Assignment Input.htm", words);
		System.out.println(words + "\n");
	}

}
