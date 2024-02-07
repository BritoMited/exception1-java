package application;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		// só é possivel ler os segundos do localdatetime quando se tem o nextline
		// apenas o next nao funciona
		
		
		try {
			System.out.print("Numero do quarto: ");
			int roomNumber = sc.nextInt();
			sc.nextLine();
	
			System.out.println("data do check-in (dd/MM/yyyy HH:mm:ss): ");
			String dataCheckIn = sc.nextLine();
			LocalDate localDataCheckIn = LocalDate.parse(dataCheckIn, dtf);
			System.out.println("data do check-out (dd/MM/yyyy HH:mm:ss): ");
			String dataCheckOut = sc.nextLine();
			LocalDate localDataCheckOut = LocalDate.parse(dataCheckOut, dtf);
			
			Reservation reservation = new Reservation(roomNumber, localDataCheckIn, localDataCheckOut);
			System.out.println("Reserva: " + reservation);
	
			System.out.println();
			System.out.println("Informe a data atualizada da reserva: ");
			System.out.println("data do check-in (dd/MM/yyyy HH:mm:ss): ");
			dataCheckIn = sc.nextLine();
			localDataCheckIn = LocalDate.parse(dataCheckIn, dtf);
			System.out.println("data do check-out (dd/MM/yyyy HH:mm:ss): ");
			dataCheckOut = sc.nextLine();
			localDataCheckOut = LocalDate.parse(dataCheckOut, dtf);
			
			// delegação de serviço para a classe reservation
			
			reservation.updateDates(localDataCheckIn, localDataCheckOut);
			System.out.println("Reserva: " + reservation);	
		}
		catch (DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch (DateTimeParseException e) {
			System.out.println("Formato de data inválido");
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado");
		}
		sc.close();
	}

}
