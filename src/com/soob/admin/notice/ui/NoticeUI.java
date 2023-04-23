package com.soob.admin.notice.ui;

import java.util.List;

import com.soob.admin.service.NoticeService;
import com.soob.admin.ui.AdminUI;
import com.soob.admin.vo.NoticeVO;
import com.soob.main.ui.BaseUI;

public class NoticeUI extends BaseUI {
	
	private List<NoticeVO> noticeList = noticeService.getNotice();
	
	public NoticeUI() {
		noticeService = new NoticeService();
	}

	@Override
	public void run() throws Exception {
		int select = 0;
		try {
			System.out.println("[1]등록 [2]삭제 [3]공지목록 [0]이전으로 돌아가기");
			select = scanInt("메뉴를 선택하세요 >> ");
		} catch (Exception e) {
			System.out.println("::잘못된 입력입니다.");
			run();
		}
		
		if(select == 0) return;
		
		switch(select) {
		case 1 :
//			System.out.println("내용은 200자를 초과할 수 없어요");
			noticeService.addNotice(scanStr("등록할 내용을 100자 내외로 입력해주세요 >> "));
			System.out.println("공지등록 완료!");
			//SQL에서 정렬을 DESC로 했으므로 첫번째만 가져오면 됨!
			noticeService.getNotice().get(0);
			
			break;
		case 2 :
			noticeService.delNotice(scanInt("삭제할 공지번호를 입력해주세요 >> "));
			System.out.println("공지삭제 완료!");
			break;
			
		case 3 :
			show();
			break;
		case 0 :
		default :
			new AdminUI().run();
			break;
			
		}
	}
	
	public void show() throws Exception {
//		p.printBottom();
//		System.out.println("여기는 쇼, 리스트길이 얼마?" + noticeList.size());
//		System.out.println("여기는 쇼, 리스트있음?" + noticeList.get(0));
		
		if(noticeList ==null || noticeList.size()==0) {
			System.out.println("등록된 공지사항이 없습니다");
			p.printBottom();
		} else {
			System.out.println("\t\t\t\t\t\t<공지사항>");
			for(NoticeVO notice : noticeList) {
				System.out.println(notice);
			}
			p.printBottom();
		}
	}

}
