package com.soob.admin.ui;

import com.soob.admin.service.BookService;
import com.soob.admin.service.BookServiceFactory;
import com.soob.main.ui.BaseUI;
import com.soob.main.vo.BookVO;
import com.soob.util.PrintService;

public class RegisterUI extends BaseUI {

	public RegisterUI() {
	}
	
	
	@Override
	public void run() throws Exception {

		String title = scanStr("도서명을 입력하세요 >> ");
		String author = scanStr("저자명을 입력하세요 >> ");
		String publisher = scanStr("출판사명을 입력하세요 >> ");
		
		String answer = scanStr("입력하신 정보로 도서를 등록할까요?(Y/N)");
//		int stock = scanInt("입고 수량을 입력하세요 (취소:0) >> ");
		
		if(answer.equalsIgnoreCase("N")) {
			System.out.println("신규도서 등록을 취소하고 초기메뉴로 돌아갑니다.");
			return;
		}
		
		BookVO book = new BookVO();
		book.setTitle(title);
		book.setAuthor(author);
		book.setPublisher(publisher);
//		book.setStock(stock);
		
		bookService.addBook(book);
		
		new PrintService().printTop();
		System.out.print(book);
		new PrintService().printBottom();
		System.out.println("::신규 도서 등록을 완료하였습니다");
	}

}
