package com.soob.member.ui;

import java.util.List;

import com.soob.main.service.BookServiceFactory;
import com.soob.main.ui.BaseUI;
import com.soob.main.vo.BookVO;
import com.soob.main.vo.RentalVO;
import com.soob.member.vo.MemberVO;

public class ReturnBookUI extends BaseUI {

	private BookVO book;
	
	public ReturnBookUI() {
		//서비스들은 같은 DAO를 불러오는 거.
		service = BookServiceFactory.getInstance();
		RentalVO ren = new RentalVO();
	}
	
	@Override
	public void run() throws Exception {
		System.out.println("<"+MemberVO.getId()+ "님이 대여중인 도서목록입니다.>");
		List<RentalVO> bookList = renService.getRentalList(MemberVO.getId());
		
		p.rentalTop();
		
		if(bookList.size() == 0) {
			System.out.println("대여중인 도서가 없습니다.");
		} else {
			for(RentalVO book : bookList) {
				System.out.print(book);
			}
			p.rentalBottom();
		}
		
		int bookNo = scanInt("반납할 도서번호를 선택해주세요 >> ");
//		System.out.println("현재 접속중인 정보는 ?");
//		System.out.println("ID : " + MemberVO.getId());
	
			book = service.searchOneByNo(bookNo);
			
			if(book==null) {
				System.out.println("도서번호가 올바르지 않습니다.");
			} else {
				String answer = scanStr("반납할 도서 정보가 맞나요? (Y/N)");
				if(answer.equalsIgnoreCase("Y")) {

					//대출가능으로 변경
					service.changeStatus(5, bookNo);
//				book.setManageNo(bookNo);
//				book.setStatus(0);
					
					//RENTAL테이블에서 대출정보 수정
					renService.returnBook(MemberVO.getId(), bookNo);
//				System.out.println("현재 멤버 아이디 : " + MemberVO.getId());
//				System.out.println("대출 후 book : " + book);
					
			System.out.printf("%d : <%s> 도서반납이 완료되었습니다.    \n", book.getManageNo(), book.getTitle());
			}
		}
		
	}

}
