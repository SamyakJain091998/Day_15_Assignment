package com.hotel_reservation_system.assignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UC6 {

	public static HotelArrayList hal = new HotelArrayList();
	private static int count = 0;
	private static int dummyCount;

	public static void countOfHotels() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter the count of hotels you want to add : ");
			count = sc.nextInt();
			sc.nextLine();
		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.println("Invalid input. Try again!");
			countOfHotels();
		}
	}

	public static void parametersForHotel() {
		Scanner sc = new Scanner(System.in);
		try {
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
		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.println("Plese enter valid inputs. Try again!");
			parametersForHotel();
		}
	}

	public static void main(String[] args) throws ParseException {
		System.out.println("----------WELCOME TO HOTEL RESERVATION SYSTEM----------");
		System.out.println();
		Scanner sc = new Scanner(System.in);
		countOfHotels();

		dummyCount = count;

		while (count > 0) {
			count -= 1;
			parametersForHotel();
		}
		System.out.println();
		hal.printHotelArrList();

		System.out
				.println("Do you want to check for the cheapest hotel ? Press Y for yes or any other " + "key for no!");
		String input1 = sc.nextLine();
		if (input1.equalsIgnoreCase("y")) {
			while (true) {
				System.out.println("Please mention the type of customer you are: \n1. Regular \n2. Reward");
				String input2 = sc.nextLine();
				input2 = input2.toLowerCase();
				if (input2.equals("regular") || input2.equals("reward")) {
					if (input2.equals("regular")) {
						while (true) {
							System.out.println("Please enter input date 1 in ddMMMyyyy format: ");
							String sDate1 = sc.nextLine();
							SimpleDateFormat formatter1 = new SimpleDateFormat("ddMMMyyyy");
							Date date1 = formatter1.parse(sDate1);

							if (!(date1.getDate() > 0 && date1.getDate() <= 31)) {
								System.out.println("Invalid format of the date. Please try again!");
								continue;
							}

							if (!(date1.getMonth() > 0 && date1.getMonth() <= 12)) {
								System.out.println("Invalid format of the month. Please try again!");
								continue;
							}

							String regex = "^[0-9]{4}$";
							Pattern p = Pattern.compile(regex);
							Matcher m = p.matcher(String.valueOf(date1.getYear() + 1900));
							if (!m.matches()) {
								System.out.println("Invalid format of the year. Please try again!");
								continue;
							}

							System.out.println("Please enter input date 2 in ddMMMyyyy format: ");
							String sDate2 = sc.nextLine();
							SimpleDateFormat formatter2 = new SimpleDateFormat("ddMMMyyyy");
							Date date2 = formatter2.parse(sDate2);

							if (!(date2.getDate() > 0 && date2.getDate() <= 31)) {
								System.out.println("Invalid format of the date. Please try again!");
								continue;
							}

							if (!(date2.getMonth() > 0 && date2.getMonth() <= 12)) {
								System.out.println("Invalid format of the month. Please try again!");
								continue;
							}

							m = p.matcher(String.valueOf(date2.getYear() + 1900));
							if (!m.matches()) {
								System.out.println("Invalid format of the year. Please try again!");
								continue;
							}

							int days = date2.getDate() - date1.getDate() + 1;
							hal.getCheapestHotel(1, date1.getDay(), date2.getDay(), days);
							break;
						}
					}
					if (input2.equals("reward")) {
						System.out.println("Please enter input date 1 in ddMMMyyyy format: ");
						String sDate1 = sc.nextLine();
						SimpleDateFormat formatter1 = new SimpleDateFormat("ddMMMyyyy");
						Date date1 = formatter1.parse(sDate1);

						if (!(date1.getDate() > 0 && date1.getDate() <= 31)) {
							System.out.println("Invalid format of the date. Please try again!");
							continue;
						}

						if (!(date1.getMonth() > 0 && date1.getMonth() <= 12)) {
							System.out.println("Invalid format of the month. Please try again!");
							continue;
						}

						String regex = "^[0-9]{4}$";
						Pattern p = Pattern.compile(regex);
						Matcher m = p.matcher(String.valueOf(date1.getYear() + 1900));
						if (!m.matches()) {
							System.out.println("Invalid format of the year. Please try again!");
							continue;
						}

						System.out.println("Please enter input date 2 in ddMMMyyyy format: ");
						String sDate2 = sc.nextLine();
						SimpleDateFormat formatter2 = new SimpleDateFormat("ddMMMyyyy");
						Date date2 = formatter2.parse(sDate2);

						if (!(date2.getDate() > 0 && date2.getDate() <= 31)) {
							System.out.println("Invalid format of the date. Please try again!");
							continue;
						}

						if (!(date2.getMonth() > 0 && date2.getMonth() <= 12)) {
							System.out.println("Invalid format of the month. Please try again!");
							continue;
						}

						m = p.matcher(String.valueOf(date2.getYear() + 1900));
						if (!m.matches()) {
							System.out.println("Invalid format of the year. Please try again!");
							continue;
						}

						int days = date2.getDate() - date1.getDate() + 1;
						hal.getCheapestHotel(2, date1.getDay(), date2.getDay(), days);
						break;
					}
				} else {
					System.out.println("Invalid input. Please try again.");
					continue;
				}
			}
		} else {
			System.out.println("Thank you for using Hotel Reservation System!");
			System.exit(0);
		}
	}
}