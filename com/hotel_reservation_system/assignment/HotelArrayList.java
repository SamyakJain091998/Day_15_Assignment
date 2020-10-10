package com.hotel_reservation_system.assignment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

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

	public void editDetailsOfHotel(String nameOfHotel) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		Iterator itr = hotelArrList.iterator();
		while (itr.hasNext()) {
			Hotels dummyH = (Hotels) itr.next();
			if (nameOfHotel.equals(dummyH.getHotelName())) {
				System.out.println("Enter updated value of rating of " + "Hotel " + nameOfHotel + " :");
				int hotelRating = sc.nextInt();
				dummyH.setHotelRating(hotelRating);

				System.out.println(
						"Enter updated value of weekday rate for regular customer of " + "Hotel " + nameOfHotel + " :");
				int hotelRateRegularWeekDay = sc.nextInt();
				dummyH.setHotelRateRegularWeekDay(hotelRateRegularWeekDay);

				System.out.println(
						"Enter updated value of weekend rate for regular customer of " + "Hotel " + nameOfHotel + " :");
				int hotelRateRegularWeekEnd = sc.nextInt();
				dummyH.setHotelRateRegularWeekEnd(hotelRateRegularWeekEnd);

				System.out.println(
						"Enter updated value of weekday rate for reward customer of " + "Hotel " + nameOfHotel + " :");
				int hotelRateRewardWeekDay = sc.nextInt();
				dummyH.setHotelRateRewardWeekDay(hotelRateRewardWeekDay);

				System.out.println(
						"Enter updated value of weekend rate for reward customer of " + "Hotel " + nameOfHotel + " :");
				int hotelRateRewardWeekEnd = sc.nextInt();
				dummyH.setHotelRateRewardWeekEnd(hotelRateRewardWeekEnd);
				System.out.println();

				System.out.println("------------The details have been updated successfully------------");
				System.out.println("Please wait while we show the updated hotel details list..");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
				printHotelArrList();
				System.exit(0);
			}
		}
	}
}
