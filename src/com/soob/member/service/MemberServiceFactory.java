package com.soob.member.service;

public class MemberServiceFactory {

	private static MemberService memService = null;
	
	public static MemberService getInstance() {
		
		if(memService == null) {
			memService = new MemberService();
		}
		
		return memService;
	}
}
