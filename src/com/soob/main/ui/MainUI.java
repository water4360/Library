package com.soob.main.ui;

import java.util.Scanner;

import com.soob.admin.notice.ui.NoticeUI;

public class MainUI extends BaseUI{
	
	public void intro() throws Exception {
		
		//리스트의 최신 1~3개 공지만.

		
		 
		p.printBottom();
		System.out.println("\t\t\t\t\tѧѦ ѧ  ͡︵︵ ̢ ̱ ̧̱ι̵̱̊ι̶̨̱ ̶̱   ︵ ͡︵ Ѧѧ ѧ Ѧ    ̵̗̊o̵̖ ͡ ︵︵︵ ѧ Ѧѧ");
		System.out.println("\t\t\t\t\t숲 도서관에 방문하신 것을 환영합니다");
		System.out.println("\t\t\t\t\tѧѦ ѧ  ︵͡︵  ̢ ̱ ̧̱ι̵̱̊ι̶̨̱ ̶̱   ︵ Ѧѧ ѧ Ѧ    ̵̗̊o̵̖  ͡︵  ѦѦ ѧ Ѧ");
		System.out.println();
		System.out.println("\t\t\t\t\"한 권의 책은 세계에 대한 하나의 버전이다.\"");
		System.out.println("\t\t\t\t-살만 루시디(Salman Rushdie), 대표저서 <한밤의 아이들>");
		System.out.println();
		System.out.println("\t\t\t\t* 처음 방문하신 분은 회원가입 및 로그인 후 이용해주세요.");
		System.out.println("\t\t\t\t* 비회원은 도서목록 열람 및 검색만 가능합니다.");
		p.printBottom();

		//관리자 공지사항
		new NoticeUI().show();
	}
	
	public int menu() {
		//방문자 메뉴
		System.out.print("[1] 전체 도서목록 조회  ");
		System.out.print("[2] 도서 검색  ");
		System.out.print("[3] 회원가입  ");
		System.out.print("[4] 로그인  ");
		System.out.println("[0] 프로그램 종료  ");
		System.out.print("메뉴를 선택하세요 >> ");
		
		sc = new Scanner(System.in);
		int select = 9;
		try {
			select = Integer.parseInt(sc.nextLine());
			
		} catch (Exception e) {
			System.out.println("::잘못된 입력입니다. 다시 입력해주세요.");
			menu();
		}
		return select;
	}
	
	
	public void run() throws Exception {
		IMainUI ui = null; //인터페이스를 구현한 클래스의 객체를 받는 것은 가능
		
		while(true) {
			switch(menu()) {
			case 1 :
//				System.out.println("<전체 도서목록 보기>");
				ui = new AllBooksUI();
				break;
			case 2 :
//				System.out.println("<도서 검색>");
				ui = new SearchBookUI();
				break;
			case 3 :
				System.out.println("ѧѦ 숲 도서관 회원가입 Ѧѧ");
				System.out.println("::반가워요! 회원이 되면 대여, 반납서비스를 이용할 수 있어요!");
				System.out.println();
				ui = new JoinUI();
				break;
			case 4 :
//				System.out.println("<숲 도서관 로그인>");
				ui = new LoginUI();
				break;
			case 0 : 
//				System.out.println("<나가기>");
				ui = new ExitUI();
				break;
			default :
				System.out.println("::잘못 입력하셨습니다.");
				break;
			}
			if(ui != null) {
				ui.run();
			} else {
				System.out.println("::잘못 입력하셨습니다.");
//				System.out.println("여기는 main, 호출된 ui가 없음");
			}
		}
	}

}
