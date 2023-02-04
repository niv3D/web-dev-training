
interface Vehicle {
	void accelerate(int acceleration);

	void decelerate(int deceleration);

	void gearUp();

	void gearDown();
}

class Car implements Vehicle {

	int speed = 0;
	int gearPosition = 0;

	public void accelerate(int acceleration) {
		speed += acceleration;
	}

	public void decelerate(int deceleration) {
		if (speed == 0) {
			return;
		}
		speed -= deceleration;
	}

	public void gearUp() {
		if (gearPosition == 5) {
			return;
		}
		gearPosition++;
	}

	public void gearDown() {
		if (gearPosition == 1) {
			return;
		}
		gearPosition--;
	}

}