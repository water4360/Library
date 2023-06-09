package com.soob.admin.ui;

import com.soob.main.ui.BaseUI;
import com.soob.main.ui.MainUI;

public class ExitUI extends BaseUI {

	private MainUI main = new MainUI();
	
	@Override
	public void run() throws Exception {
//		p.printBottom();
//		System.out.println("::관리자 모드를 종료하고 첫 화면으로 돌아갑니다.");
		System.out.println("::프로그램을 종료합니다.");
		System.exit(0);
		System.out.println();
//		p.printBottom();
		
		//메인메뉴로 복귀.
		main.intro();
		main.run();
//		System.exit(0);
	}

}
