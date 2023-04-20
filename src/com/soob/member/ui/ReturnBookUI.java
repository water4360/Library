package com.soob.member.ui;

import com.soob.main.service.BookServiceFactory;
import com.soob.main.service.RentalService;
import com.soob.main.ui.BaseUI;
import com.soob.main.vo.BookVO;
import com.soob.main.vo.RentalVO;
import com.soob.member.vo.MemberVO;

public class ReturnBookUI extends BaseUI {

	public ReturnBookUI() {
		//서비스들은 같은 DAO를 불러오는 거.
		service = BookServiceFactory.getInstance();
		renService = new RentalService();
	}
	
	
	@Override
	public void run() throws Exception {
		
		System.out.println("<"+MemberVO.getId()+ "님이 대출중인 도서>");
		int bookNo = scanInt("반납할 도서를 선택해주세요 >> ");
		renService.returnBook(bookNo);
		
//		System.out.println("현재 접속중인 정보는 ?");
//		System.out.println("ID : " + mem.getId());
		
		//관리번호로 책 정보 찾아와서
		BookVO book = service.searchOneByNo(bookNo);
		
		//도서가 있고
		if(book != null) {
			p.printTop();
			System.out.print(book);
			p.printBottom();
			
			String answer = scanStr("해당 도서가 맞나요? (Y/N)");
			
			//맞다고 답하면
			if(answer.equalsIgnoreCase("Y")) {
				//대출불가로 변경
				book.setManageNo(bookNo);
				book.setStatus(5);
				
				//RENTAL테이블에서 대출정보 삭제
				renService.returnBook(MemberVO.getId(), bookNo);
//				System.out.println("현재 멤버 아이디 : " + MemberVO.getId());
//				System.out.println("대출 후 book : " + book);
				
			}
			
			//렌탈 테이블의 RENT_ID에 멤버 ID를 넣고
			//렌탈 테이블에 멤버 정보를 넣고...
			//북테이블에 재고 빼기. 
			
			//반납일 설정용
//			Calendar calendar = Calendar.getInstance();
//			calendar.add(Calendar.DATE, 3);
			
			System.out.printf("%d : <%s> 도서가 대여되었습니다.    ", book.getManageNo(), book.getTitle());
			System.out.printf("(대여기간 : 3일/반납일 : %tY/%tm/%td)\n",
							RentalVO.getDueDate(),RentalVO.getDueDate(),RentalVO.getDueDate());
			
		} else {
			System.out.println("일치하는 도서 정보가 없습니다.");
		}
	}

}
