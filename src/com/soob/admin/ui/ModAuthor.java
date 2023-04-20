package com.soob.admin.ui;

import com.soob.admin.service.BookService;
import com.soob.admin.service.BookServiceFactory;
import com.soob.main.vo.BookVO;

public class ModAuthor implements IModifyQuery {
	public BookService service;
	
	public ModAuthor() {
		service = BookServiceFactory.getInstance();
	}
	@Override
	public String modify(BookVO book, int searchNo, String str) {
		book = service.searchOneByNo(searchNo);
		
		if(str != null && str.length() > 1) {
			service.modifyTitle(searchNo, str);
			System.out.println("::저자명 수정이 완료되었습니다.");
		} else {
			System.out.println("::잘못된 입력입니다.");
		}
		return str;	
	}

}
