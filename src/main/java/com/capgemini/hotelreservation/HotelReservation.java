package com.capgemini.hotelreservation;

import java.util.Scanner;

import com.capgemini.hotelreservation.serviceimplementation.HotelReservationServiceImplementation;

public class HotelReservation {

	public static void main(String[] args) {
		System.out.println("Welcome to the Hotel Reservation Program");
		System.out.println("========================================");
		Scanner scan = new Scanner(System.in);
		HotelReservationServiceImplementation hotelReservation = new HotelReservationServiceImplementation();
		hotelReservation.addHotel(scan);
		hotelReservation.showHotelList();
		hotelReservation.addHotel(scan);
		hotelReservation.showHotelList();
	}

}
