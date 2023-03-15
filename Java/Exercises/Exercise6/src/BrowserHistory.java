import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;

public class BrowserHistory {

	private ArrayList<String> historyArrayList = new ArrayList<>();
	private HashSet<String> historyHashSet = new HashSet<>();
	
	//private TreeSet<String> historyTreeSet = new TreeSet<>();
	
	private HashMap<String, ArrayList<String>> historyHashMap = new HashMap<>();
	
	private int currentIndex;

	public BrowserHistory(String homepageUrl) throws InvalidURLException {

		verifyUrl(homepageUrl);
		historyArrayList.add(homepageUrl);
		historyHashSet.add(homepageUrl);
		historyHashMap.put(getExtension(homepageUrl), new ArrayList<>(Arrays.asList(homepageUrl)));
		currentIndex = 0;

	}

	private void verifyUrl(String url) throws InvalidURLException {

		boolean isValid = url.endsWith(".com") || url.endsWith(".in") || url.endsWith(".org");
		if (!isValid) {
			throw new InvalidURLException("Invalid Url extension");
		}
	}
	
	private String getExtension(String url) {
		int index = url.lastIndexOf('.');
		return url.substring(index);
	}

	public String visit(String url) throws InvalidURLException {
		verifyUrl(url);
		historyArrayList.add(url);
		historyHashSet.add(url);
		
		String extension = getExtension(url);
		if(historyHashMap.containsKey(extension)) {
			historyHashMap.get(extension).add(url);
		}
		else {
			historyHashMap.put(extension, new ArrayList<>(Arrays.asList(url)));
		}
		currentIndex++;
		return url;
	}

	public String back(int steps) throws NoHistoryFoundException {

		try {

			String url = historyArrayList.get(currentIndex - steps);
			currentIndex -= steps;
			return url;

		} catch (IndexOutOfBoundsException e) {
			throw new NoHistoryFoundException("No History Found");
		}

	}

	public String forward(int steps) throws NoHistoryFoundException {

		try {

			String url = historyArrayList.get(currentIndex + steps);
			currentIndex += steps;
			return url;

		} catch (IndexOutOfBoundsException e) {
			throw new NoHistoryFoundException("No History Found");
		}

	}

	public String get(int position) throws InvalidPositionException, IndexOutOfBoundsException {

		if (position < 0) {
			throw new InvalidPositionException("Provide only positive values");
		}

		try {

			String url = historyArrayList.get(position);
			currentIndex = position;
			return url;

		} catch (IndexOutOfBoundsException e) {
			throw new IndexOutOfBoundsException("Invalid position");
		}

	}

	//////////////////////

	public String[] sort() {

		String[] historyArray = historyArrayList.toArray(new String[0]);

		Arrays.sort(historyArray);

		return historyArray;

	}

	public void deleteHistory(int index) throws InvalidPositionException, IndexOutOfBoundsException {

		if (index < 0) {
			throw new InvalidPositionException("Provide only positive values");
		}

		try {

			String element = historyArrayList.remove(index);

			if (!historyArrayList.contains(element)) {
				historyHashSet.remove(element);
			}

		} catch (IndexOutOfBoundsException e) {

			throw new IndexOutOfBoundsException("Invalid position");
		}

	}

	public void deleteHistory(String url) throws InvalidURLException {
		verifyUrl(url);
		int index = historyArrayList.lastIndexOf(url);
		if (index < 0) {
			throw new InvalidURLException("No such url");
		}

		String element = historyArrayList.remove(index);
		if (!historyArrayList.contains(element)) {
			historyHashSet.remove(element);
		}
	}

	public String[] fetchHistory() {
		return historyArrayList.toArray(new String[0]);
	}

	public List<String> searchByExtension(String extension) throws InvalidURLException {

		verifyUrl(extension);
//		ArrayList<String> filter = new ArrayList<>();
//
//		for (String string : historyHashSet) {
//			if (string.endsWith(extension)) {
//				filter.add(string);
//			}
//		}
//
//		return filter.toArray(new String[0]);
		
		return historyHashMap.get(extension);
	}

	public int size() {
		return historyArrayList.size();
	}

	public void updateHistory(int index, String url) throws InvalidURLException, InvalidPositionException ,IndexOutOfBoundsException {
		if (index < 0) {
			throw new InvalidPositionException("Provide only positive values");
		}
		verifyUrl(url);
		try {

			String element = historyArrayList.remove(index);
			if (!historyArrayList.contains(element)) {
				historyHashSet.remove(element);
			}

			historyArrayList.set(index, url);
			historyHashSet.add(url);

		} catch (IndexOutOfBoundsException e) {
			throw new IndexOutOfBoundsException("Invalid Position");
		}

	}
	
	public void wordSearch(String word) {
		
		ArrayList<String> urlList = new ArrayList<>();
		
		for(Entry<String, ArrayList<String>> key : historyHashMap.entrySet()) {
			
		}
	}
}
