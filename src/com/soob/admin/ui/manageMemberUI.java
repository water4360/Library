package com.soob.admin.ui;

import java.util.List;

import com.soob.main.ui.BaseUI;
import com.soob.member.service.MemberServiceFactory;
import com.soob.member.vo.MemberVO;

public class manageMemberUI extends BaseUI {
	
	public manageMemberUI() {
		memService = MemberServiceFactory.getInstance();
	}

	@Override
	public void run() throws Exception {
		List<MemberVO> memList = memService.getAllMembers();
		
		p.memTop();
		for(MemberVO mem : memList) {
			System.out.print(mem);
		}
		p.memBottom();
	

	}

}
