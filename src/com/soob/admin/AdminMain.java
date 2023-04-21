package com.soob.admin;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.soob.admin.ui.AdminUI;

public class AdminMain {

	public static void main(String[] args) {
		
//		Calendar c = Calendar.getInstance();
//		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
////		System.out.println(sdf.);
//		
//		System.out.println(c.get(Calendar.YEAR));
//		System.out.println(c.get(Calendar.MONTH)+1);
//		System.out.println(c.get(Calendar.DATE));
//		System.out.println(c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1)+"/"+c.get(Calendar.DATE));
		//어쨌든 얘네는 전부 int반환.
		
		try {
			new AdminUI().intro();
			new AdminUI().run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
