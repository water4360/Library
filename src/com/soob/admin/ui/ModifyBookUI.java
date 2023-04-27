package com.soob.admin.ui;

import com.soob.admin.modify.ui.IModifyQuery;
import com.soob.main.service.BookServiceFactory;
import com.soob.main.ui.BaseUI;
import com.soob.main.vo.BookVO;

public class ModifyBookUI extends BaseUI implements IModifyQuery{

	private BookVO book;
	
	public ModifyBookUI() {
		bookService = BookServiceFactory.getInstance();
	}
	
	
	@Override
	public void run() throws Exception {
		int searchNo = 0;
		try {
			searchNo = scanInt("수정할 도서의 도서번호를 입력하세요 [0]취소 >> ");
		} catch (Exception e) {
			System.out.println("::잘못된 입력입니다.");
			run();
		}
		//취소는 0
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
		
		//최종 수정
		try {
			modify(book, selectNo, searchNo, scanStr("수정할 내용을 입력하세요 >> "));
		} catch (Exception e) {
			System.out.println("::잘못된 입력입니다 캐치.");
		}
		
	}


	@Override
	public void modify(BookVO book, int menu, int manageNo, String str) throws Exception {
		book = bookService.searchOneByNo(manageNo);
		switch (menu) {
		case 1:
			if(str != null && str.length() > 1) {
				bookService.modifyBook(menu, manageNo, str);
				renService.updateBook(menu, manageNo, str);
				System.out.println("::도서명 수정이 완료되었습니다.");
			} else {
				System.out.println("::잘못된 입력입니다.");
			}
			break;
		case 2:
			if(str != null && str.length() > 1) {
				bookService.modifyBook(menu, manageNo, str);
				renService.updateBook(menu, manageNo, str);
				System.out.println("::저자명 수정이 완료되었습니다.");
			} else {
				System.out.println("::잘못된 입력입니다.");
			}
			break;
		case 3:
			if(str != null && str.length() > 1) {
				bookService.modifyBook(menu, manageNo, str);
				renService.updateBook(menu, manageNo, str);
				System.out.println("::출판사명 수정이 완료되었습니다.");
			} else {
				System.out.println("::잘못된 입력입니다.");
			}
			break;
		}
	}

}
