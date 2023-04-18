package com.soob.main.ui;

import java.util.List;

import com.soob.main.service.BookService;
import com.soob.main.service.BookServiceFactory;
import com.soob.main.vo.BookVO;
import com.soob.util.PrintService;

public class TempSearchBooksUI extends BaseUI {

	
	private BookService service;
	private BookVO book;
	
	public TempSearchBooksUI() {
		service = BookServiceFactory.getInstance();
	}
	
	@Override
	public void run() throws Exception {
		
		int menu = scanInt("1.관리번호 2. 도서명 3. 저자명\n"
							+ "도서 검색 방법을 선택하세요 >> ");
		String searchWord;
		List<BookVO> bookList; 
		
		switch(menu) {
		case 1 : 
			//도서번호로 검색하는 경우
			int manageNo = scanInt("검색할 도서의 관리번호를 입력하세요(취소:0) >> ");
			if(manageNo == 0) return;
			
			book = service.searchOneByNo(manageNo);
			
			if(book != null) {
				new PrintService().printTop();
				System.out.print(book);
				new PrintService().printBottom();
			} else {
				System.out.println("::[" + manageNo + "]번 도서는 존재하지 않습니다");
				run();
			}
			break;
			
			
		case 2 :
			//제목으로 검색하는 경우
			searchWord = scanStr("검색할 도서명을 입력하세요(취소:0) >> ");
			if(searchWord == "0") return;
			bookList = service.searchBooks(menu, searchWord);
			new PrintService().printTop();
			if(bookList == null || bookList.size() == 0) {
				System.out.println("\t\t\t\t검색 결과가 없습니다.");
				run();
			} else {
				for(BookVO book : bookList) {
					
					System.out.print(book);
				}
			}
			new PrintService().printBottom();
			break;
			
			
		case 3 :
			//저자명으로 검색하는 경우
			searchWord = scanStr("검색할 저자명을 입력하세요(취소:0) >> ");
			if(searchWord == "0") return;
			bookList = service.searchBooks(menu, searchWord);
			new PrintService().printTop();
			if(bookList == null || bookList.size() == 0) {
				System.out.println("\t\t\t\t검색 결과가 없습니다.");
				run();
			} else {
				for(BookVO book : bookList) {
					
					System.out.print(book);
				}
			}
			new PrintService().printBottom();
			break;
		}
		
		
	}

}
