import java.util.HashMap;

public class Clothing {

	private static HashMap<String, Clothing> clothingMap = new HashMap<>();

	private String clothingName;
	private int clothingCount;

	public Clothing(String name) {

		this.clothingName = name;
		clothingMap.put(name, this);

	}

}
