package com.soob.main.service;

import java.util.List;

import com.soob.main.dao.BookDAO;
import com.soob.main.vo.BookVO;

public class BookService {

	//BookService로 따로 빼주는 이유는
	//매번 bookDAO를 new 생성하면 데이터 다 날아감~~
	//공통된 테이블에서 유지되는 데이터를 가져오기 위해서임
	private BookDAO bookDao;
	
	
	public BookService() {
			bookDao = new BookDAO();
	}
	
	//2. 모든 bookList를 보여주는 메소드
	public List<BookVO> showAllBooks() {
		List<BookVO> bookList = bookDao.showAllBooks();
		return bookList;
	}

	//3. 번호로 찾아서 보여주는 메소드(일단 단일)
	public BookVO searchOneByNo(int manageNo) {
		BookVO book = bookDao.searchOneBook(manageNo);
		return book;
	}
	
	//3-2 메뉴에 따라 도서명/저자명 검색
	public List<BookVO> searchBooks(int menu, String str) {
		List<BookVO> bookList = bookDao.searchBooks(menu, str);
		return bookList;
	}
	
	//도서명,저자명,출판사명
	public String getTitle(int bookNo) {
		return bookDao.getTitle(bookNo);
	}
	public String getAuthor(int bookNo) {
		return bookDao.getAuthor(bookNo);
	}
	public String getPublisher(int bookNo) {
		return bookDao.getPublisher(bookNo);
	}
}
