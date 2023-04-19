package com.soob.member.ui;

import java.util.Scanner;

import com.soob.main.ui.ExitUI;
import com.soob.main.ui.IMainUI;
import com.soob.main.ui.JoinUI;
import com.soob.main.ui.LoginUI;
import com.soob.main.ui.TempAllBooksUI;
import com.soob.main.ui.TempSearchBooksUI;
import com.soob.util.PrintService;

public class MemberUI extends BaseUI {
	PrintService print = new PrintService();
	
	public void intro() {
		print.printBottom();
		System.out.println("\t\t\t회원전용 페이지");
		print.printBottom();
	}
	
	
	public int menu() {
		System.out.print("[1]전체 도서목록 보기  ");
		System.out.print("[2]검색  ");
		System.out.print("[3]대여  ");
		System.out.print("[4]반납  ");
		System.out.print("[5]내정보 관리  ");
		System.out.print("[9]로그아웃  ");
		System.out.println("[0]프로그램 종료");
		System.out.print("메뉴를 선택하세요 >> ");
		
		Scanner sc = new Scanner(System.in);
		return Integer.parseInt(sc.nextLine());
	}

	@Override
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
				System.out.println("<도서 대여>");
//				ui = new RentBooksUI();
				break;
			case 4 :
				System.out.println("<도서 반납>");
//				ui = new JoinUI();
				break;
			case 5 :
				System.out.println("<내정보 관리>");
//				ui = new LoginUI();
				break;
			case 9 :
				System.out.println("<로그아웃>");
//				ui = new LogOutUI();
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
//				System.out.println("여기는 member, 호출된 ui가 없음");
			}
		}
		
		
	}

}
