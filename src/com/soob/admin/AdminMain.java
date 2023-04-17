package com.soob.admin;

import com.soob.admin.ui.AdminUI;

public class AdminMain {

	public static void main(String[] args) {
		
		try {
			new AdminUI().run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
