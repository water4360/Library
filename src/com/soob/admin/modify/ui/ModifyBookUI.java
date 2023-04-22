package com.soob.admin.modify.ui;

import com.soob.main.service.BookServiceFactory;
import com.soob.main.ui.BaseUI;
import com.soob.main.vo.BookVO;

public class ModifyBookUI extends BaseUI {

	private BookVO book;
	
	public ModifyBookUI() {
		bookService = BookServiceFactory.getInstance();
	}
	
	
	@Override
	public void run() throws Exception {
		int searchNo = 0;
		try {
			searchNo = scanInt("수정할 도서의 관리번호를 입력하세요(취소:0) >> ");
		} catch (Exception e) {
			System.out.println("::잘못된 입력입니다.");
			run();
		}
		if(searchNo == 0) return;
		
		book = bookService.searchOneByNo(searchNo);
		
		if(book != null) {
			p.printTop();
			System.out.print(book);
		} else {
			System.out.println("::[" + searchNo + "]번 도서는 존재하지 않습니다");
			run();
		}
		p.printBottom();
		int selectNo = 0;
		try {
			selectNo = scanInt("[1]도서명 [2]저자 [3]출판사 [0]수정취소\n수정할 항목을 선택하세요 >> ");
		} catch (Exception e) {
			System.out.println("::잘못된 입력입니다.");
			run();
		}
		if(selectNo == 0) return;
		
		IModifyQuery mod = null;
		
		switch(selectNo) {
			case 1 :
				mod = new ModTitle();
				break;
			case 2 :
				mod = new ModAuthor();
				break;
			case 3 :
				mod = new ModPublisher();
				break;
			case 0 :
				run();
				break;
			default :
				break;
		}
			//mod가 선택됐고 1~3번 문자열 수정항목이면
			if(mod != null && selectNo <= 3) {
				String str = mod.modify(book, selectNo, searchNo, scanStr("수정할 내용을 입력하세요 >> "));
				if(str == "") {
					System.out.println("::올바른 수정내용이 아닙니다.");
					run();
				}
				
			} else {
				
			}
		
	}

}
