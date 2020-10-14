package com.capgemini.hotelreservation.serviceimplementation;

import java.util.ArrayList;
import java.util.Scanner;

import com.capgemini.hotelreservation.dto.Hotel;
import com.capgemini.hotelreservation.service.HotelReservationService;

public class HotelReservationServiceImplementation implements HotelReservationService {
	private ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
	private String hotelName;
	private int hotelPrice;

	public HotelReservationServiceImplementation() {
	}

	@Override
	public void addHotel(Scanner scan) {
		boolean flag = true;

		try {
			System.out.println("Enter the Hotel Name: ");
			this.hotelName = scan.next();
			System.out.println("Enter The price of the hotel for one day: ");
			this.hotelPrice = scan.nextInt();
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
}
