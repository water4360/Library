package com.soob.main.ui;

import java.util.List;

import com.soob.main.service.BookService;
import com.soob.main.service.BookServiceFactory;
import com.soob.main.vo.BookVO;
import com.soob.util.PrintService;

public class TempAllBooksUI extends BaseUI{
	
	private BookService bookService;
	
	public TempAllBooksUI() {
		bookService = BookServiceFactory.getInstance();
//		System.out.println(" >>>>>>>>> TempAllBooksUI 진입");
	}

	@Override
	public void run() throws Exception {
		List<BookVO> bookList = bookService.showAllBooks();
		
		new PrintService().printTop();
		
		if(bookList == null || bookList.size() == 0) {
			System.out.println("\t도서 목록이 없습니다.");
			System.out.println("\t관리자에게 문의하세요.");
		} else {
			for(BookVO book : bookList) {
				System.out.print(book);
			}
			new PrintService().printBottom();
		}
		
		
		
		
		
		
	}
}

