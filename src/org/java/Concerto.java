package org.java;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento{
	
	private LocalTime hour;
	private BigDecimal price;

	public Concerto(String title, LocalDate date, int totSeats, LocalTime hour, BigDecimal price) throws Exception {
		super(title, date, totSeats);
		setHour(hour);
		setPrice(price);
	}

	public LocalTime getHour() {
		return hour;
	}

	public void setHour(LocalTime hour) {
		this.hour = hour;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + " " + getHour() + " - " + getTitle() + " - " + getPrice();
		
	}
}
