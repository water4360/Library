package com.soob.admin.ui;

import java.util.List;

import com.soob.admin.service.BookService;
import com.soob.admin.service.BookServiceFactory;
import com.soob.admin.vo.BookVO;

public class AllBooksUI extends BaseUI {

	private BookService bookService;
	
	public AllBooksUI() {
		bookService = BookServiceFactory.getInstance();
	}
	
	@Override
	public void run() throws Exception {
		
		List<BookVO> bookList = bookService.showAllBooks();
		
		System.out.println("-".repeat(70));
		System.out.println("관리번호\t\t\t도 서 명\t\t\t저  자\t출판사\t재고");
		System.out.println("-".repeat(70));
		
		if(bookList == null || bookList.size() == 0) {
			System.out.println("\t관리중인 도서가 없습니다");
		} else {
			for(BookVO book : bookList) {
				System.out.printf("%d\t%s\t\t%s\t%s\t%d\n"
									, book.getManageNo()
									, book.getTitle()
									, book.getAuthor()
									, book.getPublisher()
									, book.getStock());
			}
		}
	}

}
