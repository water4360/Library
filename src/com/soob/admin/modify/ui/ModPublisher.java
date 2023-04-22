package com.soob.admin.modify.ui;

import com.soob.main.service.BookService;
import com.soob.main.service.BookServiceFactory;
import com.soob.main.vo.BookVO;

public class ModPublisher implements IModifyQuery {
	
	private BookService bookService;
	
	public ModPublisher() {
		bookService = BookServiceFactory.getInstance();
	}
	
	@Override
	public String modify(BookVO book, int menu, int manageNo, String str) {
		book = bookService.searchOneByNo(manageNo);
		
		if(str != null && str.length() > 1) {
			bookService.modifyBook(menu, manageNo, str);
			System.out.println("::출판사명 수정이 완료되었습니다.");
		} else {
			System.out.println("::잘못된 입력입니다.");
		}
		return str;
	}

}
