package com.soob.member.ui;

import com.soob.main.LibraryMain;
import com.soob.main.ui.BaseUI;
import com.soob.member.vo.MemberVO;

public class LogOutUI extends BaseUI {
	

	@Override
	public void run() throws Exception {
		System.out.println(MemberVO.getId()+"님, 로그아웃 완료.");
		MemberVO mem = new MemberVO();
		System.out.println("이용해주셔서 감사합니다 :)");
		int answer = scanInt("[0]프로그램 종료 [1]첫화면으로 돌아가기");
		switch (answer) {
		case 0:
			System.exit(0);
		case 1 :
		default:
			LibraryMain.main(null);
			break;
		}
	}

}
