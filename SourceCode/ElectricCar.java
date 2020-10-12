/*
 * ElectricCar extends Vehicle and has an int for numHoursCharging
 */
public class ElectricCar extends Vehicle {
	
	private int numHoursCharging;
	
	// No Args Constructor
	public ElectricCar() {
		
	}
	
	// Args Constructor taking a String type, int hoursSpent, boolean handicap, boolean event, and int hours
	public ElectricCar(String type, int hoursSpent, boolean handicap, boolean event, int hours) {
		super(type, hoursSpent, handicap, event);
		numHoursCharging = hours;
	}
	// Getters and Setters
	public int getNumHoursCharging() {
		return numHoursCharging;
	}
	// calculateFee() determines fee for charging and returns a total as a double
	public double calculateFee() {
		return numHoursCharging * 4.00;
	}
	
}
