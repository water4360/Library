package com.soob.main.ui;

import java.util.Scanner;

public abstract class BaseUI implements IMainUI{

	//스캐너 상속용도 + ui들 묶어주기
	private Scanner sc;
	
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
