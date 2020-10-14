package com.capgemini.hotelreservation.service;

import java.util.Scanner;

import com.capgemini.hotelreservation.dto.Hotel;

public interface HotelReservationService {
	public void addHotel(Scanner scan);

	public void addHotel(String hotelName, float hotelRate);

	public void showHotelList();
	
	public Hotel findCheapHotel(String dateRange);
	
	public Hotel checkRate(int noOfDays);

}
