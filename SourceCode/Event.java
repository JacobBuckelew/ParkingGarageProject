import java.util.*;
/*
 * The Event Class contains all of the information regarding events near the garage and
 * holds a String type, and an int numSpots. 
 */
public class Event {
	
	private String type;
	private int numSpots;
	
	// No Args Constructor
	public Event() {
		
	}
	
	// Args Constructor that creates an event using a String type and int numSpots
	public Event(String type, int numSpots) {
		this();
		this.type = type;
		this.numSpots = numSpots;
	}

	// Getters and Setters
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
	public int getNumSpots() {
		return numSpots;
	}
	
	/*
	 * setEventSpots() sets certain spots in an ArrayList<ParkingSpot>
	 * to be reserved for events.
	 */
	public void setEventSpots(ArrayList<ParkingSpot> spots) {
		
		int i;
		for (i = 25; i < this.getNumSpots() + 25; i++) {
			spots.get(i).setReserved(true);
			spots.get(i).setReservee(this.getType() + " parking only");
		}
	}


}
