package module_2_assignment;

//importing libraries
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

//function to count each word in a given file
//Specifically, this function will only count the words in between paragraph tags in an HTML doc (<p> to </p>)
//There is some coercion of the words to normalize them of any capitalization or punctuation.
static void countEachWord(String fileName, Map<String, Integer> words) throws FileNotFoundException {
//read in file
Scanner file = new Scanner(new File(fileName));
//while we are not at the end of the file
while(file.hasNext()) {
//set word to lowercase
String word = file.next().toLowerCase();
//if the word is a paragraph tag <p>
if(word.contentEquals("<p>")) {
//while we are not at the closing paragraph tag </p>
do {
//coercion
//remove any capitalization as well as special chars !.,'
word = file.next().toLowerCase();
word = word.replaceAll(",", "").replaceAll("!", "")
.replaceAll("\\.", "").replaceAll("'", "");
//if the word contains chars that make it an HTML tag
if(word.contains("<") || word.contains(">") || word.contains("/")
|| word.contains(":") || word.contains("&")
|| word.contains("“") || word.contains("“")) {
//skip the word
continue;
}
//otherwise get the current count from the map
Integer count = words.get(word);
//if the count exists, increment it
if(count != null)
{
count++;
}
//otherwise create count and set it to 1
else {
count = 1;
}
//save the new count into the map so long as the word != </p>
if(!word.contentEquals("</p>")) {
words.put(word, count);
}

}while(!word.contentEquals("</p>"));

}



}
//close the file
file.close();
}

//helper function to print the results of the map
static void printResults(List <Entry<String, Integer>> list, int amount) {
//for loop to iterate over items
for(int i = 0; i < amount; i++)
{
//print out index as well as word/count pair
System.out.println(i+1 + ": " + list.get(i));
}
}

//psvm
public static void main(String[] args) throws FileNotFoundException {

//create mao to store word / count pair
Map<String, Integer> map = new HashMap<String, Integer>();
//run count function. Pass in path of file as well as HashMap

//filepath for windows
//countEachWord("C:\\Users\\trist\\Desktop\\Software Dev 1\\Module-2-Assignment\\Module 2 Assignment Input.htm", map);

//filepath for mac
//countEachWord("/Users/tristin/Desktop/Software dev 1/Module-2-Assignment/Module 2 Assignment Input.htm", map);

//relative file path
countEachWord("../Module-2-Assignment/Module 2 Assignment Input.htm", map);

//create ArrayList to sort HashMap by value
List <Entry<String, Integer>> nlist = new ArrayList<>(map.entrySet());
//sort by value from greatest to least
nlist.sort(Entry.comparingByValue(Comparator.reverseOrder()));
//call helper function to print first 20 results
printResults(nlist, 20);


//commented out print ln to see all output
//nlist.forEach(System.out::println);
}

}