package com.soob.main.ui;

import com.soob.member.service.MemberServiceFactory;
import com.soob.member.vo.MemberVO;

public class JoinUI extends BaseUI {

	public JoinUI() {
		memService = MemberServiceFactory.getInstance();
	}
	
	@Override
	public void run() throws Exception {
		String id="";
		String pw="";

		id = checkId();
		pw = checkPw();
		
		String userName = scanStr("이름을 입력하세요 예)이하리 >> ");
		String userPhone = scanStr("연락처를 입력하세요 예)01012345678 >> ");
		
//		MemberVO mem = new MemberVO();
//		MemberVO.setId(id);
//		MemberVO.setPw(pw);
//		MemberVO.setUserName(userName);
//		MemberVO.setUserPhone(userPhone);
		
		MemberVO mem = new MemberVO(id, pw, userName, userPhone);
		
		p.memTop();
		System.out.print(mem);
		p.memBottom();
		
		String answer = scanStr("입력하신 정보로 가입할까요?(Y/N) >> ");	
		if(answer.equalsIgnoreCase("Y")) {
			
			memService.addMember(mem);
			
			System.out.println("::숲 도서관의 회원이 되신 것을 환영합니다.");
			System.out.println("::"+MemberVO.getUserName()+"님의 독서 생활을 응원할게요!");
			System.out.println("::로그인 후 이용해주세요.");
			System.out.println();
			
			//바로 로그인 창 소환
			new LoginUI().run();
		} else {
			System.out.println("::가입이 취소되었어요.");
			new MainUI().run();
		}
				
				
	}
	//ID 중복체크
	private String checkId() {
		String tempId = scanStr("이용할 ID를 입력하세요 예)soob >> ");

		//ID 중복이면
		if(memService.isDuplicated(tempId)) {
			System.out.println("::이미 사용중인 ID입니다");
			return tempId=checkId(); //다시 입력받기
		}
		System.out.println("::사용할 수 있는 ID입니다");
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
