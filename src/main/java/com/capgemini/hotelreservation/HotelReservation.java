package com.capgemini.hotelreservation;

import java.util.Scanner;

import com.capgemini.hotelreservation.dto.Hotel;
import com.capgemini.hotelreservation.serviceimplementation.HotelReservationServiceImplementation;

public class HotelReservation {

	public static void main(String[] args) {
		System.out.println("Welcome to the Hotel Reservation Program");
		System.out.println("========================================");
		Scanner scan = new Scanner(System.in);
		HotelReservationServiceImplementation hotelReservation = new HotelReservationServiceImplementation();
		hotelReservation.addHotel("Bridegwood", 160, 110, 4, 60, 50);
		hotelReservation.addHotel("Lakewood", 110, 80, 3, 90, 80);
		hotelReservation.addHotel("Ridgewood", 220, 100, 5, 150, 40);
		hotelReservation.showHotelList();
		System.out.println("Enter the date Range in '16Mar2020,17Mar2020' this format");
		String dateRange = scan.next();
		boolean type = hotelReservation.customerTypeInput(scan);
		boolean bestOrCheap = mainMenu(scan);
		if (hotelReservation.validateRange(dateRange)) {
			Hotel bestHotel = hotelReservation.findCheapHotel(dateRange, type, bestOrCheap);
			System.out.println(bestHotel.getHotelName() + ", Total Rates $" + bestHotel.getRegularWeekdaysRate()
					+ " Rating: " + bestHotel.getRating());
		}
	}

	public static boolean mainMenu(Scanner scan) {
		System.out.println("Do you want Best Rated hotel? (Y/N)");
		String input = scan.next();
		if (input.toLowerCase().equals("y"))
			return true;
		else
			return false;
	}
}
