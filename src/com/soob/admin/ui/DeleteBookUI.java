package com.soob.admin.ui;

import com.soob.main.service.BookServiceFactory;
import com.soob.main.ui.BaseUI;
import com.soob.main.vo.BookVO;

public class DeleteBookUI extends BaseUI {
	
	public DeleteBookUI() {
		bookService = BookServiceFactory.getInstance();
	}

	@Override
	public void run() throws Exception {
		int manageNo = 99;
		
		try {
			manageNo = scanInt("삭제할 도서번호를 입력하세요 >> ");
		} catch (Exception e) {
			System.out.println("::잘못된 입력입니다. 다시 입력해주세요.");
			run();
		}
		BookVO book = bookService.searchOneByNo(manageNo);
		String answer = "";
		
		if(book != null) {
			p.printTop();
			System.out.print(book);
			p.printBottom();
			answer = scanStr("삭제할 도서의 정보가 맞나요?(Y/N) >> ");
			//나중에, 만약 대출중인 책이라면(상태코드 5미만) 삭제되지 않도록 안내!!
			if(book.getStatus()==0) {
				System.out.println("::해당 도서는 현재 대출중이므로 삭제할 수 없어요.");
				System.out.println();
			}
		} else {
			System.out.println("::입력하신 도서번호가 존재하지 않습니다. 다시 입력해주세요.");
			//관리번호가 없으면 다시 입력받음.
			run();
		}
		if(answer.equalsIgnoreCase("Y")) {
			//관리번호가 맞으면 삭제 진짜로 실행.
			book = bookService.deleteBook(manageNo);
		} else {
			System.out.println("::삭제를 취소하고 초기 메뉴로 돌아갈게요.");
			System.out.println();
			return;			
		}
		
		
		book = bookService.deleteBook(manageNo);
		System.out.println("::도서번호 " + manageNo + " 도서가 삭제되었습니다.");
		System.out.println();

	}

}
