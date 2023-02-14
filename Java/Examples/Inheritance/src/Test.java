
public class Test {

	public static void main(String[] args) {
		
		AdventureBike advBike = new AdventureBike(1, 0);
		advBike.testClassMethod();
		
		MotorBike bike = new MotorBike(1, 0);
		bike.testClassMethod();
		
		
		AdventureBike.testClassMethod();
		
		MotorBike.testClassMethod();
		
		
		advBike.testInstanceMethod();
		
		bike.testInstanceMethod();
	
		
		MotorBike newBike = advBike;
		
		newBike.testClassMethod();
		
		newBike.testInstanceMethod();
		
	}

}
