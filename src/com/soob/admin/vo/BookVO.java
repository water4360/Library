package com.soob.admin.vo;

public class BookVO {

	//관리번호, 도서명, 저자, 출판사, 보유권수
	private int manageNo;
	private String title;
	private String author;
	private String publisher;
	private int stock;
	
	
	public BookVO() {
		super();
	}
	
	
	public BookVO(int manageNo, String title, String author, String publisher, int stock) {
		super();
		this.manageNo = manageNo;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.stock = stock;
	}
	
	
	public int getManageNo() {
		return manageNo;
	}
	public void setManageNo(int manageNo) {
		this.manageNo = manageNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	@Override
	public String toString() {
		return "BookVO [manageNo=" + manageNo + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", stock=" + stock + "]";
	}
	
	
}



