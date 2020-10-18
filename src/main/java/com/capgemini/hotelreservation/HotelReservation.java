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
		hotelReservation.addHotel("Bridegwood", 150, 50, 4, 110, 50);
		hotelReservation.addHotel("Lakewood", 110, 90, 3, 80, 80);
		hotelReservation.addHotel("Ridgewood", 220, 150, 5, 100, 40);
		hotelReservation.showHotelList();
		while (true) {
			System.out.println("=====================================================================================");
			System.out.println("");
			System.out.println("Enter the dates : Example 12Oct2020,13Oct2020");
			String dateRange = scan.next();
			try {
				boolean type = hotelReservation.customerTypeInput(scan);
				boolean bestOrCheap = mainMenu(scan);
				if (hotelReservation.validateRange(dateRange)) {
					Hotel bestHotel = hotelReservation.findCheapHotel(dateRange, type, bestOrCheap);
					System.out.println(bestHotel.getHotelName() + ", Total Rates $" + bestHotel.getRegularWeekdaysRate()
							+ " Rating: " + bestHotel.getRating());
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static boolean mainMenu(Scanner scan) throws BestOrCheapException {
		System.out.println("Do you want Best Rated hotel? (Y/N)");
		String input = scan.next();
		if (input.toLowerCase().equals("y"))
			return true;
		else if (input.toLowerCase().equals("n"))
			return false;
		else
			throw new BestOrCheapException("Invalid Hotel filter selection");
	}
}
