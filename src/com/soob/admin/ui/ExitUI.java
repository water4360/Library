package com.soob.admin.ui;

import com.soob.main.LibraryMain;
import com.soob.main.ui.MainUI;
import com.soob.member.vo.MemberVO;

public class ExitUI extends BaseUI {

	private MainUI main = new MainUI();
	
	@Override
	public void run() throws Exception {
		p.printBottom();
		System.out.println("\t\t\t관리자 모드를 종료합니다.");
		p.printBottom();
		
		//메인메뉴로 복귀.
		main.intro();
		main.run();
//		System.exit(0);
	}

}
