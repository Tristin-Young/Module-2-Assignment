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

		Map<String, Integer> map = new HashMap<String, Integer>();
		countEachWord("C:\\Users\\trist\\Desktop\\Software Dev 1\\Module-2-Assignment\\Module 2 Assignment Input.htm", map);
		
		List <Entry<String, Integer>> nlist = new ArrayList<>(map.entrySet());
		nlist.sort(Entry.comparingByValue(Comparator.reverseOrder()));
		
		for(int i = 0; i < 20; i++)
		{
			System.out.println(i+1 + ":" + nlist.get(i));
		}
		//nlist.forEach(System.out::println);
		//Stream<Map.Entry<K, V>> sorted = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).limit(20).forEach(System.out::println);
	}

}
