import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, NoSuchMethodException {

		String randomString = "abcdef";

		CarData newCarData = new CarData(5, randomString);

		Class<? extends String> stringClass = randomString.getClass();

		Class<String> classObject = String.class;

		System.out.println(classObject.getName());

		Class.forName("java.lang.String");

		Class<CarData> carClass = CarData.class;

		Field[] carFields = carClass.getDeclaredFields();

		for (Field field : carFields) {
			System.out.println(field.getName());
		}

		Field currentGearField = carClass.getDeclaredField("currentGear");

		currentGearField.setAccessible(true);

		try {
			currentGearField.set(newCarData, 10);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		System.out.println("/////////////");
		
		Constructor<?>[] carConstructor = carClass.getConstructors();
		
		for (Constructor<?> constructor : carConstructor) {
			
		
		   Type[] types = constructor.getGenericParameterTypes(); 
		   
		  Parameter[] parameters = constructor.getParameters();
		   
		  for(int i = 0 ; i < parameters.length ; i++) {
			  
			  System.out.println(parameters[i].getName() + ' ' + types[i].getTypeName());
			  
		  }
		
		}
	
		
		
	}

}
