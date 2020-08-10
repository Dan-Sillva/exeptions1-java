package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exeptions.DomainExeptions;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Room Number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/mm/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date(dd/mm/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
	
			Reservation reserva = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reserva.toString());
	
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date(dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			reserva.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reserva.toString());
		
		} catch (ParseException e) {
			System.out.println("Invalid date format");
		} catch (DomainExeptions e) {
			System.out.println("Error"+ e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error!");
		}
	}

}
