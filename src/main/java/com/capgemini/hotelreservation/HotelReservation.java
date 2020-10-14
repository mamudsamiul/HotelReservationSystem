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
		hotelReservation.addHotel("avc", 123);
		hotelReservation.addHotel("xyz", 234);
		hotelReservation.showHotelList();
		System.out.println("Enter the date Range in '16Mar2020,17Mar2020' this format");
		String dateRange = scan.next();
		Hotel bestHotel = hotelReservation.findCheapHotel(dateRange);
		System.out.println(bestHotel.getHotelName() + ", Total Rates $" + bestHotel.getRegularRate());

	}

}
