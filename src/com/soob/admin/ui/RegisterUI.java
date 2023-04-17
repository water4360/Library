package com.soob.admin.ui;

import com.soob.admin.service.BookService;
import com.soob.admin.service.BookServiceFactory;
import com.soob.admin.vo.BookVO;

public class RegisterUI extends BaseUI {

	private BookService bookService;
	
	public RegisterUI() {
		//일단 만들어놓고 나중에 이 자리에 서비스 호출할...
		bookService = BookServiceFactory.getInstance();
	}
	
	
	@Override
	public void run() throws Exception {

		String title = scanStr("도서명을 입력하세요 : ");
		String author = scanStr("저자명을 입력하세요 : ");
		String publisher = scanStr("출판사명을 입력하세요 : ");
		int stock = scanInt("입고 수량을 입력하세요 : ");
		
		BookVO book = new BookVO();
		book.setTitle(title);
		book.setAuthor(author);
		book.setPublisher(publisher);
		book.setStock(stock);
		
		System.out.println(">> 신규 도서 등록을 완료하였습니다.");
		bookService.addBook(book);
		
		//등록한 도서 보여줌
		System.out.println(book);
	}

}
