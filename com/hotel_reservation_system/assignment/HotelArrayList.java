package com.hotel_reservation_system.assignment;

import java.util.ArrayList;
import java.util.List;

public class HotelArrayList {
	private ArrayList<Hotels> hotelArrList = new ArrayList<Hotels>();

	public void addToHotelArrayList(Hotels h) {
		hotelArrList.add(h);
	}

	public void printHotelArrList() {
		System.out.println("Updated Hotel array list is : ");
		System.out.println(getHotelArrList());
		System.out.println();
	}

	public List<Hotels> getHotelArrList() {
		return hotelArrList;
	}
}