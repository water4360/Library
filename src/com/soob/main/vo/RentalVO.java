package com.soob.main.vo;

public class RentalVO {
	private int bookNo;
	private String title;
	private String author;
	private String publisher;
	private String rentId;
	private String renDate;
	private String dueDate;
	private int overdueDay;
//	private int bookNo;
//	private String title;
//	private String author;
//	private String publisher;
//	private String rentId;
//	private String renDate;
//	private String dueDate;
//	private int overdueDay;
	
	
	
	public RentalVO() {
		super();
	}
	public RentalVO(int bookNo, String title, String author, String publisher, String rentId, String renDate, String dueDate, int overdueDay) {
		super();
		this.bookNo = bookNo;
		this.title	= title;
		this.author = author;
		this.publisher = publisher;
		this.rentId = rentId;
		this.renDate = renDate;
		this.dueDate = dueDate;
		this.overdueDay = overdueDay;
	}
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getRentId() {
		return rentId;
	}
	public void setRentId(String rentId) {
		this.rentId = rentId;
	}
	public String getRenDate() {
		return renDate;
	}
	public void setRenDate(String renDate) {
		this.renDate = renDate;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public int getOverdueDay() {
		return overdueDay;
	}
	public void setOverdueDay(int overdueDay) {
		this.overdueDay = overdueDay;
	}
	@Override
	public String toString() {
		System.out.printf("%d\t%-25s\t\t%s\t\t%-4s\t\t%s\t\t%4s\n"
				, bookNo
				, title
				, author
				, publisher
				, renDate
				, dueDate
				, overdueDay);
		return "";
//		System.out.printf("도서명:%s  저자명:%s   반납예정일:%s"
//					, Title()
//					, Author()
//					, OverdueDay());
//		return "";
	}
	
	
	
	
}



