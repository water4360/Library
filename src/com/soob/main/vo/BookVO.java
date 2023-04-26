package com.soob.main.vo;

public class BookVO {

	//관리번호, 도서명, 저자, 출판사, 보유권수, 대여상태
	private int manageNo;
	private String title;
	private String author;
	private String publisher;
	private int status; // 0:대여불가, 1:대여가능
	private int pop;
	
	public BookVO(int manageNo, String title, String author, String publisher, int status, int pop) {
		super();
		this.manageNo 	= manageNo;
		this.title		= title;
		this.author 	= author;
		this.publisher  = publisher;
		this.status 	= status;
		this.pop 		= pop;
	}
	
	
	public BookVO() {
		super();
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

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getPop() {
		return pop;
	}
	public void setPop(int pop) {
		this.pop = pop;
	}
	
	
	
//	public BookVO(int manageNo, String title, String author, String publisher, int status) {
//		super();
//		BookVO.manageNo = manageNo;
//		BookVO.title = title;
//		BookVO.author = author;
//		BookVO.publisher = publisher;
////		BookVO.stock = stock;
//		BookVO.status = status;
//	}
//
//	
//	public static int getManageNo() {
//		return manageNo;
//	}
//	public static void setManageNo(int manageNo) {
//		BookVO.manageNo = manageNo;
//	}
//
//	public static String getTitle() {
//		return title;
//	}
//	public static void setTitle(String title) {
//		BookVO.title = title;
//	}
//
//	public static String getAuthor() {
//		return author;
//	}
//	public static void setAuthor(String author) {
//		BookVO.author = author;
//	}
//
//	public static String getPublisher() {
//		return publisher;
//	}
//	public static void setPublisher(String publisher) {
//		BookVO.publisher = publisher;
//	}
//
//	public static int getStock() {
//		return stock;
//	}
//	public static void setStock(int stock) {
//		BookVO.stock = stock;
//	}
//
//	public static int getStatus() {
//		return status;
//	}
//	public static void setStatus(int status) {
//		BookVO.status = status;
//	}


	@Override
	public String toString() {
		//제목을 맨 뒤로 가게 순서를 바꿔???
//		System.out.printf("번호 도서명    저자    출판사 대출상태");
		System.out.printf("%d\t%-25s\t\t%-8s\t\t%-10s\t\t%4s\n"
				, manageNo
				, title
				, author
				, publisher
//				, stock
//				, status
				, (status == 1 ? "대출가능" : "대출불가"));
		return "";
	}
	
	
}



