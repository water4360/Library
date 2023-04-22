package com.soob.member.ui;

import com.soob.main.LibraryMain;
import com.soob.main.ui.BaseUI;
import com.soob.member.vo.MemberVO;

public class LogOutUI extends BaseUI {
	

	@Override
	public void run() throws Exception {
		int answer = 9;
		try {
			if(MemberVO.getId()!=null)
				System.out.println(MemberVO.getId()+"님, 로그아웃 완료!");
			
			answer = scanInt("[0]프로그램 종료 [1]첫화면으로 돌아가기 >> ");
		} catch (Exception e) {
			System.out.println("::잘못된 입력입니다. 다시 선택해주세요.");
			MemberVO.setId(null);
			run();
		} 
		switch (answer) {
			case 0:
				System.out.println("숲 도서관을 이용해주셔서 감사합니다 :)");
				System.exit(0);
			case 1 :
				LibraryMain.main(null);
				break;
			default:
				System.out.println("::존재하지 않는 메뉴입니다. 다시 선택해주세요.");
				run();
		}
	}

}
