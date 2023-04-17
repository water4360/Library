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
		
		bookService.addBook(book);
		System.out.println("-".repeat(70));
		System.out.println("관리번호\t\t\t도 서 명\t\t\t저  자\t출판사\t재고");
		System.out.println("-".repeat(70));
		System.out.println(book);
		System.out.println(">> 신규 도서 등록을 완료하였습니다.");
	}

}
