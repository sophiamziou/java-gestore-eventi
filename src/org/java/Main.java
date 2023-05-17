package org.java;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Set the title of the event");
		String title = sc.next();
		
		LocalDate date = null;
		LocalTime hour = null;
		while (true) {
			System.out.println("Set the date of the event in format yyyy-mm-dd");
			String dateString = sc.next();
			try {
				date = LocalDate.parse(dateString);
				break;
			} catch (Exception e) {
				System.out.println("Error : write date in correct format");
				continue;
			}
		}
		
		System.out.println("Set the total seats available");
		int totSeats = sc.nextInt();

		while (true) {
			System.out.println("Set the hour of the event in format (hh:mm:ss)");
			String hourString = sc.next();
			try {
				hour = LocalTime.parse(hourString);
				break;
			} catch (Exception e) {
				System.out.println("Error : write hour in correct format");
				continue;
			}
		}
		
		
        BigDecimal price = null;
        
        while (true) {
            System.out.println("Set the price per seat");
            String priceString = sc.next();
            try {
                price = new BigDecimal(priceString);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Write the price in a valid format");
                continue;
            }
        }
		
		System.out.println("--------------------");
		
		try {
			
			Concerto e1 = new Concerto(title, date, totSeats, hour, price);
			System.out.println(e1);
			
			int userVal = -1;
			
			while (true) {

				System.out.println("-------------------");
				System.out.println("1 - Make a reservation");
				System.out.println("2 - Cancel a reservation");
				System.out.println("3 - Quit");
				userVal = sc.nextInt();
				System.out.println("-------------------");

				if (userVal < 1 || userVal > 3) {

					System.out.println("retry");
					continue;
				}
				
				switch(userVal) {
				
					case 1:{
						
						System.out.print("How many reservations do you want to make?");
						if (userVal < 1) {
							System.out.println("You have to make at least 1 reservation");
							continue;
						}
						int numRes = sc.nextInt();
						e1.reserve(numRes);
						System.out.println("Reserved seats: " + e1.getResSeats() + "\n" + "Available seats : " + e1.getRemainSeats());
					}
					
					case 2:{
						
						System.out.print("How many reservations do you want to cancel?");
						int numCanc = sc.nextInt();
						e1.cancel(numCanc);
						System.out.println("Reserved seats: " + e1.getResSeats() + "\n" + "Available seats : " + e1.getRemainSeats());		
					}
					
					case 3:{
						break;
					}
				
				}
				
				sc.nextLine();
			}
			
		} catch (Exception e) {
			
			System.err.println("Error " + e.getMessage());
		}
		
		sc.close();
	}
}
