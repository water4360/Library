package com.soob.member.ui;

import java.util.Scanner;

import com.soob.main.service.BookService;
import com.soob.main.service.RentalService;
import com.soob.main.vo.BookVO;

public abstract class BaseUI implements IMemberUI{

	//스캐너 상속용도 + ui들 묶어주기
	private Scanner sc;
	private BookService service;
	private BookVO book;
	private RentalService renService;
	
	public BaseUI() {
		sc = new Scanner(System.in);
	}
	
	//문자열 입력받기
	protected String scanStr(String msg) {
		System.out.print(msg);
		String str = sc.nextLine();
		return str;
	}
	
	//정수 입력받기
	protected int scanInt(String msg) {
		System.out.print(msg);
		int num = Integer.parseInt(sc.nextLine());
		return num;
	}
	
}
