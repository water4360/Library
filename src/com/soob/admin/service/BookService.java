package com.soob.admin.service;

import java.util.List;

import com.soob.admin.dao.BookDAO;
import com.soob.main.vo.BookVO;

public class BookService {
//
//	//BookService로 따로 빼주는 이유는
//	//매번 bookDAO를 new 생성하면 데이터 다 날아감~~
//	//공통된 테이블에서 유지되는 데이터를 가져오기 위해서임
//	private BookDAO bookDao;
//	
//	
//	public BookService() {
//			bookDao = new BookDAO();
//	}
//	
//	//1. bookDao단계에서 모아준 데이터를 추가해주는 메소드
//	public void addBook(BookVO book) {
//		bookDao.addBook(book);
//	}
//	
//	
//	//2. 모든 bookList를 보여주는 메소드
//	public List<BookVO> showAllBooks() {
//		List<BookVO> bookList = bookDao.showAllBooks();
//		return bookList;
//	}
//
//	//3. 번호로 찾아서 보여주는 메소드(일단 단일)
//	public BookVO searchOneByNo(int manageNo) {
//		BookVO book = bookDao.searchOneBook(manageNo);
//		return book;
//	}
//	
//	//4. 번호로 찾아서 삭제하는 메소드
//	public BookVO deleteByNo(int manageNo) {
//		BookVO book = bookDao.deleteBook(manageNo);
//		return book;
//	}
//	
//	//5. 번호로 찾아서 수정하는 메소드
//	public BookVO modifyTitle(int manageNo, String str) {
//		BookVO book = bookDao.modifyTitle(manageNo, str);
//		return book;
//	}
//	
//
//	//다중
////	public List<BookVO> modifyByNo(int manageNo) {
////		List<BookVO> bookList = bookDao.searchBooks(manageNo);
////		return bookList;
////	}
	
}
