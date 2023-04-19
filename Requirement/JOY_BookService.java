package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.dao.BookDAO;
import kr.ac.kopo.vo.BookVO;
//이런 서비스는 DB를 사용하게 되면 필요가 없어짐
//boardService 객체는 늘 하나만 만들어져야하는데 ....
public class BookService {

	private BookDAO bookdao;
	
	public BookService() {
		bookdao = new BookDAO();
	}

	public void insertBook(BookVO book) {
	
		/*
		System.out.println("---- service ----");
		System.out.println(board);
		
		//게시물 일련번호 저장
		board.setNo(BoardSequence.getBoardNO());//시퀀스에서 일련번호를 가져오기만 하면 되므로 이렇게 쓰면 됨 아래에서 말한 클래스를 생성해 만들어진 메소드호출
		
		//현재 시간 저장
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//regDate를 추가하기 위한 항목을 생성
		board.setRegDate(sdf.format(new Date()));//게시물 번호는 static이어야 할것(하나씩 계속 증가해야하니까...그래서 게시물 번호를 따로 추출가능한 클래스를 따로 만들 예정)
	*/ 
		bookdao.insertBook(book);//위 항목이 추가된 것을 boardDao에 넘겨주는 것
	}
	
	public List<BookVO> selectAll() {//매개변수가 없는 형태로 날아가야함 서비스는 searchallui에게서 받은걸 dao에 토스만 하면 됨 
		List<BookVO> bookList = bookdao.selectAllbook();//리턴값은 리스트여야 할것이고 날아오는 파라미터의 값도 0일것...
		return bookList;
	}
	
	
	public BookVO selectByIsbn(String isbn) {
		BookVO book = bookdao.selectByIsbn(isbn);//해당번호에 대한 게시글을 얻어오려는 것
		return book;
	}
	
	public BookVO selectByTitle(String title) {
		BookVO book = bookdao.selectByTitle(title);//해당번호에 대한 게시글을 얻어오려는 것
		return book;
	}

	public BookVO selectByWriter(String writer) {
		BookVO book = bookdao.selectByWriter(writer);//해당번호에 대한 게시글을 얻어오려는 
		return book;
	}
	
	public int selectByIssbn(String isb) {
		return bookdao.selectByIssbn(isb);
	}
	
	
}
