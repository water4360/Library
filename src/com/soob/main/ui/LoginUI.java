package com.soob.main.ui;

import com.soob.admin.ui.AdminUI;
import com.soob.member.service.MemberService;
import com.soob.member.service.MemberServiceFactory;
import com.soob.member.ui.MemberUI;
import com.soob.member.vo.MemberVO;

public class LoginUI extends BaseUI {
	
	private MemberService memService;
	private MemberVO mem;
	
	public LoginUI() {
		memService = MemberServiceFactory.getInstance();
	}
	
	@Override
	public void run() throws Exception {
		
//		System.out.println("회원가입을 하지 않은 이용자는 회원가입을 먼저 해주세요.");
		String id = scanStr("ID : ");
		String pw = scanStr("PW : ");
		
		//id가 존재하지 않는 경우
		if(!memService.isDuplicated(id)) {
			System.out.println("존재하지 않는 ID 입니다.");
			retry();

			//id는 있는데 비번이 틀린경우	
		} else if(!memService.isCorrectInfo(id, pw)) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			retry();
		} else {
			System.out.println("로그인 성공!");
			//관리자는 관리자페이지, 회원은 회원페이지로 진입
			switch(memService.getMemberCode(id, pw)) {
			case 1 :
			default :
//				new MemberUI().intro();
				new MemberUI().run();
				break;
			case 9 :
				new AdminUI().intro();
				new AdminUI().run();
				break;
			
			}
//			new MemberUI().run();
		}

	}
	
	public void retry() throws Exception {
		int answer = scanInt("초기 메뉴로 돌아가려면 [0], 회원가입하려면 [1], 다시 로그인 하려면 [2]\n");
		switch(answer) {
		case 0 : 
			new MainUI().run();
			break;
		case 1 :
			new JoinUI().run();
			break;
		case 2 :
		default :
			run();
			break;
		}
	}

}
