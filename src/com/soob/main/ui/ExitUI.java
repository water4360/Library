package com.soob.main.ui;

public class ExitUI extends BaseUI {

	@Override
	public void run() throws Exception {
		System.out.println("프로그램을 종료합니다.");
		System.out.println("숲 도서관을 이용해주셔서 감사합니다 :D");
		System.exit(0);
	}

}
