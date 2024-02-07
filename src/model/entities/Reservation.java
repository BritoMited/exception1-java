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
	
	public String updateDates(LocalDateTime checkIn, LocalDateTime checkOut) {

		LocalDateTime now = LocalDateTime.now();

		if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
			return "A data de atualização da reserva devem ser datas futuras.";
		}if (!checkOut.isAfter(checkIn)){
			return "O check-out deve ser depois da data de check-in.";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		return null; // criterio para msotrar que nao houve nenhum erro
	}
	
	@Override
	public String toString() {
		return "Room " + roomNumber +
				", check-in: " + dtf.format(checkIn) 
				+ ", check-out: " + dtf.format(checkOut)
				+ ", " + duration() + " nights.";
	}
}
