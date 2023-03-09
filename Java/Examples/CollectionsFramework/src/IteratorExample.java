import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class IteratorExample {

	public static void main(String[] args) {

		ArrayList<String> listOfStrings = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five"));

		for (Iterator<String> iterator = listOfStrings.iterator(); iterator.hasNext();) {

			String element = iterator.next();
			if (element.equals("three")) {
				System.out.println(element);
			}

		}
		
		
		listOfStrings.subList(1, 3).clear();

		ArrayList<String> strings = new ArrayList<>(Arrays.asList("a", "b", "c"));

		String aChar = strings.get(0);
		
		
		
		class Employee {

			public int age;

			public Employee(int age) {
				this.age = age;
			}

		}

		class AgeSorter implements Comparator<Employee> {

			@Override
			public int compare(Employee e1, Employee e2) {
				if (e1.age < e2.age) {
					return -1;
				} else if (e1.age > e2.age) {
					return 1;
				} else {
					return 0;
				}
			}

		}
		
		Comparator<Employee> newSorter = (e1,e2)->{ return -1;};
		
		ArrayList<Employee> employees = new ArrayList<>();
		
		
		employees.add(new Employee(23));
		employees.add(new Employee(28));
		employees.add(new Employee(19));
		
		
		employees.sort(new AgeSorter());
	}

	

}
