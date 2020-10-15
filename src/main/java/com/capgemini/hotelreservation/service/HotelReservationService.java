package com.capgemini.hotelreservation.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.capgemini.hotelreservation.dto.Hotel;

public interface HotelReservationService {
	public void addHotel(Scanner scan);

	public void addHotel(String hotelName, double regularWeekdaysRate, double regularWeenendRate, double rating,
			double rewardWeekdayRate, double rewardWeekendRate);

	public void showHotelList();

	public Hotel findCheapHotel(String dateRange, boolean type, boolean bestOrCheap);

	public ArrayList<Hotel> minRate(ArrayList<Hotel> priceList);

	public int validateDate(String dateToValidate);

	public boolean validateRange(String dateRange);

	public boolean customerTypeInput(Scanner scan);
}
