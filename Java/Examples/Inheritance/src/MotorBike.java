
public class MotorBike {
	
	protected int gear;
	protected int speed;
	
	
	public MotorBike(int initGear, int initSpeed) {
		gear = initGear;
		speed = initSpeed;
	}
	
	public void setGear(int gearPos) {
		gear = gearPos;
	}
	
	public void applyAcceleration(int acceleration) {
		speed += acceleration;
	}
	
	public void applyBrake(int deceleration) {
		speed -= deceleration;
	}
	
	public static void testClassMethod() {
		System.out.println("MotorBike");
	}
	
	
	public void testInstanceMethod() {
		System.out.println("MotorBike");
	}
}
