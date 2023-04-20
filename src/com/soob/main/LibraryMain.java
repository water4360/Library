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
		}
	}

}
