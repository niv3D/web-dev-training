import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileHandlingMain {

	public static void main(String[] args) throws IOException {
		
		String textFileString = "textFile.txt";
		
		File textFile = new File(textFileString);
		
		if(textFile.createNewFile()) {
			System.out.println("created" + textFileString );
		}else {
			System.out.println("no file created !");
		}

		String textString = "abcdefgh";
		
		byte[] byteArray = textString.getBytes();
		
		try(FileOutputStream fileOutputStream = new FileOutputStream(textFile)) {
			
			fileOutputStream.write(byteArray);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
