package com.soob.main.ui;

import java.util.Scanner;

import com.soob.main.service.BookService;
import com.soob.main.service.RentalService;
import com.soob.member.service.MemberService;
import com.soob.member.vo.MemberVO;
import com.soob.util.PrintService;

public abstract class BaseUI implements IMainUI{

	//스캐너 상속용도 + ui들 묶어주기
	private Scanner sc;
	protected PrintService p;
	protected BookService service;
	protected MemberService memService;
	protected RentalService renService;
//	protected MemberVO mem;
	
	public BaseUI() {
		sc = new Scanner(System.in);
		p = new PrintService();
		service = new BookService();
		renService = new RentalService();
//		mem = new MemberVO();
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
