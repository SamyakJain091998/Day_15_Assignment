package com.hotel_reservation_system.assignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UC7 {

	public static HotelArrayList hal = new HotelArrayList();

	public static void main(String[] args) throws ParseException {
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
		hal.printHotelArrList();

		System.out.println(
				"Do you want to check for the best rated hotel ? Press Y for yes or any other " + "key for no!");
		String input1 = sc.nextLine();
		if (input1.equalsIgnoreCase("y")) {
			System.out.println("Please mention the type of customer you are: \n1. Regular \n2. Reward");
			System.out.println("Enter choice 1 or 2 : ");
			int input2 = sc.nextInt();
			switch (input2) {
			case 1: {
				sc.nextLine();
				System.out.println("Please enter input date 1 in ddMMMyyyy format: ");
				String sDate1 = sc.nextLine();
				SimpleDateFormat formatter1 = new SimpleDateFormat("ddMMMyyyy");
				Date date1 = formatter1.parse(sDate1);
				System.out.println("Please enter input date 2 in ddMMMyyyy format: ");
				String sDate2 = sc.nextLine();
				SimpleDateFormat formatter2 = new SimpleDateFormat("ddMMMyyyy");
				Date date2 = formatter2.parse(sDate2);
				int days = date2.getDate() - date1.getDate() + 1;
				hal.getBestRatedHotel(1, date1.getDay(), date2.getDay(), days);
				break;
			}
			case 2: {
				sc.nextLine();
				System.out.println("Please enter input date 1 in ddMMMyyyy format: ");
				String sDate1 = sc.nextLine();
				SimpleDateFormat formatter1 = new SimpleDateFormat("ddMMMyyyy");
				Date date1 = formatter1.parse(sDate1);
				System.out.println("Please enter input date 2 in ddMMMyyyy format: ");
				String sDate2 = sc.nextLine();
				SimpleDateFormat formatter2 = new SimpleDateFormat("ddMMMyyyy");
				Date date2 = formatter2.parse(sDate2);
				int days = date2.getDate() - date1.getDate() + 1;
				hal.getBestRatedHotel(1, date1.getDay(), date2.getDay(), days);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + input2);
			}
		} else {
			System.out.println("Thank you for using Hotel Reservation System!");
			System.exit(0);
		}
	}
}