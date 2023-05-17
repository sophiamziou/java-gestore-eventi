package org.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Evento {
    private String title;
    private LocalDate date;
    private int totSeats;
    private int resSeats;
    
	public Evento(String title, LocalDate date, int totSeats) throws Exception {
		super();
		setTitle(title);
		setDate(date);
		setTotSeats(totSeats);
		this.resSeats = 0;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) throws Exception {
		if (title.isEmpty()) {
			throw new Exception("il titolo è obbligatorio");
		}
		this.title = title;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) throws Exception {
		
		LocalDate currentDate = LocalDate.now();
		
		if (date.isAfter(currentDate)) {
			this.date = date;
		}else {
			throw new Exception("Pick a future date!");
		}
	}
	public int getTotSeats() {
		return totSeats;
	}
	private void setTotSeats(int totSeats) throws Exception {
		
		if (totSeats <= 0) {
			throw new Exception("The number of total seats must be at least 1!");
		}
		this.totSeats = totSeats;
	}
	
	public int getResSeats() {
		return resSeats;
	}
	
	public void reserve(int resSeats) throws Exception {
		
		this.resSeats = getResSeats() + resSeats;
		if (getRemainSeats() == 0) {
			throw new Exception("No more seats available!");
		}
		if(resSeats > getRemainSeats()) {
			throw new Exception("Pick a lower number");
		}
	}
	
	public void cancel(int cancSeats) throws Exception {
	
		this.resSeats = getResSeats() - cancSeats;
		if (getResSeats() < 0) {
			throw new Exception("No reservation to cancel!");
		}
	}
	
	public int getRemainSeats() {
		return getTotSeats() - getResSeats();
	}
	
	@Override
	public String toString() {
        return getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + " - " + getTitle();
	}
}
