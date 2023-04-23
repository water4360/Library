package com.soob.member.ui;

import java.util.List;

import com.soob.main.service.BookServiceFactory;
import com.soob.main.ui.BaseUI;
import com.soob.main.vo.BookVO;
import com.soob.member.vo.MemberVO;
import com.soob.member.vo.RentalVO;

public class ReturnBookUI extends BaseUI {

	private BookVO book;
	
	public ReturnBookUI() {
		//서비스들은 같은 DAO를 불러오는 거.
		bookService = BookServiceFactory.getInstance();
	}
	
	@Override
	public void run() throws Exception {
		List<RentalVO> bookList = renService.getRentalList(MemberVO.getId());
		
		if(bookList.size() == 0) {
			System.out.println("::대여중인 도서가 없습니다. 흥미있는 도서를 대여해보세요 :)");
			System.out.println();
		} else {
//			p.rentalBottom();
			System.out.printf("\t\t\t\t\t<%s님이 대여중인 도서목록>\n", MemberVO.getId());
			
			p.rentalTop();
			for(RentalVO ren : bookList) {
				System.out.print(ren);
			}
			p.rentalBottom();
			int bookNo = 0;
			try {
				bookNo = scanInt("반납할 도서번호를 선택해주세요(취소:0) >> ");
				if(bookNo == 0) return;
				
			} catch (Exception e) {
				System.out.println("::잘못된 입력입니다.");
				System.out.println();
			}
//		System.out.println("현재 접속중인 정보는 ?");
//		System.out.println("ID : " + MemberVO.getId());
			
			book = bookService.searchOneByNo(bookNo);
			
			if(book==null) {
				System.out.println("::도서번호가 올바르지 않아요.");
				System.out.println();
			} else {
				String answer = scanStr("해당 도서를 반납할까요? (Y/N)");
				if(answer.equalsIgnoreCase("Y")) {
					
					//대출가능으로 변경
					bookService.changeStatus(1, bookNo);
					//RENTAL테이블에서 대출정보 수정
					renService.returnBook(MemberVO.getId(), bookNo);
//				System.out.println("현재 멤버 아이디 : " + MemberVO.getId());
//				System.out.println("대출 후 book : " + book);
					
					System.out.printf("::%d : <%s> 도서반납이 완료되었습니다.    \n", book.getManageNo(), book.getTitle());
					System.out.println();
				}
			}
		}
		
		
	}

}
