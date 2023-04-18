package com.soob.admin.ui;

import com.soob.admin.service.BookService;
import com.soob.admin.service.BookServiceFactory;
import com.soob.admin.vo.BookVO;

public class ModTitle implements IModifyQuery {
	public BookService service;
	
	public ModTitle() {
		service = BookServiceFactory.getInstance();
	}

	@Override
	public String modify(BookVO book, int manageNo, String str) {
		book = service.searchOneByNo(manageNo);
		//입력받은 str이 null이 아니고 1글자 이상이어야.
		if(str != null && str.length() > 1) {
			service.modifyTitle(manageNo, str);
			System.out.println("::도서명 수정이 완료되었습니다.");
		} else {
			System.out.println("::잘못된 입력입니다.");
		}
		return str;
	}

}
