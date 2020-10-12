/*
 * The ElectricSpot extends ParkingSpot and has a boolean charging
 * and String sign. 
 */
public class ElectricSpot extends ParkingSpot {
	
	private boolean charging;
	private static String sign = "Electric Car Parking Only";
	
	
	// No Args Constructor
	public ElectricSpot() {
		super();
	}
	// Args Constructor that takes an int num 
	public ElectricSpot(int num) {
		super(num);
	}

	// Getters and Setters
	
	public boolean isCharging() {
		return charging;
	}

	public String getSign() {
		return sign;
	}
	
	public void setCharging(boolean charging) {
		this.charging = charging;
	}
}
	
	
