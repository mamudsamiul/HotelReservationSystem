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
		hotelReservation.addHotel("Bridegwood", 150, 50,3);
		hotelReservation.addHotel("Lakewood", 220, 150,4);
		hotelReservation.showHotelList();
		System.out.println("Enter the date Range in '16Mar2020,17Mar2020' this format");
		String dateRange = scan.next();
		if (hotelReservation.validateRange(dateRange)) {
			Hotel bestHotel = hotelReservation.findCheapHotel(dateRange);
			System.out.println(bestHotel.getHotelName() + ", Total Rates $" + bestHotel.getRegularWeekdaysRate());
		}
	}
}
