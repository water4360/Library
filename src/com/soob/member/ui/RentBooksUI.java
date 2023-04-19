package com.soob.member.ui;

import com.soob.admin.service.BookService;
import com.soob.admin.ui.BaseUI;
import com.soob.admin.vo.BookVO;

public class RentBooksUI extends BaseUI {

	private BookService service;
	private BookVO book;	
	
	
	@Override
	public void run() throws Exception {
		
		if(book != null) {
			System.out.println("대여할 도서");
			
		}
	}

}
