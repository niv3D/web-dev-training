package hack;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Hacker {

	private Hacker() {
	}

	private static Path getFile() throws IOException {
		
		Path filePath = Paths.get("/History.txt");

		if (Files.notExists(filePath)) {
			try {
				Files.createFile(filePath);
			} catch (IOException e) {
				throw new IOException("unable to create History.txt");
			}
		}
		
		return filePath;
	}

	public static void writeHistory(List<String> urlList) throws IOException {
		
		Path filePath = getFile();
		
		try {
			Files.write(filePath, urlList, StandardCharsets.UTF_8);
		} catch (IOException e) {
			throw new IOException("unable to write on History.txt");
		}
		
	}

	public static void readHistory(List<String> urlList) throws IOException {
		
		Path filePath = getFile();
		List<String> inputHistoryList;
		
		try {
		 inputHistoryList = Files.readAllLines(filePath,StandardCharsets.UTF_8);
		} catch (IOException e) {
			throw new IOException("unable to read from history.txt");
		}
		
		urlList.retainAll(inputHistoryList);
		
	}

}