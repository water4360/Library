package com.soob.admin.modify.ui;

import com.soob.main.vo.BookVO;

public interface IModifyQuery {
	
//	public BookService bookService = BookServiceFactory.getInstance();
	
	public String modify(BookVO book, int menu, int searchNo, String str);
}
