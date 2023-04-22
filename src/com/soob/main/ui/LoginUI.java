package com.soob.main.ui;

import com.soob.admin.ui.AdminUI;
import com.soob.member.service.MemberService;
import com.soob.member.service.MemberServiceFactory;
import com.soob.member.ui.MemberUI;
import com.soob.member.vo.MemberVO;

public class LoginUI extends BaseUI {
	
	private MemberService memService;
	private MemberUI memUi;
	private AdminUI adminUi;
	
	public LoginUI() {
		memService = MemberServiceFactory.getInstance();
		memUi = new MemberUI();
		adminUi = new AdminUI();
	}
	
	@Override
	public void run() throws Exception {
		
		String id = null;
		String pw = null;
		try {
			id = scanStr("ID : ");
			if(id.length() < 4) {
				System.out.println("::ID는 4자리 이상입니다.");
				run();
			}
			pw = scanStr("PW : ");
			
		} catch (Exception e) {
			System.out.println("::잘못된 입력입니다. 다시 입력해주세요.");
			run();
		}
		
		//id가 존재하지 않는 경우
		if(!memService.isDuplicated(id)) {
			System.out.println("::존재하지 않는 ID 입니다.");
			retry();

			//id는 있는데 비번이 틀린경우	
		} else if(!memService.isCorrectInfo(id, pw)) {
			System.out.println("::비밀번호가 일치하지 않습니다.");
			retry();
		} else {
			MemberVO.setId(id);
			MemberVO.setPw(pw);
			System.out.println(MemberVO.getId() +"님, 안녕하세요!");
			
			//회원코드에 따라
			switch(memService.getMemberCode(id, pw)) {
			//회원은 회원페이지로 진입
			case 1 :
			default :
				memUi.intro();
				memUi.run();
				break;
			//관리자는 관리자페이지
			case 9 :
				adminUi.intro();
				adminUi.run();
				break;
			}
		}
	}
	
	public void retry() throws Exception {
		int answer = 9;
		try {
			answer = scanInt("[0]첫화면으로 [1]회원가입 [2]다시 로그인\n");
		} catch (Exception e) {
			System.out.println("::잘못된 입력입니다. 다시 입력해주세요.");
			retry();
		}
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
