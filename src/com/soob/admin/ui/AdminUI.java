package com.soob.admin.ui;

import java.util.Scanner;

public class AdminUI extends BaseUI{

	
	public int menu() {
		System.out.println("-".repeat(70));
		System.out.println("\t\t\t관리자 모드(도서등록 및 관리)");
		System.out.println("-".repeat(70));
		
		//관리자 전용메뉴
		System.out.println("1. 신규도서 등록");
		System.out.println("2. 기존도서 수정");
		System.out.println("3. 기존도서 삭제");
		System.out.println("4. 전체 도서목록 출력");
		System.out.println("0. 관리자 모드 종료");
		System.out.print("메뉴를 선택하세요 >> ");
		
		Scanner sc = new Scanner(System.in);
		return Integer.parseInt(sc.nextLine());
	}
	


	@Override
	public void run() throws Exception{
		
		IAdminUI ui = null; //인터페이스를 구현한 클래스의 객체를 받는 것은 가능
		
		while(true) {
			switch(menu()) {
			case 1 :
				System.out.println("<신규도서 등록>");
				ui = new RegisterUI();
				break;
			case 2 :
				System.out.println("<기존도서 수정중 대작업 예상...>");
				ui = new ModifyBookUI();
				break;
			case 3 :
				System.out.println("<기존도서 삭제 확인메세지 작업중>");
				ui = new DeleteBookUI();
				break;
			case 4 :
				System.out.println("<전체 도서목록 출력 간격조정 중>");
				ui = new AllBooksUI();
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
//				System.out.println("잘못 입력하셨습니다.");
				System.out.println("호출된 ui가 없음");
			}
		}
		
	}
	
}
