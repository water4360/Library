package com.soob.member.ui;

import com.soob.main.service.BookService;
import com.soob.main.service.BookServiceFactory;
import com.soob.main.service.RentalService;
import com.soob.main.ui.BaseUI;
import com.soob.main.vo.BookVO;
import com.soob.main.vo.RentalVO;
import com.soob.member.vo.MemberVO;

public class RentBookUI extends BaseUI {

	private BookService bookService;
	private BookVO book;
	private RentalService renService;
	private RentalVO ren;
	
	public RentBookUI() {
		//서비스들은 같은 DAO를 불러오는 거.
		bookService = BookServiceFactory.getInstance();
		renService = new RentalService();
		ren = new RentalVO();
	}
	
	
	@Override
	public void run() throws Exception {
		int bookNo = 0;
		try {
			bookNo = scanInt("대여할 도서번호를 입력해주세요 >> ");
		} catch (Exception e) {
			System.out.println(getClass().getSimpleName() + " : 올바른 도서번호가 아닙니다.");
		}
//		System.out.println("현재 접속중인 정보는 ?");
//		System.out.println("ID : " + mem.getId());
		
		//관리번호로 책 정보 찾아와서
		BookVO book = bookService.searchOneByNo(bookNo);
		
		//도서가 있으면
		if(book != null) {
			p.printTop();
			System.out.print(book);
			p.printBottom();
			
			//대출불가인 상태라면
			if(book.getStatus()==0) {
				System.out.println("::다른 사용자가 대여중인 도서입니다.");
				run();
			} else {
				String answer = scanStr("해당 도서를 대여할까요? (Y/N)");
				//맞다고 답하면
				if(answer.equalsIgnoreCase("Y")) {
					//RENTAL테이블에 대출정보 추가
					renService.addRental(MemberVO.getId(), bookNo);
					
					//BOOKLIST테이블에 대출불가(0) 추가
					//RENTAL 테이블에 회원정보(ID) 추가
					bookService.changeStatus(0, bookNo);
					renService.getRentalList(MemberVO.getId());
				}
				System.out.printf("::%d : <%s> 도서가 대여되었습니다.    ", book.getManageNo(), book.getTitle());
				System.out.printf("(대여기간 : 3일/반납기한 : %s)\n", ren.getDueDate());
			}
		} else {
			System.out.println("::일치하는 도서 정보가 없습니다.");
		}
	}

}
