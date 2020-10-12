import java.util.*;

/*
 * The Kiosk class controls the garage and has static int for regularSpots,
 * motorcyclespots, electricspots, totalSpots, handicapSpots, and eventSpots. It
 * Also controls using a boolean barUp , boolean vacancy, and has a String name,
 * and Date date.
 */
public class Kiosk {
	
	private static int regularSpots = 300;
	private static int motorcycleSpots = 25;
	private static int electricSpots = 75;
	private static int totalSpots = 500;
	private static int handicapSpots = 25;
	private static int eventSpots = 75;
	private boolean barUp;
	private boolean vacancy;
	private static String name = "5-Star Parking";
	private static Date date = new Date();
	
	// No Args Constructor	
	public Kiosk() {
		this.barUp = false;
		this.vacancy = true;
	}
	// Getters and Setters
	
	public static int getRegularSpots() {
		return regularSpots;
	}

	public static void setRegularSpots(int regularSpots) {
		Kiosk.regularSpots = regularSpots;
	}

	public static int getMotorcycleSpots() {
		return motorcycleSpots;
	}

	public static void setMotorcycleSpots(int motorcycleSpots) {
		Kiosk.motorcycleSpots = motorcycleSpots;
	}

	public static int getElectricSpots() {
		return electricSpots;
	}

	public static void setElectricSpots(int electricSpots) {
		Kiosk.electricSpots = electricSpots;
	}

	public static int getTotalSpots() {
		return totalSpots;
	}

	public static void setTotalSpots(int totalSpots) {
		Kiosk.totalSpots = totalSpots;
	}

	public boolean isBarUp() {
		return barUp;
	}

	public void setBarUp(boolean barUp) {
		this.barUp = barUp;
	}

	public boolean isVacant() {
		return vacancy;
	}

	public void setVacancy(boolean vacancy) {
		this.vacancy = vacancy;
	}
	

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		Kiosk.name = name;
	}

	public static Date getDate() {
		return date;
	}

	public static void setDate(Date date) {
		Kiosk.date = date;
	}
	
	public static int getHandicapSpots() {
		return handicapSpots;
	}
	
	public static void setHandicapSpots(int handicapSpots) {
		Kiosk.handicapSpots = handicapSpots;
	}

	public static void setEventSpots(int eventSpots) {
		Kiosk.eventSpots = eventSpots;
	}

	public static int getEventSpots() {
		return eventSpots;
	}
	/*
	 * updateVacancy updates the vacancy boolean depending on the
	 * totalSpots value
	 */
	public void updateVacancy() {
		if(totalSpots == 0) {
			setVacancy(false);
		}
	}
	
	/*
	 * printGreeting() prints a greeting from the Kiosk
	 */
	public void printGreeting() {
		System.out.println("Welcome to 5-Star Parking");
	}
	
	/*
	 * payForParking returns a double, total, and takes
	 * a Vehicle as an arg. 
	 */
	public double payForParking(Vehicle vehicle) {
		
		double total = 0;
		
		Ticket ticket = vehicle.getTicket();
		if(ticket.getType().equals("1hr")) {
			total = 25.00;
		}
		else if (ticket.getType().equals("6hr")) {
			total = 50.00;
		}
		else if (ticket.getType().equals("12hr")) {
			total = 100.00;
		}
		
		if(vehicle.getType().equals("ElectricCar")) {
			ElectricCar car = (ElectricCar) vehicle;
			total = total + car.calculateFee();
		}
		
		return total;
		
	}
	
	/*
	 * printTicket takes a Vehicle as an arg and prints
	 * ticket information
	 */
	public void printTicket(Vehicle vehicle) {
		if(vacancy == false) {
			System.out.println("Sorry, 5-Star Parking is currently full");
		}
		else {
			
			if(vehicle.isAttendingEvent()) {
				if ( 0 < eventSpots && eventSpots <= 75) {
					eventSpots--;
					totalSpots--;
					System.out.println(vehicle.getTicket().toString());
				}
				else {
					System.out.println("Sorry, there are no more event spots available");
				}
			}
			else if (vehicle.isHandicap()) {
				if ( 0 < handicapSpots && handicapSpots <= 25) {
					handicapSpots--;
					totalSpots--;
					System.out.println(vehicle.getTicket().toString());
					
				}
				else {
					System.out.println("Sorry, there are no more handicap spots available");
				}
			}
			else if(vehicle.getType().equals("Motorcycle")) {
				if ( 0 < motorcycleSpots && motorcycleSpots <= 25) {
					motorcycleSpots--;
					totalSpots--;
					System.out.println(vehicle.getTicket().toString());
				}
				else {
					System.out.println("Sorry, there are no more motorcycle spots available.");
				}
			}
			else if(vehicle.getType().equals("Car")) {
				if ( 0 < regularSpots && regularSpots <= 300) {
					regularSpots--;
					totalSpots--;
					System.out.println(vehicle.getTicket().toString());
				}
				else {
					System.out.println("Sorry, there are no more car spots available.");
				}	
			}
			else if (vehicle.getType().equals("ElectricCar")) {
				if ( 0 < electricSpots && electricSpots <= 75) {
					electricSpots--;
					totalSpots--;
					System.out.println(vehicle.getTicket().toString());
				}
				else {
					System.out.println("Sorry there are no more regular spots available.");
				}
			}
		}
		System.out.println("------------------------------");
		updateVacancy();
	}
	
	/*
	 * removeVehicle() removes Vehicles using a Vehicle and an ArrayList<Vehicle> as 
	 * args
	 */
	public void removeVehicle(Vehicle vehicle, ArrayList<Vehicle> vehicles) {
		
		if(vehicle.isAttendingEvent() == true) {
			eventSpots++;
		}
		else if(vehicle.isHandicap()) {
			handicapSpots++;
		}
		else if(vehicle.getType().equals("Car")) {
			regularSpots++;
		}
		else if (vehicle.getType().equals("ElectricCar")) {
			electricSpots++;
		}
		else if (vehicle.getType().equals("Motorcycle")) {
			motorcycleSpots++;
		}
		totalSpots++;
		vehicle.getSpot().setOccupied(false);
		updateVacancy();
		
		vehicles.remove(vehicle);
		
		System.out.println("Vehicle at spot " + vehicle.getSpot().getNum() +
							" has exited the garage.");
		
	}
	
	/*
	 * toString() prints a Kiosk object as a String
	 */
	public String toString() {
		if(vacancy == false) {
			return "We are sorry to inform you that all parking spots"
					+ " are full at this moment." + "\n" + "------------------------------";
		}
		return  "Regular spots available: " + getRegularSpots() +
				"\n" + "Electric spots available: " + getElectricSpots() + "\n" + "Motorcycle spots available: " 
				+ getMotorcycleSpots() + "\n" + "Handicap spots available: " + getHandicapSpots() + "\n" +
				"Event spots available: " + getEventSpots() + "\n" + "------------------------------";
	}
	

}
