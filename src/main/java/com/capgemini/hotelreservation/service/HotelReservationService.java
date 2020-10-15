package com.capgemini.hotelreservation.service;

import java.util.Scanner;

import com.capgemini.hotelreservation.dto.Hotel;

public interface HotelReservationService {
	public void addHotel(Scanner scan);

	public void addHotel(String hotelName, float regularWeekdaysRate, float regularWeenendRate);

	public void showHotelList();

	public Hotel findCheapHotel(String dateRange);

	public Hotel checkRate(int noOfDays);

	public boolean validateDate(String dateToValidate);

	public boolean validateRange(String dateRange);

}
