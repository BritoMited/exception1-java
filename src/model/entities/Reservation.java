package model.entities;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reservation {
	
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private Integer roomNumber;
	private LocalDateTime checkIn;
	private LocalDateTime checkOut;
	
	public Reservation() {
		
	}
	
	public Reservation(Integer roomNumber, LocalDateTime checkIn, LocalDateTime checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDateTime getCheckIn() {
		return checkIn;
	}

	public LocalDateTime getCheckOut() {
		return checkOut;
	}

	
	public long duration() {
		
		Duration d1 = Duration.between(checkIn, checkOut);
		// duration só funciona quando se tem os segundos para calcular
		return d1.toDays();		
		
	}
	
	public void updateDates(LocalDateTime checkIn, LocalDateTime checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Room " + roomNumber +
				", check-in: " + dtf.format(checkIn) 
				+ ", check-out: " + dtf.format(checkOut)
				+ ", " + duration() + " nights.";
	}
}
