package com.soob.main.vo;

import java.util.Date;

public class RentalVO {
	private static int bookNo;
	private static String author;
	private static String title;
	private static String publisher;
	private static String rentId;
	private static Date renDate;
	private static Date dueDate;
	private static int overdueDay;
	
	public RentalVO() {
		super();
	}
	public static int getBookNo() {
		return bookNo;
	}
	public static void setBookNo(int bookNo) {
		RentalVO.bookNo = bookNo;
	}
	public static String getAuthor() {
		return author;
	}
	public static void setAuthor(String author) {
		RentalVO.author = author;
	}
	public static String getTitle() {
		return title;
	}
	public static void setTitle(String title) {
		RentalVO.title = title;
	}
	public static String getPublisher() {
		return publisher;
	}
	public static void setPublisher(String publisher) {
		RentalVO.publisher = publisher;
	}
	public static String getRentId() {
		return rentId;
	}
	public static void setRentId(String rentId) {
		RentalVO.rentId = rentId;
	}
	public static Date getRenDate() {
		return renDate;
	}
	public static void setRenDate(Date renDate) {
		RentalVO.renDate = renDate;
	}
	public static Date getDueDate() {
		return dueDate;
	}
	public static void setDueDate(Date dueDate) {
		RentalVO.dueDate = dueDate;
	}
	public static int getOverdueDay() {
		return overdueDay;
	}
	public static void setOverdueDay(int overdueDay) {
		RentalVO.overdueDay = overdueDay;
	}
	@Override
	public String toString() {
		System.out.printf("도서명:%s  저자명:%s   반납예정일:%tY/%tm/%td"
					, RentalVO.getTitle()
					, RentalVO.getAuthor()
					, RentalVO.getDueDate(), RentalVO.getDueDate(), RentalVO.getDueDate());
		return "";
	}
	
	
	
	
}



