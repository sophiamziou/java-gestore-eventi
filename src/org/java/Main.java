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
			
		} catch (Exception e) {
			
			System.err.println("Error " + e.getMessage());
		}
		
	}
}
