
public class AdventureBike extends MotorBike{
	
	private int seatHeight;
	
	public AdventureBike(int gear ,int speed) {
		super(gear, speed);
	}
	
	public void setSeatHeight(int newSeatHeight) {
		seatHeight = newSeatHeight;
	}
	
	public void setHeight(int newHeight) {
		seatHeight = newHeight;
		this.gear = 0;
	}
	
	

}
