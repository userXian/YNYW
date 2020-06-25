package com.example.demo.Entity;

import java.util.Date;

public class rental {
	String userId;
	String bookId;
	Date rentalDatetime;
	public String getUserId() {
		return userId;
	}
	public Date getRentalDatetime() {
		return rentalDatetime;
	}
	public void setRentalDatetime(Date rentalDatetime) {
		this.rentalDatetime = rentalDatetime;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
}
