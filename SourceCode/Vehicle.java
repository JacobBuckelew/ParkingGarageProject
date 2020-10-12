/*
 * The Vehicle class has a String type, ParkingSpot spot, Ticket ticket, int hoursSpent, boolean handicap,
 * and boolean attendingEvent.
 */
public class Vehicle implements updateMethods {

	private String type;
	private ParkingSpot spot;
	private Ticket ticket;
	private int hoursSpent;
	private boolean handicap;
	private boolean attendingEvent;
	
	// No Args Constructor
	public Vehicle() {
		
	}
	
	// Args Constructor with String type, int hoursSpent, boolean handicap, boolean event
	public Vehicle(String type, int hoursSpent, boolean handicap, boolean event) {
		this();
		this.type = type;
		this.hoursSpent = hoursSpent;
		this.handicap = handicap;
		this.attendingEvent = event;
	}
	
	// Getters and Setters
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ParkingSpot getSpot() {
		return spot;
	}
	public void setSpot(ParkingSpot spot) {
		this.spot = spot;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	public boolean isHandicap() {
		return handicap;
	}
	
	public void setHandicap(boolean b) {
		this.handicap = b;
	}
	
	public boolean isAttendingEvent() {
		return attendingEvent;
	}
	
	public int getHoursSpent() {
		return hoursSpent;
	}
	// updateEventStatus comes from the updateMethods interface and
	// reverts a vehicle to not attending an event in case there is an error
	// and the customer does not want to attend Event
	public void updateEventStatus() {
		attendingEvent = false;
	}
	
	// to String() prints out a vehicle using its type
	public String toString() {
		return "Type: " + getType();
	}
	
}
