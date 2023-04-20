package com.soob.main.ui;

import java.util.Scanner;

public class MainUI extends BaseUI{

	public void intro() {
		p.printBottom();
		System.out.println("\t\t\t숲 도서관에 방문하신 것을 환영합니다!");
//		System.out.println();
//		System.out.println("\t\"한 권의 책은 세계에 대한 하나의 버전이다.\"");
//		System.out.println("\t\t\t\t\t-살만 루시디(Salman Rushdie)");
//		System.out.println("\t\t\t\t\t대표저서 <한밤의 아이들>");
		System.out.println();
		System.out.println("\t\t* 처음 방문하신 분은 회원가입 및 로그인 후 이용해주세요.");
		System.out.println("\t\t* 비회원은 도서목록 열람 및 검색만 가능합니다.");
		p.printBottom();
		System.out.println("* 공지사항 : 이번달 정기 독서토론은 4/24(월) 숲 도서관 2층 카페라운지에서 진행합니다 :)");
		p.printBottom();
	}
	
	public int menu() {
		//방문자 메뉴
		System.out.println("1. 전체 도서목록 조회");
		System.out.println("2. 도서 검색");
		System.out.println("3. 회원가입");
		System.out.println("4. 로그인");
		System.out.println("0. 나가기");
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
				ui = new TempSearchBookUI();
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
