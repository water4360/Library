package com.soob.main.ui;

import java.util.List;

import com.soob.main.service.BookService;
import com.soob.main.service.BookServiceFactory;
import com.soob.main.vo.BookVO;

public class SearchBookUI extends BaseUI {

	private BookService service;
	private BookVO book;
	
	public SearchBookUI() {
		service = BookServiceFactory.getInstance();
	}
	
	@Override
	public void run() throws Exception {
		int menu = 0;
		
		try {
			menu = scanInt("[1]관리번호 [2]도서명 [3]저자명\n"
					+ "도서 검색 방법을 선택하세요 >> ");
		} catch (Exception e) {
			System.out.println("::잘못된 입력입니다. 다시 입력해주세요.");
			run();
		}
		String searchWord;
		List<BookVO> bookList; 
		
		switch(menu) {
		default :
			System.out.println("::해당 메뉴는 존재하지 않아요.");
			break;
		case 1 : 
			//도서번호로 검색하는 경우
			int manageNo = scanInt("검색할 도서의 관리번호를 입력하세요 [0]취소 >> ");
			if(manageNo == 0) return;
			
			book = service.searchOneByNo(manageNo);
			
			//책이 있으면?
			if(book != null) {
				p.printTop();
				System.out.print(book);
				p.printBottom();
			} else {
				System.out.println("::[" + manageNo + "]번 도서는 존재하지 않습니다");
				run();
			}
			break;
			
		case 2 :
			//제목으로 검색하는 경우
			searchWord = scanStr("검색할 도서명을 입력하세요 [0]취소 >> ");
			if(searchWord.equals("0")) {
				System.out.println("입력취소. 메뉴를 다시 선택해주세요.");
				return;
			} else {
				bookList = service.searchBooks(menu, searchWord);
			
				p.printTop();
				if(bookList == null || bookList.size() == 0) {
					System.out.println("\t\t\t\t검색 결과가 없습니다.");
					run();
				//책이 있으면?
				} else {
					for(BookVO book : bookList) {
						System.out.print(book);
					}
				}
				p.printBottom();
			}
			break;
			
		case 3 :
			//저자명으로 검색하는 경우
			searchWord = scanStr("검색할 저자명을 입력하세요(취소:0) >> ");
			if(searchWord.equals("0")) {
				System.out.println("입력취소. 메뉴를 다시 선택해주세요.");
				return;
			} else {
				bookList = service.searchBooks(menu, searchWord);

				p.printTop();

				if(bookList.size() == 0) {
					System.out.println("\t\t\t\t검색 결과가 없습니다.");
					run();
					//책이 있으면?
				} else {
					for(BookVO book : bookList) {
						System.out.print(book);
					}
				}
				p.printBottom();
			}
			break;
		}
		
	}

}
