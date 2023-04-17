package com.soob.admin.ui;

public class ExitUI implements IAdminUI {

	@Override
	public void run() throws Exception {
		System.out.println("-".repeat(70));
		System.out.println("\t관리자 모드를 종료합니다.");
		System.out.println("-".repeat(70));
		System.exit(0);
	}

}
