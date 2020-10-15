package com.capgemini.hotelreservation.serviceimplementation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.capgemini.hotelreservation.dto.Hotel;
import com.capgemini.hotelreservation.service.HotelReservationService;

public class HotelReservationServiceImplementation implements HotelReservationService {
	private ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
	private String hotelName;
	private double regularWeekdaysRate;
	private double regularWeekendRate;

	public HotelReservationServiceImplementation() {
	}

	@Override
	public void addHotel(Scanner scan) {
		boolean flag = true;

		try {
			System.out.println("Enter the Hotel Name: ");
			this.hotelName = scan.next();
			System.out.println("Enter The price of the hotel for one day: ");
			this.regularWeekdaysRate = scan.nextDouble();
		} catch (Exception e) {
			System.out.println("Invalid Input type!");
			flag = false;
		}
		if (flag) {
			Hotel hotel = new Hotel();
			hotel.setHotelName(hotelName);
			hotel.setRegularWeekdaysRate(regularWeekdaysRate);
			hotelList.add(hotel);
			System.out.println("Hotel Added Sucessfully!");
		} else
			System.out.println("SORRY!! Unable to add hotel in the dictionary!!");

	}

	@Override
	public void addHotel(String hotelName, double regularWeekdaysRate, double regularWeekendRate, double rating,
			double rewardWeekdayRate, double rewardWeekendRate) {
		Hotel hotel = new Hotel();
		hotel.setHotelName(hotelName);
		hotel.setRegularWeekdaysRate(regularWeekdaysRate);
		hotel.setRegularWeekendRate(regularWeekendRate);
		hotel.setRewardWeekdaysRate(rewardWeekdayRate);
		hotel.setRewardWeekendRate(rewardWeekendRate);
		hotel.setRating(rating);
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
				System.out.print(
						"Hotel Name-> " + hotel.getHotelName() + " Weekdays Rate= " + hotel.getRegularWeekdaysRate()
								+ " Weekend rate= " + hotel.getRegularWeekendRate() + " rating= " + hotel.getRating());
				System.out.println();
			}
		}
	}

	@Override
	public Hotel findCheapHotel(String dateRange, boolean type, boolean bestOrCheap) {
		int counter = 0;
		String[] words = dateRange.split(",");
		ArrayList<Hotel> priceList = new ArrayList<Hotel>();
		for (Hotel hotel : hotelList) {
			double price = 0;
			Hotel temp = hotel;
			for (String word : words) {
				int day = validateDate(word);
				if (day == 0 || day == 6) {
					if (!type)
						price += hotel.getRegularWeekendRate();
					else
						price += hotel.getRewardWeekendRate();
				} else {
					if (!type)
						price += hotel.getRegularWeekdaysRate();
					else
						price += hotel.getRewardWeekdaysRate();
				}
			}
			temp.setHotelName(hotel.getHotelName());
			temp.setRegularWeekdaysRate(price);
			priceList.add(temp);
		}
		if (!bestOrCheap) {
			ArrayList<Hotel> sameRate = minRate(priceList);
			if (sameRate.size() == 1)
				return sameRate.get(0);
			else {
				return maxRatingHotel(sameRate);
			}
		} else {
			return maxRatingHotel(priceList);
		}

	}

	private Hotel maxRatingHotel(ArrayList<Hotel> list) {
		double maxRating = list.get(0).getRating();
		Hotel bestHotel = list.get(0);
		for (Hotel hotel : list) {
			if (hotel.getRating() > maxRating) {
				maxRating = hotel.getRating();
				bestHotel = hotel;
			}
		}
		return bestHotel;
	}

	@Override
	public ArrayList<Hotel> minRate(ArrayList<Hotel> priceList) {
		Hotel name;
		ArrayList<Hotel> samePrice = new ArrayList<>();
		Double minPrice = priceList.get(0).getRegularWeekdaysRate();
		name = priceList.get(0);
		name.setRegularWeekdaysRate(minPrice);
		samePrice.add(name);
		for (Hotel hotel : priceList) {
			if (hotel.getRegularWeekdaysRate() <= minPrice) {
				if (hotel.getRegularWeekdaysRate() < minPrice) {
					samePrice.clear();
					minPrice = hotel.getRegularWeekdaysRate();
					name.setHotelName(hotel.getHotelName());
					name.setRegularWeekdaysRate(hotel.getRegularWeekdaysRate());

				}
				samePrice.add(name);
			}
		}
		return samePrice;
	}

	@Override
	public int validateDate(String dateToValidate) {
		String dateFromat = "ddMMMyyyy";
		if (dateToValidate == null) {
			return -1;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
		sdf.setLenient(false);
		Date date;

		try {
			date = sdf.parse(dateToValidate);

		} catch (ParseException e) {
			System.out.println("Invalid Date Entry!!");
			return -1;
		}

		return date.getDay();
	}

	@Override
	public boolean validateRange(String dateRange) {
		String[] dates = dateRange.split(",");
		for (String date : dates) {
			if (validateDate(date) < 0)
				return false;
		}
		return true;
	}

	@Override
	public boolean customerTypeInput(Scanner scan) {
		System.out.println("Are you a Reward Customer? (Y/N)");
		String userType = scan.next();
		if (userType.toLowerCase().equals("y"))
			return true;
		else
			return false;
	}
}
