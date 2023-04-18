package com.soob.admin.ui;

import com.soob.util.PrintService;

public class ExitUI implements IAdminUI {

	@Override
	public void run() throws Exception {
		new PrintService().printBottom();
		System.out.println("\t\t\t관리자 모드를 종료합니다.");
		new PrintService().printBottom();
		System.exit(0);
	}

}
