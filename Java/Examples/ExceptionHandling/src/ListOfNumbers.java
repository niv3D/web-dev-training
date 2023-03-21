import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class ListOfNumbers {

	private List<Integer> list;
	private static final int SIZE = 10;

	public void listOfNumbers() {
		list = new ArrayList<>(SIZE);

		for (int i = 0; i < SIZE; i++) {
			list.add(i);
		}
	}

	public void writeList() {

		try (PrintWriter output = new PrintWriter(new FileWriter("abc.txt"));) {
			
			File file = new File("a.txt");
			if (file.createNewFile()) {
				System.out.println("created");
			}
			for (int i = 0; i < SIZE; i++) {
				output.println(i);
			}

		} catch (IOException e) {
			System.err.println("IO Exception : " + e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBound Exception : " + e.getMessage());
		}

	}

}
