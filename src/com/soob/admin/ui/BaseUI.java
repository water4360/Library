package com.soob.admin.ui;

import java.util.Scanner;

import com.soob.admin.service.BookService;
import com.soob.util.PrintService;

public abstract class BaseUI implements IAdminUI{

	//스캐너 상속용도 + ui들 묶어주기
	private Scanner sc;
	protected PrintService p;
	protected BookService service;
	
	public BaseUI() {
		sc = new Scanner(System.in);
		p = new PrintService();
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
