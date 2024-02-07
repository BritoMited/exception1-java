package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		// só é possivel ler os segundos do localdatetime quando se tem o nextline
		// apenas o next nao funciona

		System.out.print("Numero do quarto: ");
		int roomNumber = sc.nextInt();
		sc.nextLine();

		System.out.println("data do check-in (dd/MM/yyyy HH:mm:ss): ");
		String dataCheckIn = sc.nextLine();

		LocalDateTime localDataCheckIn = LocalDateTime.parse(dataCheckIn, dtf);

		System.out.println("data do check-out (dd/MM/yyyy HH:mm:ss): ");
		String dataCheckOut = sc.nextLine();

		LocalDateTime localDataCheckOut = LocalDateTime.parse(dataCheckOut, dtf);

		if (!localDataCheckOut.isAfter(localDataCheckIn)) {
			System.out.println("Erro na sua reserva. O check-out deve ser depois da data de check-in.");
		} else {
			Reservation reservation = new Reservation(roomNumber, localDataCheckIn, localDataCheckOut);
			System.out.println("Reserva: " + reservation);

			System.out.println();
			System.out.println("Informe a data atualizada da reserva: ");

			System.out.println("data do check-in (dd/MM/yyyy HH:mm:ss): ");
			dataCheckIn = sc.nextLine();

			localDataCheckIn = LocalDateTime.parse(dataCheckIn, dtf);

			System.out.println("data do check-out (dd/MM/yyyy HH:mm:ss): ");
			dataCheckOut = sc.nextLine();

			localDataCheckOut = LocalDateTime.parse(dataCheckOut, dtf);

			LocalDateTime now = LocalDateTime.now();

			
			if (localDataCheckIn.isBefore(now) || localDataCheckOut.isBefore(now)) {
				System.out.println("Erro na reserva: A data de atualização da reserva devem ser datas futuras.");
			
			}else if (!localDataCheckOut.isAfter(localDataCheckIn)){
			          // se a data de checkout nao for depois da data de checkin
				System.out.println("Erro na sua reserva. O check-out deve ser depois da data de check-in.");
			
			}else {
				reservation.updateDates(localDataCheckIn, localDataCheckOut);
				System.out.println("Reserva: " + reservation);
			
			}
		}

		sc.close();
	}

}
