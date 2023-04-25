package com.soob.util;

public class PrintService {
	
	public PrintService() {}

	public void printTop() {
		System.out.println("―".repeat(130));
		System.out.println("도서번호\t\t\t도 서 명\t\t저  자\t\t\t출판사\t\t\t상태코드\t대출상태");
		System.out.println("―".repeat(130));
	}
	
	public void printBottom() {
		System.out.println("―".repeat(130));
	}
	
	public void rentalTop() {
		System.out.println("―".repeat(130));
		System.out.println("도서번호\t\t\t도 서 명\t\t저  자\t\t출판사\t\t대여일\t\t반납기한\t남은일수");
		System.out.println("―".repeat(130));
	}
	
	public void rentalBottom() {
		System.out.println("―".repeat(130));
	}

	public void memTop() {
		System.out.println("―".repeat(130));
		System.out.println("ID\t\t\tPW\t\t\t이름\t\t연락처");
		System.out.println("―".repeat(130));
	}

	public void memBottom() {
		System.out.println("―".repeat(130));
	}
	
}
