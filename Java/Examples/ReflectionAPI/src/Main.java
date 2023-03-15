import java.lang.reflect.Field;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException {
		
		
		String randomString =  "abcdef";
		
		Class<? extends String> stringClass = randomString.getClass();
		
		Class<String> classObject  = String.class;
		
		System.out.println(classObject.getName());
		
		Class.forName("java.lang.String");
		
		Class<CarData> carClass = CarData.class;
		
		
		Field[] carFields = carClass.getDeclaredFields();
		
		for(Field field : carFields) {
			System.out.println(field.getName());
		}
		
		Field currentGearField = carClass.getDeclaredField("currentGear");
		
		currentGearField.setAccessible(true);
	}
		
}
