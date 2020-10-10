package com.hotel_reservation_system.assignment;

import java.util.Scanner;

public class UC3 {

	public static HotelArrayList hal = new HotelArrayList();

	public static void main(String[] args) {
		System.out.println("----------WELCOME TO HOTEL RESERVATION SYSTEM----------");
		System.out.println();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the count of hotels you want to add : ");
		int count = sc.nextInt();
		sc.nextLine();
		int dummyCount = count;

		while (count-- > 0) {
			System.out.println("Enter the name of Hotel " + (dummyCount - count) + " : ");
			String name = sc.nextLine();

			System.out.println("Enter the rating of Hotel " + (dummyCount - count) + " : ");
			int rating = sc.nextInt();

			System.out.println("Enter the weekday rate for regular customer of Hotel " + (dummyCount - count) + " : ");
			int regularWeekDay = sc.nextInt();

			System.out.println("Enter the weekend rate for regular customer of Hotel " + (dummyCount - count) + " : ");
			int regularWeekEnd = sc.nextInt();

			System.out.println("Enter the weekday rate for reward customer of Hotel " + (dummyCount - count) + " : ");
			int rewardWeekDay = sc.nextInt();

			System.out.println("Enter the weekend rate for reward customer of Hotel " + (dummyCount - count) + " : ");
			int rewardWeekEnd = sc.nextInt();

			sc.nextLine();
			Hotels dummyH = new Hotels(name, rating, regularWeekDay, regularWeekEnd, rewardWeekDay, rewardWeekEnd);
			hal.addToHotelArrayList(dummyH);
		}
		System.out.println();
		System.out.println("Thank you! The details have been added successfully!");
		hal.printHotelArrList();
		System.out.println();

		System.out.println(
				"Do you want to edit the details of any hotel ? Press Y or y for yes or any other key for no.");
		String inputKey = sc.nextLine();
		if (inputKey.equalsIgnoreCase("y")) {
			System.out.println("Enter the name of the hotel of which you want to edit details : ");
			String nameOfHotel = sc.nextLine();
			hal.editDetailsOfHotel(nameOfHotel);

			System.out.println();
			System.out.println("Sorry! We couldn't find any match for the hotel name you entered..");
			System.exit(0);
		} else {
			System.out.println("Thank you! You may exit now.");
			System.exit(0);
		}
	}
}