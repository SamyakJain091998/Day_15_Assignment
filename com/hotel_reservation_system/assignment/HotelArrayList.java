package com.hotel_reservation_system.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HotelArrayList {
	private ArrayList<Hotels> hotelArrList = new ArrayList<Hotels>();
	private Map<String, Integer> hotelMap = new HashMap<>();

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

	public void printHotelMap() {
		int minValue = 10000;
		int count = 0;
		ArrayList<String> storeHotelName = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : hotelMap.entrySet())
			if (entry.getValue() < minValue)
				minValue = entry.getValue();
		for (Map.Entry<String, Integer> entry : hotelMap.entrySet()) {
			if (entry.getValue() == minValue) {
				count++;
				storeHotelName.add(entry.getKey());
			}
		}
		if (count == 1) {
			System.out.println("Hotel is : " + storeHotelName.get(0) + " and total rate = " + minValue);
		} else {
			int storedRating = 10000;
			String hotelWithBestRatingCheapestRate = "";
			Iterator itr = hotelArrList.iterator();
			Iterator itr1 = storeHotelName.iterator();

			while (itr1.hasNext()) {
				String dummyHotelName = (String) itr1.next();
				while (itr.hasNext()) {
					Hotels h = (Hotels) itr.next();
					if (h.getHotelName() == dummyHotelName) {
						if (h.getHotelRating() < storedRating) {
							storedRating = h.getHotelRating();
							hotelWithBestRatingCheapestRate = h.getHotelName();
						}
					}
				}
			}

			System.out.println("Hotels is : " + hotelWithBestRatingCheapestRate + " and total rate = " + minValue);
		}
	}

	public void getCheapestHotel(int typeOfCustomer, int day1, int day2, int days) {
		// TODO Auto-generated method stub
		int diff = day2 - day1 + 1;
		String cityNameToPrint = "";
		int globalSum = 10000;

		if (typeOfCustomer == 1) {
			Integer hotelRateRegularWeekDay = null;
			Predicate<Hotels> isDesiredHotel = hotelStr -> hotelRateRegularWeekDay.equals(hotelStr.getHotelRateRegularWeekDay());
			Integer countHotel = hotelArrList.stream().filter(isDesiredHotel).collect(Collectors.toList()).size();
			
			Iterator itr = hotelArrList.iterator();
			while (itr.hasNext()) {
				int localSum = 0;
				Hotels h = (Hotels) itr.next();
				if (diff == days) {
					for (int i = day1; i <= day2; i++) {
						if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5) {
							localSum += h.getHotelRateRegularWeekDay();
						} else {
							localSum += h.getHotelRateRegularWeekEnd();
						}
					}
				} else if ((days - diff) % 7 == 0) {
					int noOfWeeks = (days - diff) / 7;
					for (int i = day1; i <= day2; i++) {
						if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5) {
							localSum += h.getHotelRateRegularWeekDay();
						} else {
							localSum += h.getHotelRateRegularWeekEnd();
						}
					}
					localSum = localSum
							+ noOfWeeks * (5 * (h.getHotelRateRegularWeekDay()) + 2 * (h.getHotelRateRegularWeekEnd()));
				}

				hotelMap.put(h.getHotelName(), localSum);

				if (globalSum > localSum) {
					cityNameToPrint = h.getHotelName();
					globalSum = localSum;
				}
			}
		} //////////////////////
		else {
			Iterator itr = hotelArrList.iterator();
			while (itr.hasNext()) {
				int localSum = 0;
				Hotels h = (Hotels) itr.next();
				if (diff == days) {
					for (int i = day1; i <= day2; i++) {
						if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5) {
							localSum += h.getHotelRateRewardWeekDay();
						} else {
							localSum += h.getHotelRateRewardWeekEnd();
						}
					}
				} else if ((days - diff) % 7 == 0) {
					for (int i = day1; i <= day2; i++) {
						if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5) {
							localSum += h.getHotelRateRewardWeekDay();
						} else {
							localSum += h.getHotelRateRewardWeekEnd();
						}
					}
					localSum = localSum + 5 * (h.getHotelRateRewardWeekDay()) + 2 * (h.getHotelRateRewardWeekEnd());
				}
				hotelMap.put(h.getHotelName(), localSum);
				if (globalSum > localSum) {
					cityNameToPrint = h.getHotelName();
					globalSum = localSum;
				}
			}
		}
		System.out.println("=========Here's the final summary===========");
		printHotelMap();
	}
}