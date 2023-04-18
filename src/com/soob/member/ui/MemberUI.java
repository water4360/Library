package com.soob.member.ui;

import com.soob.member.dao.MemberDAO;
import com.soob.util.PrintService;

public class MemberUI {
	PrintService print = new PrintService();
	
	public void intro() {
		
		print.printBottom();
		System.out.println("\t\t\t회원가입 및 로그인");
		print.printBottom();
	}

	public void run() {
		
	}
}
