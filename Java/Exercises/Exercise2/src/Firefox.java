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
	public void addContainer(String name) {

		if (!containerSet.contains(name)) {

			containerSet.add(name);
			return;
		}

		System.out.println("Container already exist !");

	}

	@Override
	public void leaveContainer(String name) {

		if (containerSet.contains(name)) {

			containerSet.remove(name);
			return;
		}

		System.out.println("Container : " + name + " do not exist");

	}

	@Override
	public String[] viewAllContainers() {

		return containerSet.toArray(new String[0]);

	}
}
