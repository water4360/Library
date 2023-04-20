package com.soob.member;

import com.soob.member.ui.MemberUI;

public class MemberMain {

	public static void main(String[] args) {
		
		try {
			new MemberUI().run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
