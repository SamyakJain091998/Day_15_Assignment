package com.hotel_reservation_system.assignment;

public class Hotels {

	private String hotelName;
	private int hotelRating;
	private int hotelRateRegularWeekDay;
	private int hotelRateRegularWeekEnd;
	private int hotelRateRewardWeekDay;
	private int hotelRateRewardWeekEnd;

	public Hotels(String hotelName, int hotelRating, int hotelRateRegularWeekDay, int hotelRateRegularWeekEnd,
			int hotelRateRewardWeekDay, int hotelRateRewardWeekEnd) {
		this.hotelName = hotelName;
		this.hotelRating = hotelRating;
		this.hotelRateRegularWeekDay = hotelRateRegularWeekDay;
		this.hotelRateRegularWeekEnd = hotelRateRegularWeekEnd;
		this.hotelRateRewardWeekDay = hotelRateRewardWeekDay;
		this.hotelRateRewardWeekEnd = hotelRateRewardWeekEnd;
	}

	public Hotels() {
	}

	public String getHotelName() {
		return hotelName;
	}

	public int getHotelRating() {
		return hotelRating;
	}

	public int getHotelRateRegularWeekDay() {
		return hotelRateRegularWeekDay;
	}

	public int getHotelRateRegularWeekEnd() {
		return hotelRateRegularWeekEnd;
	}

	public int getHotelRateRewardWeekDay() {
		return hotelRateRewardWeekDay;
	}

	public int getHotelRateRewardWeekEnd() {
		return hotelRateRewardWeekEnd;
	}

	@Override
	public String toString() {
		return ("Hotel Name: " + this.getHotelName() + " Hotel Rating: " + this.getHotelRating()
				+ " Regular: Hotel Rate weekday: " + this.getHotelRateRegularWeekDay()
				+ " Regular: Hotel Rate weekend: " + this.getHotelRateRegularWeekEnd() + " Reward: Hotel Rate weekday: "
				+ this.getHotelRateRewardWeekDay() + " Reward: Hotel Rate weekend: "
				+ this.getHotelRateRewardWeekEnd());
	}
}
