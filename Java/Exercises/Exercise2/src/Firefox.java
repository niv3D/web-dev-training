import java.util.HashSet;
import java.util.Set;

public class Firefox extends Browser implements MultipleAccountContainers {

	private Set<String> containerSet = new HashSet<>();

	Firefox(String[] historyURL) {

		super(historyURL);
	}

	Firefox() {

		super();
	}

	@Override
	public void whoAmI() {

		System.out.println("I am Firefox");
	}

	@Override
	// return boolean
	public boolean addContainer(String name) {

		return containerSet.add(name);

	}

	@Override
	public boolean leaveContainer(String name) {

		return containerSet.remove(name);
	}

	@Override
	public String[] viewAllContainers() {

		return containerSet.toArray(new String[0]);

	}
}
