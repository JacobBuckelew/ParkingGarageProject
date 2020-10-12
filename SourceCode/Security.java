import java.util.ArrayList;
/*
 * The Security class contains an ArrayList<ParkingSpot> spots and checks status of parked vehicles
 */
public class Security {
	
	private ArrayList<ParkingSpot> spots;
	
	// No Args Constructor
	public Security() {
		
	}
	// Args constructor taking an ArrayList<ParkingSpot> spots, and Kiosk kiosk
	public Security(ArrayList<ParkingSpot> spots, Kiosk kiosk) {
		this();
		this.spots = spots;
	}
	
	/*
	 * checkStatuses() checks to see if a vehicle has overstayed. It takes
	 * an ArrayList<Vehicle> and a kiosk as arguments
	 */
	public void checkStatuses(ArrayList<Vehicle> vehicles, Kiosk kiosk) {
		
		int i;
		for (i = 0; i < vehicles.size() ; i++) {
			if(vehicles.get(i).getTicket().getType().equals("1hr")) {
				if(vehicles.get(i).getHoursSpent() > 1) {
					towVehicle(vehicles.get(i), vehicles, kiosk);
				}
			}
			if(vehicles.get(i).getTicket().getType().equals("6hr")) {
				if(vehicles.get(i).getHoursSpent() > 6) {
					towVehicle(vehicles.get(i), vehicles, kiosk);
				}
			}
			if(vehicles.get(i).getTicket().getType().contentEquals("12hr")) {
				if(vehicles.get(i).getHoursSpent() > 12) {
					towVehicle(vehicles.get(i), vehicles, kiosk);
				}
			}
		}
		
		
	}
	/*
	 * towVehicle will tow a vehicle if it has stayed too long. It takes a Vehicle,
	 * an ArrayList<Vehicle>, and a Kiosk as args)
	 */
	public static void towVehicle(Vehicle vehicle, ArrayList<Vehicle> vehicles, Kiosk kiosk) {
		
		if(vehicle.isAttendingEvent() == true) {
			Kiosk.setEventSpots(Kiosk.getEventSpots() + 1);
		}
		else if(vehicle.isHandicap()) {
			Kiosk.setHandicapSpots(Kiosk.getHandicapSpots() + 1);
		}
		else if(vehicle.getType().equals("Car")) {
			Kiosk.setRegularSpots(Kiosk.getRegularSpots() + 1);
		}
		else if (vehicle.getType().equals("ElectricCar")) {
			Kiosk.setElectricSpots(Kiosk.getElectricSpots() + 1);
		}
		else if (vehicle.getType().equals("Motorcycle")) {
			Kiosk.setMotorcycleSpots(Kiosk.getMotorcycleSpots() + 1);
		}
		Kiosk.setTotalSpots(Kiosk.getTotalSpots() + 1);
		vehicle.getSpot().setOccupied(false);
		kiosk.updateVacancy();
		
		vehicles.remove(vehicle);
		
		System.out.println("Vehicle at spot " + vehicle.getSpot().getNum() +
							" has been towed away from the garage.");
		
		System.out.println("------------------------------");
		
	}
}
