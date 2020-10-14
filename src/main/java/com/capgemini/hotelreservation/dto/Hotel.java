package com.capgemini.hotelreservation.dto;

public class Hotel {
	private String hotelName;
	private double regularRate;

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public double getRegularRate() {
		return regularRate;
	}

	public void setRegularRate(double regularRate) {
		this.regularRate = regularRate;
	}
}
