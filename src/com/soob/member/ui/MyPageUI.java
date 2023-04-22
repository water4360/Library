package com.soob.member.ui;

import com.soob.main.ui.BaseUI;
import com.soob.member.service.MemberServiceFactory;
import com.soob.member.vo.MemberVO;

public class MyPageUI extends BaseUI {

	public MyPageUI() {
		memService = MemberServiceFactory.getInstance();
	}
	
	@Override
	public void run() throws Exception {
		System.out.printf("%s님의 가입정보\n", MemberVO.getId());
		MemberVO mem = memService.getMemberById(MemberVO.getId());
		p.memTop();
		System.out.print(mem);
		p.memBottom();
		
//		int menu = 99;
//		try {
//			menu = scanInt("[1]이전화면으로 [8]회원탈퇴 [9]로그아웃 [0]프로그램 종료");
//		} catch (Exception e) {
//			System.out.println("::잘못 입력하셨습니다.");
//		}
//		
//		switch(menu) {
//		case 1 : 
//			break;
//		case 8 :
//			break;
//		case 9 :
//			break;
//		case 0 :
//			break;
//		}
//		
	}

}
