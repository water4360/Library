package com.soob.member.ui;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import com.soob.main.LibraryMain;
import com.soob.main.ui.BaseUI;
import com.soob.main.ui.ExitUI;
import com.soob.main.ui.IMainUI;
import com.soob.main.ui.AllBooksUI;
import com.soob.main.ui.SearchBookUI;
import com.soob.member.service.MemberServiceFactory;
import com.soob.member.vo.MemberVO;
import com.soob.member.vo.RentalVO;

public class MemberUI extends BaseUI{
	
	public MemberUI() {
		memService = MemberServiceFactory.getInstance();
	}
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
	Calendar c = Calendar.getInstance();
	String now = sdf.format(c.getTime());
	
	public void intro() throws Exception {
		System.out.printf("\t\t\t\t\t%s님 접속중 (%s)\n",MemberVO.getId(), now);
		p.printBottom();
		
		//업뎃 먼저하고 리스트 가져오기
		renService.calOverdue(MemberVO.getId());
		List<RentalVO> bookList = renService.getRentalList(MemberVO.getId());
		if(bookList.size() == 0) {
			System.out.println("::대여중인 도서가 없습니다. 흥미있는 도서를 대여해보세요 :)");
			System.out.println();
		} else {
			System.out.printf("\t\t\t\t\t<내가 대여중인 도서목록>\n", MemberVO.getId());
			p.rentalTop();
			for(RentalVO ren : bookList) {
				System.out.print(ren);
			}
			p.rentalBottom();
		
		
		}
		
//		System.out.println("여기는 MemberUI, ID = " + mem.getId());
	}
	
	//LoginUI에서 받아올 메소드
	public String getId(String id) {
		return id;
	}
	
	
	public int menu() {
		int menu = 0;
		//정상적인 로그인상태
		if(MemberVO.getId()!=null) {
			System.out.print("[1]전체도서보기  ");
			System.out.print("[2]도서검색  ");
			System.out.print("[3]대여  ");
			System.out.print("[4]반납  ");
			System.out.println("[5]내정보관리  ");
			System.out.print("[8]의견보내기  ");
			System.out.print("[9]로그아웃  ");
			System.out.println("[0]프로그램 종료");
		} else {
			System.out.println("::비정상적인 접근입니다. 첫 화면으로 돌아갑니다.");
			LibraryMain.main(null);
		}
		try {
			menu = scanInt("메뉴를 선택하세요 >> ");
		} catch (Exception e) {
			System.out.println("::잘못된 입력입니다.");
			menu();
		}
		
		return menu;
	}

	@Override
	public void run() throws Exception {
		IMainUI ui = null; //인터페이스를 구현한 클래스의 객체를 받는 것은 가능
		while(true) {
			switch(menu()) {
			default :
				System.out.println("::잘못 입력하셨습니다.");
				break;
			case 1 :
//				System.out.println("<전체 도서목록 보기>");
				ui = new AllBooksUI();
				break;
			case 2 :
//				System.out.println("<도서 검색>");
				ui = new SearchBookUI(); 
				break;
			case 3 :
//				System.out.println("<도서 대여>");
				ui = new RentBookUI();
				break;
			case 4 :
//				System.out.println("<도서 반납>");
				ui = new ReturnBookUI();
				break;
			case 5 :
//				System.out.println("<내정보 관리>");
				ui = new MyPageUI();
				break;
			case 8 :
				System.out.println("<소통게시판>");
				ui = new RequestUI();
				break;
			case 9 :
//				System.out.println("<로그아웃>");
				ui = new LogOutUI();
				break;
			case 0 : 
//				System.out.println("<나가기>");
				ui = new ExitUI();
				break;
			}
			if(ui != null) {
				ui.run();
			} else {
				System.out.println("::잘못 입력하셨습니다.");
			}
		}
		
		
	}

}
