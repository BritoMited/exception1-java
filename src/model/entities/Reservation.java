package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.exceptions.DomainException;

public class Reservation {
	
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	public Reservation() {
		
	}
	
	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
		if (!checkOut.isAfter(checkIn)){
			throw new DomainException("O check-out deve ser depois da data de check-in.");
		}
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

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	
	public int duration() {
		return checkOut.compareTo(checkIn);		
		
	}
	
	public void updateDates(LocalDate checkIn, LocalDate checkOut) {

		LocalDate now = LocalDate.now();

		if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
			throw new DomainException("A data de atualização da reserva devem ser datas futuras.") ;
		}if (!checkOut.isAfter(checkIn)){
			throw new DomainException("O check-out deve ser depois da data de check-in.");
		}             // erro no argumento
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
