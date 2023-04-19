package com.soob.main.ui;

import java.util.Scanner;

public class MainUI extends BaseUI{

	
	public int menu() {
		//방문자 메뉴
		System.out.println("1. 전체 도서목록 보기");
		System.out.println("2. 도서 검색");
		System.out.println("3. 회원가입");
		System.out.println("4. 로그인");
		System.out.println("0. 프로그램 종료");
		System.out.print("메뉴를 선택하세요 >> ");
		
		Scanner sc = new Scanner(System.in);
		return Integer.parseInt(sc.nextLine());
	}
	
	
	public void run() throws Exception {
		IMainUI ui = null; //인터페이스를 구현한 클래스의 객체를 받는 것은 가능
		
		while(true) {
			switch(menu()) {
			case 1 :
//				System.out.println("<전체 도서목록 보기>");
				ui = new TempAllBooksUI();
				break;
			case 2 :
//				System.out.println("<도서 검색>");
				ui = new TempSearchBooksUI();
				break;
			case 3 :
				System.out.println("<회원가입>");
				ui = new JoinUI();
				break;
			case 4 :
				System.out.println("<로그인>");
				ui = new LoginUI();
				break;
			case 0 : 
//				System.out.println("<나가기>");
				ui = new ExitUI();
				break;
			default :
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
			if(ui != null) {
				ui.run();
			} else {
				System.out.println("잘못 입력하셨습니다.");
//				System.out.println("여기는 main, 호출된 ui가 없음");
			}
		}
	}
}
