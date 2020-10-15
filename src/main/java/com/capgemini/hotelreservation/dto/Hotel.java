package com.capgemini.hotelreservation.dto;

public class Hotel {
	private String hotelName;
	private double regularWeekdaysRate;
	private double regularWeekendRate;
	private double rewardWeekdaysRate;
	private double rewardWeekendRate;
	private double rating;

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

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public double getRewardWeekdaysRate() {
		return rewardWeekdaysRate;
	}

	public void setRewardWeekdaysRate(double rewardWeekdaysRate) {
		this.rewardWeekdaysRate = rewardWeekdaysRate;
	}

	public double getRewardWeekendRate() {
		return rewardWeekendRate;
	}

	public void setRewardWeekendRate(double rewardWeekendRate) {
		this.rewardWeekendRate = rewardWeekendRate;
	}
}
