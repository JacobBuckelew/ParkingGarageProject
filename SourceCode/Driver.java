import java.util.*;
import java.io.*;

/*
 * The Driver class runs the main program for the Parking Garage project.
 * Jacob Buckelew, Ryan King, Cameron Reeves
 * Parking Garage Project
 * CMS 270
 * 
 */
public class Driver {
	
	/*
	 * The generateParkingSpots() method takes no args and returns an ArrayList<ParkingSpot>
	 * by generating a new parking lot including normal spots and electric spots
	 */
	public static ArrayList<ParkingSpot> generateParkingSpots() {
		
		ArrayList<ParkingSpot> parkingSpots =  new ArrayList<ParkingSpot>();
		int i;
		for ( i = 0; i < 425; i++) {
			parkingSpots.add(new ParkingSpot(i));
			if(i < 25) {
				parkingSpots.get(i).setHandicap(true);
			}
			else if (i < 100) {
				parkingSpots.get(i).setReserved(true);
			}
			else if( i < 400) {
				parkingSpots.get(i).setType("Car");
			}
			else if (i < 425) {
				parkingSpots.get(i).setType("Motorcycle");
			}
		}
		ArrayList<ElectricSpot> electricSpots = new ArrayList<ElectricSpot>();
		for ( i = 0; i < 75; i++) {
			electricSpots.add(new ElectricSpot());
			electricSpots.get(i).setType("Electric Car");
		}
		parkingSpots.addAll(electricSpots);
		return parkingSpots;		
	}
	
	/*
	 * registerVehicles() takes an ArrayList<ParkingSpot> and a Kiosk as args and returns an ArrayList<Vehicle>
	 * to be used as a collection of all vehicles in the system
	 */
	public static ArrayList<Vehicle> registerVehicles(ArrayList<ParkingSpot> lot, Kiosk kiosk) {
		
		ArrayList<Vehicle> vehicles = new ArrayList<>();
		
		try {
		File vehicleText = new File("Vehicles.txt");
		Scanner scan = new Scanner(vehicleText);
		
		while(scan.hasNextLine() && kiosk.isVacant() != false) {
			String name = scan.next() + " " + scan.next();
			String type = scan.next();
			if(type.equals("Car")) {
				Vehicle vehicle = new Vehicle(type, scan.nextInt(), scan.nextBoolean(), scan.nextBoolean());
				Ticket ticket = new Ticket(name, scan.next(), scan.nextLong());
				vehicle.setTicket(ticket);
				vehicles.add(vehicle);
			}
			if(type.equals("ElectricCar")) {
				ElectricCar electric = new ElectricCar(type, scan.nextInt(), scan.nextBoolean(),scan.nextBoolean(), scan.nextInt());
				Ticket ticket = new Ticket(name, scan.next(), scan.nextLong());
				electric.setTicket(ticket);
				vehicles.add(electric);
			}
			if (type.equals("Motorcycle")) {
				Vehicle motorcycle = new Vehicle(type, scan.nextInt(), scan.nextBoolean(), scan.nextBoolean());
				Ticket ticket = new Ticket(name, scan.next(), scan.nextLong());
				motorcycle.setTicket(ticket);
				vehicles.add(motorcycle);
			}
		}
		scan.close();
		}
		catch (Exception FileNotFoundException) {
			System.out.println("file not found.");
			
		}
		return vehicles;
	}
	
	/*
	 * fillpots() takes an ArrayList<Vehicle>, ArrayList<ParkingSpot>, and a Kiosk as args and then
	 * assigns each spot to a vehicle since each vehicle "has" a spot.
	 */
	public static void fillSpots(ArrayList<Vehicle> vehicles, ArrayList<ParkingSpot> spots, Kiosk kiosk) {
		
		int count1 = 0;
		int count2 = 25;
		int count3 = 100;
		int count4 = 400;
		int count5 = 425;
		
		int i;
		
		for (i = 0; i < vehicles.size(); i++) {
			kiosk.setBarUp(false);
			String type = vehicles.get(i).getType();
			if( vehicles.get(i).isAttendingEvent()) {
				vehicles.get(i).setSpot(spots.get(count2));
				count2++;
			}
			else if (type.equals("Handicap")) {
				vehicles.get(i).setSpot(spots.get(count1));
				count1++;
			}
			else if (type.equals("Car")) {
				vehicles.get(i).setSpot(spots.get(count3));
				count3++;
			}
			else if (type.equals("Motorcycle")) {
				vehicles.get(i).setSpot(spots.get(count4));
				count4++;
			}
			else if (type.equals("ElectricCar")) {
				vehicles.get(i).setSpot(spots.get(count5));
			}
			
			vehicles.get(i).getTicket().setSpotNum(vehicles.get(i).getSpot().getNum());
			vehicles.get(i).getSpot().setOccupied(true);
			kiosk.printTicket(vehicles.get(i));
			kiosk.setBarUp(true);
			
		}
		
		
	}
	
	/*
	 * pay takes a Vehicle, ArrayList<Vehicle>, and Kiosk to allow a customer to pay. This
	 * also includes removing a vehicle from the garage.
	 */
	
	public static void pay(Vehicle vehicle, ArrayList<Vehicle> vehicles, Kiosk kiosk) {
		
		double total = kiosk.payForParking(vehicle);
		System.out.println("Your total is " + total + "\n" + "Your card will be charged"
							+ " the appropriate amount.");
		kiosk.setBarUp(true);
		System.out.println("You may now exit. Have a nice day.");
		kiosk.setBarUp(false);
		kiosk.removeVehicle(vehicle, vehicles);
		
		System.out.println("------------------------------");
	
	}
	
	/*
	 * The main() function is where the ParkingSpots will be instantiated and
	 * different test cases will be ran to show how the garage system functions.
	 */
	public static void main(String[] args) {
	
		Kiosk kiosk = new Kiosk();
		kiosk.printGreeting();
		System.out.println(kiosk.toString());
		
		ArrayList<ParkingSpot> defaultLot = generateParkingSpots();
		Event UFC = new Event("Sporting Event", 75);
		UFC.setEventSpots(defaultLot);
		
		ArrayList<Vehicle> vehicles = registerVehicles(defaultLot, kiosk);
		fillSpots(vehicles, defaultLot, kiosk);
		
		Security security = new Security(defaultLot, kiosk);
		security.checkStatuses(vehicles, kiosk);
		System.out.println(kiosk.toString());
		
		pay(vehicles.get(1), vehicles, kiosk);
		System.out.println(kiosk.toString());
		
		pay(vehicles.get(0), vehicles, kiosk);
		pay(vehicles.get(0), vehicles, kiosk);
		System.out.println(kiosk.toString());
		
	
	
	
	}
}
