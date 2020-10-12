
import java.util.*;
import java.time.*;
import java.time.temporal.*;
import java.time.format.*;

/*
 * The Ticket class has a String name, LocalDate date, LocalTime entryTime, String type, LocalTime exitTime,
 * long cardNum, and int spotNum.
 */

public class Ticket {

	private String name;
	private LocalDate date;
	private LocalTime entryTime;
	private String type;
	private LocalTime exitTime;
	private long cardNum;
	private int spotNum;
	
		
	// Args constructor taking String n, String type, and long cardNum	
	public Ticket(String n, String type, long cardNum) {
		name = n;
		this.cardNum = cardNum;
		date = LocalDate.now();
		entryTime = LocalTime.now().truncatedTo(ChronoUnit.MINUTES);
		this.type = type;
		if(type.equals("12hr")) {
			exitTime = entryTime.plus(12, ChronoUnit.HOURS);
			exitTime = exitTime.truncatedTo(ChronoUnit.MINUTES);
		}
		else if(type.equals("6hr")) {
			exitTime = entryTime.plus(6, ChronoUnit.HOURS);
			exitTime = exitTime.truncatedTo(ChronoUnit.MINUTES);
		}
		else {
			exitTime = entryTime.plus(1, ChronoUnit.HOURS);
			exitTime = exitTime.truncatedTo(ChronoUnit.MINUTES);
		}
	}


	// Getters and Setters
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public LocalDate getDate() {
		return date;
	}



	public void setDate(LocalDate date) {
		this.date = date;
	}



	public LocalTime getEntryTime() {
		return entryTime;
	}



	public void setEntryTime(LocalTime entryTime) {
		this.entryTime = entryTime;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public LocalTime getExitTime() {
		return exitTime;
	}



	public void setExitTime(LocalTime exitTime) {
		this.exitTime = exitTime;
	}
	
	public int getSpotNum() {
		return spotNum;
	}
	
	public void setSpotNum(int num) {
		spotNum = num;
	}

	// toString() prints a Ticket using name, date, type, entrytime, spotnum, and exittime
	public String toString() {
		return "Name: " + getName() + "\n" + "Date: " +
				getDate() + "\n" + "Ticket: " + getType() +
				"\n" + "Entry Time: " + getEntryTime() + "\n" +
				"Spot Number: " + getSpotNum() + "\n" +
				"If your vehicle is here past " + getExitTime() +
				", Security will have to remove your vehicle from "
				+ "the garage.";
	}
}
