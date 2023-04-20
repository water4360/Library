package com.soob.admin;

import java.util.Calendar;

import com.soob.admin.ui.AdminUI;

public class AdminMain {

	public static void main(String[] args) {
		
//		Calendar c = Calendar.getInstance();
//		
//		System.out.println(c.get(Calendar.YEAR));
//		System.out.println(c.get(Calendar.MONTH)+1);
//		System.out.println(c.get(Calendar.DATE));
		
		try {
			new AdminUI().intro();
			new AdminUI().run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
