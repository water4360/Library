package com.soob.main.ui;

import java.util.List;

import com.soob.member.service.MemberService;
import com.soob.member.service.MemberServiceFactory;
import com.soob.member.vo.MemberVO;

public class JoinUI extends BaseUI {

	private MemberService memService;
	private MemberVO mem;
	
	public JoinUI() {
		memService = MemberServiceFactory.getInstance();
	}
	
	public void intro() {
		System.out.println("<숲 라이브러리 숲 회원가입 페이지입니다>");
	}
	
	@Override
	public void run() throws Exception {
		String id="";
		String pw="";
		

		List<MemberVO> memList;

		id = checkId();
		pw = checkPw();
		
		String userName = scanStr("이름을 입력하세요 예)이하리 >> ");
		String userPhone = scanStr("연락처를 입력하세요 예)01012345678 >> ");
		
		MemberVO mem = new MemberVO();
		mem.setId(id);
		mem.setPw(pw);
		mem.setUserName(userName);
		mem.setUserPhone(userPhone);
		
		System.out.println(mem);
		String answer = scanStr("입력하신 정보로 가입할까요?(Y/N) >> ");	
		if(answer.equalsIgnoreCase("Y")) {
			
			memService.addMember(mem);
			
			System.out.println("::도서관 숲의 회원이 되신 것을 환영합니다.");
			System.out.println("::"+mem.getUserName()+"님의 독서 생활을 응원할게요!");
			System.out.println("::로그인 후 이용해주세요.");
			//바로 로그인 창 소환
			new LoginUI().run();
		} else {
			System.out.println("::사용자가 가입을 취소했습니다.");
			new MainUI().run();
		}
				
				
	}
	//ID 중복체크
	private String checkId() {
		String tempId = scanStr("이용할 ID를 입력하세요 >> ");

		//ID 중복이면
		if(memService.isDuplicated(tempId)) {
			System.out.println("::이미 사용중인 ID입니다");
			return tempId=checkId(); //다시 입력받기
		}
		System.out.println("::사용할 수 있는 ID입니다");
//		System.out.println("아디 : " + tempId);
		return tempId;
	}

	//PW 일치체크
	private String checkPw() {
		String tempPw = scanStr("이용할 PW를 입력하세요 >> ");
		String checkPw = scanStr("확인을 위해 한 번 더 입력하세요 >> ");
		
		//비번 일치 확인되면
		if(tempPw.equals(checkPw)) {
			System.out.println("::PW 일치 확인");
//			System.out.println("비번 : " + tempPw);
			return tempPw;
		}
		System.out.println("::PW 불일치.");
		return tempPw = checkPw();
	}

}
