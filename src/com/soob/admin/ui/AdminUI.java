package com.soob.admin.ui;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import com.soob.main.ui.BaseUI;
import com.soob.main.ui.IMainUI;
import com.soob.admin.modify.ui.ModifyBookUI;
import com.soob.admin.notice.ui.ManageNoticeUI;
import com.soob.main.ui.AllBooksUI;
import com.soob.member.vo.MemberVO;

public class AdminUI extends BaseUI	{
	
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
	Calendar c = Calendar.getInstance();
	String now = sdf.format(c.getTime());
	
	public void intro() {
		p.printBottom();
		System.out.println("\t\t\t관리자 전용 화면(도서등록 및 관리)");
		System.out.printf("\t\t\t%s님, 접속중 (%s)\n",MemberVO.getId(), now);
		p.printBottom();
	}
	
	public int menu() {
		//관리자 전용메뉴
		//1~5번 [도서관리]로 묶을까?
		System.out.print("[1] 도서 신규등록  ");
		System.out.print("[2] 도서 수정  ");
		System.out.println("[3] 기존도서 삭제  ");
		
		System.out.print("[4] 전체 도서목록 출력  ");
		System.out.println("[5] 희망도서 신청내역  ");
//		System.out.print("[6] 회원 관리  ");
		
		System.out.print("[8] 공지사항 관리  ");
		System.out.print("[9] 로그아웃  ");
		System.out.println("[0] 프로그램 종료  ");
		
		System.out.print("메뉴를 선택하세요 >> ");
		
		Scanner sc = new Scanner(System.in);
		int select = 99; 
		try {
			select = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			System.out.println("::잘못된 입력입니다. 다시 입력해주세요.");
			menu();
		}
		return select;
	}
	


	@Override
	public void run() throws Exception{
		
		IMainUI ui = null; //인터페이스를 구현한 클래스의 객체를 받는 것은 가능
		
		while(true) {
			switch(menu()) {
			case 1 :
				System.out.println("<신규도서 등록>");
				System.out.println("신규도서를 등록할 수 있습니다.");
				ui = new RegisterUI();
				break;
			case 2 :
				System.out.println("<기존도서 수정>");
				System.out.println("도서번호로 도서를 검색하고 정보를 수정할 수 있습니다.");
				ui = new ModifyBookUI();
				break;
			case 3 :
				System.out.println("<기존도서 삭제>");
				System.out.println("::도서번호로 도서를 검색하고 삭제할 수 있습니다.");
				ui = new DeleteBookUI();
				break;
			case 4 :
				System.out.println("<전체 도서목록>");
				System.out.println("::도서관에서 보유중인 전체 도서목록을 확인할 수 있습니다.");
//				ui = new AllBooksUI();
				ui = new AllBooksUI();
				break;
//			case 5 :
//				System.out.println("<희망도서 신청내역>");
//				System.out.println("::회원들이 신청한 희망도서를 확인할 수 있습니다.");
//				ui = new bookRequestUI();
//				break;
			case 8 :
				System.out.println("::프로그램 첫 화면에 공지사항을 등록할 수 있습니다");
				System.out.println();
				ui = new ManageNoticeUI();
				break;
			case 9 :
				ui = new LogOutUI();
				break;
			case 0 : 
				System.out.println("<프로그램 종료>");
				ui = new ExitUI();
				break;
			default :
				System.out.println("::존재하지 않는 메뉴입니다. 다시 입력해주세요.");
				break;
			}
			if(ui != null) {
				ui.run();
			} else {
				System.out.println("::잘못 입력하셨습니다.");
//				System.out.println("호출된 ui가 없음");
			}
		}
		
	}
	
}
