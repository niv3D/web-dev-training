package hack;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Hacker {

	private Hacker() {
	}

	private static Path getFile() throws IOException {
		
		Path filePath = Paths.get("History.txt");
		
		if (Files.notExists(filePath)) {
			try {
				//Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("rw-rw-rw-");
				//FileAttribute<Set<PosixFilePermission>> attributes = PosixFilePermissions.asFileAttribute(permissions);
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
		
		urlList.clear();
		urlList.addAll(inputHistoryList);
		
	}

}