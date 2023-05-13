package module_2_assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class CountWords {

	static void countEachWord(String fileName, Map<String, Integer> words) throws FileNotFoundException {
		Scanner file = new Scanner(new File(fileName));
		while(file.hasNext()) {
			String word = file.next().toLowerCase();
			if(word.contentEquals("<p>")) {
				do {
					word = file.next().toLowerCase();
					word = word.replaceAll(",", "").replaceAll("!", "")
							.replaceAll("\\.", "").replaceAll("'", "");
					
					Integer count = words.get(word);
					if(word.contains("<") || word.contains(">") || word.contains("/") 
						|| word.contains(":") || word.contains("&")) {
						continue;
					} 
					if(count != null)
					{
						count++;
					}
					else {
						count = 1;
					}
					if(!word.contentEquals("</p>")) {
						words.put(word, count);
					}
					
				}while(!word.contentEquals("</p>"));
				
			}
			
			
			
		}
		file.close();
	}
	
	static void printResults(List <Entry<String, Integer>> list, int amount) {
		for(int i = 0; i < amount; i++)
		{
			System.out.println(i+1 + ": " + list.get(i));
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {

		Map<String, Integer> map = new HashMap<String, Integer>();
		countEachWord("C:\\Users\\trist\\Desktop\\Software Dev 1\\Module-2-Assignment\\Module 2 Assignment Input.htm", map);
		
		List <Entry<String, Integer>> nlist = new ArrayList<>(map.entrySet());
		nlist.sort(Entry.comparingByValue(Comparator.reverseOrder()));
		
		printResults(nlist, 20);
		//nlist.forEach(System.out::println);
	}

}
