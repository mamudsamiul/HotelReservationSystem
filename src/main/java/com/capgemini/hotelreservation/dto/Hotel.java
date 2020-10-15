package com.capgemini.hotelreservation.dto;

public class Hotel {
	private String hotelName;
	private double regularWeekdaysRate;
	private double regularWeekendRate;

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public double getRegularWeekdaysRate() {
		return regularWeekdaysRate;
	}

	public void setRegularWeekdaysRate(double regularWeekdaysRate) {
		this.regularWeekdaysRate = regularWeekdaysRate;
	}

	public double getRegularWeekendRate() {
		return regularWeekendRate;
	}

	public void setRegularWeekendRate(double regularWeekendRate) {
		this.regularWeekendRate = regularWeekendRate;
	}
}
