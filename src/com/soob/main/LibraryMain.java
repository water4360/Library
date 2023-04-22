package com.soob.main;

import com.soob.main.ui.MainUI;

public class LibraryMain {
	
	public static void main(String[] args) {
		
		MainUI main = new MainUI();
		
		try {
			main.intro();
			main.run();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("::잘못된 입력입니다. 첫 화면으로 돌아갑니다.");
			main(null);
		}
	}

}
