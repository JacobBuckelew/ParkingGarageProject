import java.util.*;
/*
 * The ParkingSpot class contains spots which are attributes are a boolean for occupied,
 * a boolean for reserved, a String for reservee, a boolean for handicap, an int for num,
 * and a String for type
 */
public class ParkingSpot implements updateMethods {
	
	private boolean occupied;
	private boolean reserved;
	private String reservee;
	private boolean handicap;
	private int num;
	private String type;
	
	
	// No Args Constructor
	public ParkingSpot() {
		
	}
	
	//Args Constructor taking a boolean reserved and String reservee
	public ParkingSpot(boolean reserved, String reservee) {
		this();
		this.reserved = reserved;
		this.reservee = reservee;
	}
	//Args Constructor taking a boolean handicap
	public ParkingSpot(boolean handicap) {
		this();
		this.handicap = handicap;
	}
	// Args Constructor taking an int num
	public ParkingSpot(int num) {
		this.num = num;
	}
	
	// Getters and Setters

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	public boolean isHandicap() {
		return handicap;
	}

	public void setHandicap(boolean handicap) {
		this.handicap = handicap;
	}
	
	public void setReservee(String reservee) {
		this.reservee = reservee;
	}
	
	public String getReservee(String reservee) {
		return this.reservee;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	// isEmpty() checks if a spot is empty, will return true if occupied is false
	public boolean isEmpty() {
		if(occupied = false) {
			return true;
		}
		else {
			return false;
		}
	}
	// isFull() checks an ArrayList<ParkingSpot> to determing if the collection is fully
	// occupied
	public boolean isFull(ArrayList<ParkingSpot> spots) {
		
		for(int i = 0; i < spots.size(); i++) {
			if (spots.get(i).isOccupied() == false) {
				return false;
			}
		}
		return true;
		
	}
	// updateEventStatus is from the updateMethods interfaces and is implemented
	// so that reserved status for events can be reverted back to normal.
	public void updateEventStatus() {
		this.reserved = false;
		this.reservee = null;
	}
	
	
}
