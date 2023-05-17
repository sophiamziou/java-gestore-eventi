package org.java;

import java.time.LocalDate;

public class Evento {
    private String title;
    private LocalDate date;
    private int totSeats;
    private int resSeats;
    
	public Evento(String title, LocalDate date, int totSeats) {
		super();
		setTitle(title);
		setDate(date);
		setTotSeats(totSeats);
		this.resSeats = 0;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getTotSeats() {
		return totSeats;
	}
	private void setTotSeats(int totSeats) {
		this.totSeats = totSeats;
	}
	public int getResSeats() {
		return resSeats;
	}
	
	private void reserve(int resSeats) throws Exception {
		this.resSeats = getResSeats() + 1;
		if (getResSeats()>= getTotSeats()) {
			throw new Exception("No more seats available!");
		}
	}
	private void cancel(int resSeats) throws Exception {
		this.resSeats = getResSeats() - 1;
		if (getResSeats() == 0) {
			throw new Exception("No reservation to cancel!");
		}
	}
}
