package com.soob.main.ui;

import com.soob.member.service.MemberService;
import com.soob.member.service.MemberServiceFactory;
import com.soob.member.vo.MemberVO;

public class MemberJoinUI extends BaseUI {

	private MemberService memService;
	
	public MemberJoinUI() {
		memService = MemberServiceFactory.getInstance();
	}
	
	
	@Override
	public void run() throws Exception {

		
		//Member 클래스를 만들고 정보를 따로 관리해야 할듯
		System.out.println("<폴리 라이브러리 회원가입 페이지입니다>");
		
		String id = scanStr("이용하실 ID를 입력하세요 >> ");
		String pw = scanStr("이용하실 PW를 입력하세요 >> ");
		String checkPw = scanStr("확인을 위해 한 번 더 입력하세요 >> ");
		String userName = scanStr("이름을 입력하세요 >> ");
		String userPhone = scanStr("폰번호를 입력하세요(예:01012345678) >> ");
		
		
		MemberVO memVo = new MemberVO();
		memVo.setId(id);
		memVo.setPw(pw);
		memVo.setUserName(userName);
		memVo.setUserPhone(userPhone);
		
		
		memService.addMember();
		
		
		
		System.out.println("입력하신 정보대로 회원가입을 진행할까요?");
		
				
				
	}

}
