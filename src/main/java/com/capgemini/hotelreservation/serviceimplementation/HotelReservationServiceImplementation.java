package com.capgemini.hotelreservation.serviceimplementation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.capgemini.hotelreservation.CustomerTypeException;
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
				System.out.print("Hotel Name-> " + hotel.getHotelName() + " Regular Weekdays Rate= "
						+ hotel.getRegularWeekdaysRate() + " Regular Weekend rate= " + hotel.getRegularWeekendRate()
						+ " Reward Weekdays rate= " + hotel.getRewardWeekdaysRate() + " Reward Weekend rate= "
						+ hotel.getRewardWeekendRate() + " rating= " + hotel.getRating());
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
			temp.setRating(hotel.getRating());
			priceList.add(temp);
		}
		if (!bestOrCheap) {
			List<Hotel> sortedByRate = priceList.stream().sorted(Comparator.comparing(Hotel::getRating).reversed())
					.collect(Collectors.toList());
			Hotel bestCheapHotel = sortedByRate.stream().max(
					(hotel1, hotel2) -> ((hotel1.getRegularWeekdaysRate() <= hotel2.getRegularWeekdaysRate()) ? 1 : -1))
					.get();
			return bestCheapHotel;
		} else {
			Hotel bestRatingHotel = priceList.stream()
					.max((hotel1, hotel2) -> hotel1.getRating() > hotel2.getRating() ? 1 : -1).get();
			return bestRatingHotel;
		}
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

	public boolean customerTypeInput(Scanner scan) throws CustomerTypeException {
		System.out.println("Are you a Reward Customer? (Y/N)");
		String userType = scan.next();
		if (userType.toLowerCase().equals("y"))
			return true;
		else if (userType.toLowerCase().equals("n"))
			return false;
		else
			throw new CustomerTypeException("Invalid Customer type selection");
	}
}
