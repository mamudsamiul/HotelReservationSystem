package com.capgemini.hotelreservation.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.capgemini.hotelreservation.dto.Hotel;

public interface HotelReservationService {
	public void addHotel(Scanner scan);

	public void addHotel(String hotelName, float regularWeekdaysRate, float regularWeenendRate,float rating);

	public void showHotelList();

	public Hotel findCheapHotel(String dateRange);

	public Hotel minRate(ArrayList<Hotel> priceList);

	public int validateDate(String dateToValidate);

	public boolean validateRange(String dateRange);
}
