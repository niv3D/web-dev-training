
public class CarData {
	
	public final int gears;
	private int currentGear;
	private int speed;
	public String carName;
	
	
	public CarData(int gears, String carName) {
		this.gears = gears;
		this.carName = carName;
	}

	public int getCurrentGear() {
		return currentGear;
	}

	public void setCurrentGear(int currentGear) {
		this.currentGear = currentGear;
	}
	
	public String getcarName() {
		return carName;
	}
	
	private void setSpeed(int initial ,int acceleration , int duration) {
		speed = initial + acceleration * duration ; 
	}
	
}