package com.soob.admin.ui;

import java.util.List;

import com.soob.admin.service.BookService;
import com.soob.admin.service.BookServiceFactory;
import com.soob.main.vo.BookVO;
import com.soob.util.PrintService;

public class AllBooksUI extends BaseUI {

	private BookService bookService;
	
	public AllBooksUI() {
		bookService = BookServiceFactory.getInstance();
	}
	
	@Override
	public void run() throws Exception {
		
		List<BookVO> bookList = bookService.showAllBooks();
		
		new PrintService().printTop();
		
		if(bookList == null || bookList.size() == 0) {
			System.out.println("\t관리중인 도서가 없습니다");
		} else {
			for(BookVO book : bookList) {
				System.out.print(book);
			}
		}
		new PrintService().printBottom();
	}

}
