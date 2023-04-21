package com.soob.main;

import com.soob.main.ui.MainUI;

public class LibraryMain {
	
	public static void main(String[] args) {
		
		MainUI main = new MainUI();
		
		try {
			main.intro();
			main.run();
			
		} catch (Exception e) {
			e.getMessage();
			System.out.println("잘못된 입력입니다. 다시 실행해주세요.");
		}
	}

}
