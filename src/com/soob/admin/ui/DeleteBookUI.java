package com.soob.admin.ui;

import com.soob.admin.service.BookService;
import com.soob.admin.vo.BookVO;

public class DeleteBookUI extends BaseUI {
	
	private BookService service;
	
	public DeleteBookUI() {
		service = new BookService();
	}

	@Override
	public void run() throws Exception {
		BookVO book = null;
		int manageNo = scanInt("삭제할 도서의 관리번호를 입력하세요 : ");
		//맞는지 확인?
		book = service.modifyByNo(manageNo);
		System.out.println(book);
		String answer = scanStr("삭제할 도서의 정보가 맞습니까?(Y/N)");
		if(answer == "Y" || answer == "y") {
			System.out.println();
		} else {
			System.exit(0);
		}
		
		
		book = service.deleteByNo(manageNo);
		System.out.println("관리번호 " + manageNo + " 도서가 삭제되었습니다.");

	}

}
