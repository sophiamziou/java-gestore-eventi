package org.java;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Set the title of the event");
		String title = sc.next();
		
		LocalDate date = null;
		
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

		System.out.println("--------------------");
		
		try {
			
			Evento e1 = new Evento(title, date, totSeats);
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
						e1.prenota(numRes);
						System.out.println("Reserved seats: " + e1.getResSeats() + "\n" + "Available seats : " + e1.getRemainSeats());
					}
					
					case 2:{
						
						System.out.print("How many reservations do you want to cancel?");
						int numCanc = sc.nextInt();
						e1.disdici(numCanc);
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
