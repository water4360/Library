package kr.ac.kopo.ui;

import java.util.List;

import kr.ac.kopo.LibraryServiceFactory;
import kr.ac.kopo.service.BookService;
import kr.ac.kopo.vo.BookVO;

public class AddBookUI extends BaseUI {
//게시글이라는 것을 추상화 시켜서....객체화 시킬 수 있을 것 dto 혹은 vo로 쓴다...밸류오브젝트???
	//private BookDAO boardDao;
	private BookService bookService;
	
	public AddBookUI(){
	 bookService = LibraryServiceFactory.getbokInstance();//얘 필요함??
	}
	
	@Override
	public void execute() throws Exception {
		List<BookVO> bookList = bookService.selectAll();
		//제목하고 작성자만 입력받는 것 그러니 아래 두개만 있으면 됨
		BookVO bookisbn = null;
		String isbn = scanStr("ISBN을 입력하세요 :");
//		bookisbn = bookService.selectByIssbn(isbn);
		
		
		if(bookService.selectByIssbn(isbn) != 0) {
			System.out.println("입력하신 ISBN 번호가 존재합니다");
			System.exit(0);
		} else {
		String title = scanStr("등록할 제목을 입력하세요 : ");
		String writer = scanStr(" 저자를 입력하세요 : ");
		int daeyoo = scanInt("도서 대출 여부를 입력하세요(반출: 0| 반납: 1) : ");
		
		
		BookVO book = new BookVO();
		book.setIsbn(isbn);
		book.setTitle(title);
		book.setWriter(writer);
		book.setDaeyeo(daeyoo);
		
		bookService.insertBook(book);
		//boardDao에 타이틀과 작성자를 넣는걸 해줘 입력되는 항목이나 타입이 달라지면 문제가 많이 발생할것 몇개가 바뀔지 아무도 모르지만 boardvo라는 게시글 리스트를 만드는게
		//따라서 위처럼 타이틀과 롸이터 값을 넣어 감싸고 있는 boardvo타입 객체를 넘겨버리겠다는 것...
		System.out.println("도서를 등록 완료하였습니다");
		//제목과 글쓴이가 입력되면 등록완료했다는 걸 알려줌 왜냐면 UI클래스가 하는 일은 입출력일 뿐이므로 입력만 받고 등록되었다는 것만 알려주면 그만임
		}
	}


}
