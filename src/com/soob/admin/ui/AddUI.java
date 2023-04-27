package com.soob.admin.ui;

import com.soob.main.ui.BaseUI;
import com.soob.main.vo.BookVO;

public class AddUI extends BaseUI {

	public AddUI() {
	}
	
	
	@Override
	public void run() throws Exception {
		String title = scanStr("도서명을 입력하세요 >> ");
		String author = scanStr("저자명을 입력하세요 >> ");
		String publisher = scanStr("출판사명을 입력하세요 >> ");
		
		String answer = scanStr("입력하신 정보로 도서를 등록할까요?(Y/N)");
		
		if(answer.equalsIgnoreCase("N")) {
			System.out.println("::신규도서 등록을 취소하고 초기메뉴로 돌아갑니다.");
			System.out.println();
			return;
		} else {
			BookVO book = new BookVO();
			book.setManageNo(230000);
			book.setTitle(title);
			book.setAuthor(author);
			book.setPublisher(publisher);
			book.setStatus(1);
			
			bookService.addBook(book);
		}
		
		p.addTop();
		System.out.printf("%-25s\t\t%-8s\t\t\t%-10s\n"
				, title
				, author
				, publisher);
		p.printBottom();		
		System.out.println("::신규 도서 등록을 완료하였습니다");
		System.out.println();
	}

}
