package com.soob.member.ui;

import java.util.ArrayList;
import java.util.List;

import com.soob.admin.ui.AdminUI;
import com.soob.main.ui.BaseUI;
import com.soob.member.service.RequestService;
import com.soob.member.vo.MemberVO;
import com.soob.member.vo.RequestVO;

public class RequestUI extends BaseUI {

	private List<RequestVO> reqList = reqService.getRequest();
	
	public RequestUI() {
		reqService = new RequestService();
	}
			
			
	@Override
	public void run() throws Exception {
//		System.out.println("<내가 보낸 의견>");
		show();
		int select = 0;
		try {
			System.out.println("[1]글쓰기 [2]삭제하기 [0]이전으로 돌아가기");
			select = scanInt("메뉴를 선택하세요 >> ");
			
		} catch (Exception e) {
			System.out.println("::잘못된 입력입니다.");
			run();
		}
		
		//이전으로 돌아가기
		if(select == 0) return;
		
		switch(select) {
		case 1 :
			
			reqService.addRequest(scanStr("등록할 내용을 100자 내외로 입력해주세요 >> "));
			System.out.println("::숲 도서관을 위한 소중한 의견 감사합니다!");
			System.out.println();
			//SQL에서 정렬을 DESC로 했으므로 첫번째만 가져오면 됨!
//			System.out.println(reqService.getRequest().get(0));
			
			break;
		case 2 :
			if(memService.getMemberCode(MemberVO.getId(), MemberVO.getPw())!=9) {
				System.out.println("::삭제는 관리자만 가능합니다^^;");
			} else {
				reqService.delRequest(scanInt("삭제할 게시글번호를 입력해주세요 >> "));
				System.out.println("게시글삭제 완료!");
			}
			break;
//			
//		case 3 :
//			show();
//			break;
		case 0 :
		default :
			if(memService.getMemberCode(MemberVO.getId(), MemberVO.getPw())==9) {
				new AdminUI().run();
			} else {
				new MemberUI().run();
			}
			break;
			
		}
	}
	
	public void show() throws Exception {
		
		p.printBottom();
		System.out.println("번호  글쓴이\t내용");
		p.printBottom();
//		System.out.println("여기는 쇼, 리스트길이 얼마?" + noticeList.size());
//		System.out.println("여기는 쇼, 리스트있음?" + noticeList.get(0));
		
		if(reqList ==null || reqList.size()==0) {
			System.out.println("등록된 게시글이 없습니다");
			p.printBottom();
		} else {
//			System.out.println("\t\t\t\t\t\t<회원 건의사항>");
			for(RequestVO req : reqList) {
				System.out.println(req);
			}
			p.printBottom();
		}
	}
	
	

}
