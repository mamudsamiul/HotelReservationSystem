package com.capgemini.hotelreservation.serviceimplementation;

import java.util.ArrayList;
import java.util.Scanner;

import com.capgemini.hotelreservation.dto.Hotel;
import com.capgemini.hotelreservation.service.HotelReservationService;

public class HotelReservationServiceImplementation implements HotelReservationService {
	private ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
	private String hotelName;
	private double hotelPrice;

	public HotelReservationServiceImplementation() {
	}

	@Override
	public void addHotel(Scanner scan) {
		boolean flag = true;

		try {
			System.out.println("Enter the Hotel Name: ");
			this.hotelName = scan.next();
			System.out.println("Enter The price of the hotel for one day: ");
			this.hotelPrice = scan.nextDouble();
		} catch (Exception e) {
			System.out.println("Invalid Input type!");
			flag = false;
		}
		if (flag) {
			Hotel hotel = new Hotel();
			hotel.setHotelName(hotelName);
			hotel.setRegularRate(hotelPrice);
			hotelList.add(hotel);
			System.out.println("Hotel Added Sucessfully!");
		} else
			System.out.println("SORRY!! Unable to add hotel in the dictionary!!");

	}

	@Override
	public void addHotel(String hotelName, float hotelRate) {
		Hotel hotel = new Hotel();
		hotel.setHotelName(hotelName);
		hotel.setRegularRate(hotelRate);
		hotelList.add(hotel);
	}

	public ArrayList<Hotel> getHotelList() {
		return hotelList;
	}

	public void setHotelList(ArrayList<Hotel> hotelList) {
		this.hotelList = hotelList;
	}

	@Override
	public void showHotelList() {
		System.out.println("=======List Of Hotels Are========");
		if (hotelList.size() == 0)
			System.out.println("Empty!!");
		else {
			for (Hotel hotel : hotelList) {
				System.out.print("Hotel Name-> " + hotel.getHotelName() + " Rate= " + hotel.getRegularRate());
				System.out.println();
			}
		}
	}

	@Override
	public Hotel findCheapHotel(String dateRange) {
		int counter = 0;
		String[] words = dateRange.toLowerCase().split(",");
		counter = words.length;
		return checkRate(counter);
	}

	@Override
	public Hotel checkRate(int noOfDays) {
		Hotel name;
		Double minPrice = hotelList.get(0).getRegularRate();
		name = hotelList.get(0);
		name.setRegularRate(minPrice * noOfDays);
		for (Hotel hotel : hotelList) {
			if (hotel.getRegularRate() < minPrice) {
				minPrice = hotel.getRegularRate();
				name.setHotelName(hotel.getHotelName());
				name.setRegularRate(hotel.getRegularRate() * noOfDays);
			}
		}
		return name;
	}
}
