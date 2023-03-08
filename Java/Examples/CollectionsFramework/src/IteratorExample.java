import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class IteratorExample {

	public static void main(String[] args) {
		
		ArrayList<String> listOfStrings = new ArrayList<>();
		
		listOfStrings.add("zero");
		listOfStrings.add("one");
		listOfStrings.add("two");
		listOfStrings.add("three");
		listOfStrings.add("four");
		listOfStrings.add("five");
		
		
		
		for (Iterator<String> iterator = listOfStrings.iterator(); iterator.hasNext();) {
			
			String element = iterator.next();
			if (element.equals("three")) {
				
			}
			System.out.println(element);
			
		}
		
		
		ArrayList<String> strings = new ArrayList<>(Arrays.asList("a","b","c"));
		
		String aChar = strings.get(0);
 	}
	 
	
	
}
