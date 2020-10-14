package com.capgemini.hotelreservation.dto;

public class Hotel {
	private String hotelName;
	private float regularRate;

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public float getRegularRate() {
		return regularRate;
	}

	public void setRegularRate(float regularRate) {
		this.regularRate = regularRate;
	}
}
