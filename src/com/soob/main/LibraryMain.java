package com.soob.main;

import com.soob.main.ui.MainUI;
import com.soob.util.PrintService;

public class LibraryMain {
	
	public static void main(String[] args) {
		
		new PrintService().printBottom();
		System.out.println("\t\t\tWelcome to 폴리라이브러리");
//		System.out.println();
//		System.out.println("\t\"한 권의 책은 세계에 대한 하나의 버전이다.\"");
//		System.out.println("\t\t\t\t\t-살만 루시디(Salman Rushdie)");
//		System.out.println("\t\t\t\t\t대표저서 <한밤의 아이들>");
		System.out.println();
		System.out.println("\t\t처음 방문하신 분은 회원가입 및 로그인 후 이용해주세요.");
		System.out.println("\t\t로그인하지 않아도 도서 목록 열람은 가능합니다.");
		new PrintService().printBottom();
		
		try {
			new MainUI().run();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
