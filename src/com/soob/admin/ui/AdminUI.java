package com.soob.admin.ui;

import java.util.Scanner;

import com.soob.main.ui.IMainUI;

public class AdminUI extends BaseUI{
	
	public void intro() {
		p.printBottom();
		System.out.println("\t\t\t관리자 페이지(도서등록 및 관리)");
		p.printBottom();
	}
	
	public int menu() {
		//관리자 전용메뉴
		//1~5번 [도서관리]로 묶을까?
		System.out.println("1. 신규도서 등록");
		System.out.println("2. 기존도서 수정");
		System.out.println("3. 기존도서 삭제");
		System.out.println("4. 전체 도서목록 출력 - 출력간격 조정중");
		System.out.println("5. 희망도서 신청내역 확인");
		//6번 - 전체 회원 검색, 연체 회원 조회
		System.out.println("6. 회원 관리");
		System.out.println("0. 관리자 모드 로그아웃");
		System.out.print("메뉴를 선택하세요 >> ");
		
		Scanner sc = new Scanner(System.in);
		return Integer.parseInt(sc.nextLine());
	}
	


	@Override
	public void run() throws Exception{
		
		IMainUI ui = null; //인터페이스를 구현한 클래스의 객체를 받는 것은 가능
		
		while(true) {
			switch(menu()) {
			case 1 :
				System.out.println("<신규도서 등록>");
				ui = new RegisterUI();
				break;
			case 2 :
				System.out.println("<기존도서 수정>");
				ui = new ModifyBookUI();
				break;
			case 3 :
				System.out.println("<기존도서 삭제>");
				ui = new DeleteBookUI();
				break;
			case 4 :
				System.out.println("<전체 도서목록 출력>");
				ui = new AllBooksUI();
				break;
			case 0 : 
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
//				System.out.println("호출된 ui가 없음");
			}
		}
		
	}
	
}
