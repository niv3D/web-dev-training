
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import hack.Hacker;

public class BrowserHistory {

	private HashMap<String, ArrayList<String>> historyHashMap = new HashMap<>();
	private LinkedHashMap<String, ArrayList<String>> historyLinkedHashMap = new LinkedHashMap<>();
	private TreeMap<String, ArrayList<String>> historyTreeMap = new TreeMap<>();
	private ArrayList<String> historyArrayList = new ArrayList<>();

	public void visit(String url) throws InvalidUrlException {
		verifyUrl(url);
		historyArrayList.add(url);
		String key = getExtension(url);

		if (historyHashMap.containsKey(key)) {
			historyHashMap.get(key).add(url);
			historyLinkedHashMap.get(key).add(url);
			historyTreeMap.get(key).add(url);
		} else {
			historyHashMap.put(key, new ArrayList<>(Arrays.asList(url)));
			historyLinkedHashMap.put(key, new ArrayList<>(Arrays.asList(url)));
			historyTreeMap.put(key, new ArrayList<>(Arrays.asList(url)));
		}
	}

	public void deleteHistory(String extension) throws InvalidUrlException, NoHistoryFoundException {
		verifyUrl(extension);
		if (!historyHashMap.containsKey(extension)) {
			throw new NoHistoryFoundException("no history found !");
		}
		historyHashMap.remove(extension);
		historyLinkedHashMap.remove(extension);
		historyTreeMap.remove(extension);
	}

	public List<String> fetchHistory(String extension) throws InvalidUrlException, NoHistoryFoundException {
		verifyUrl(extension);
		if (!historyHashMap.containsKey(extension)) {
			throw new NoHistoryFoundException("no history found !");
		}
		return historyLinkedHashMap.get(extension);
	}

	public int size(String extension) throws InvalidUrlException, NoHistoryFoundException {
		verifyUrl(extension);
		if (!historyHashMap.containsKey(extension)) {
			throw new NoHistoryFoundException("no history found !");
		}
		return historyHashMap.get(extension).size();
	}

	public List<String> search(String keyword) {

		ArrayList<String> result = new ArrayList<>();

		for (Map.Entry<String, ArrayList<String>> entry : historyHashMap.entrySet()) {
			for (String url : entry.getValue()) {
				if (url.contains(keyword)) {
					result.add(url);
				}
			}
		}
		
		return result;
	}
	
	public void read() throws IOException {
		Hacker.readHistory(historyArrayList);
	}
	
	public void write() throws IOException {
		Hacker.writeHistory(historyArrayList);
	}
	
	public List<String> list(){
		return historyArrayList;
	}

	private String getExtension(String url) {
		int index = url.lastIndexOf('.');
		return url.substring(index);
	}

	private void verifyUrl(String url) throws InvalidUrlException {

		boolean isValid = url.endsWith(".com") || url.endsWith(".in") || url.endsWith(".org");
		if (!isValid) {
			throw new InvalidUrlException("invalid url extension !");
		}

	}

}
