package com.soob.main.ui;

import java.util.List;

import com.soob.main.service.BookServiceFactory;
import com.soob.main.vo.BookVO;

public class AllBooksUI extends BaseUI{
	
	public AllBooksUI() {
		bookService = BookServiceFactory.getInstance();
//		System.out.println(" >>>>>>>>> TempAllBooksUI 진입");
	}

	@Override
	public void run() throws Exception {
		List<BookVO> bookList = bookService.showAllBooks();
		
		p.printTop();
		
		if(bookList == null || bookList.size() == 0) {
			System.out.println("\t도서 목록이 없습니다.");
			System.out.println("\t관리자에게 문의하세요.");
		} else {
			for(BookVO book : bookList) {
				System.out.print(book);
			}
			p.printBottom();
		}
		
	}
}

