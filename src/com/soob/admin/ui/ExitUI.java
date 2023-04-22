package com.soob.admin.ui;

import com.soob.main.ui.BaseUI;
import com.soob.main.ui.MainUI;

public class ExitUI extends BaseUI {

	private MainUI main = new MainUI();
	
	@Override
	public void run() throws Exception {
//		p.printBottom();
		System.out.println("\t\t\t관리자 모드를 종료하고 첫 화면으로 돌아갑니다.");
//		p.printBottom();
		
		//메인메뉴로 복귀.
		main.intro();
		main.run();
//		System.exit(0);
	}

}
