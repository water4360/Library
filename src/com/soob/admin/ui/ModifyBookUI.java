package com.soob.admin.ui;

import com.soob.admin.service.BookService;
import com.soob.admin.service.BookServiceFactory;
import com.soob.admin.vo.BookVO;
import com.soob.util.PrintService;

public class ModifyBookUI extends BaseUI {

	private BookService service;
	private BookVO book;
	
	public ModifyBookUI() {
		service = BookServiceFactory.getInstance();
	}
	
	
	@Override
	public void run() throws Exception {
		
//		String title = scanStr("수정할 도서명을 입력하세요 : ");
		int searchNo = scanInt("수정할 도서의 관리번호를 입력하세요(취소:0) >> ");
		if(searchNo == 0) return;
		
		book = service.searchOneByNo(searchNo);
		
		if(book != null) {
//			System.out.println("-".repeat(85));
//			System.out.println("관리번호\t\t\t도 서 명\t\t\t저  자\t출판사\t재고\t상태코드\t대출가능");
			new PrintService().printTop();
			System.out.print(book);
		} else {
			System.out.println("::[" + searchNo + "]번 도서는 존재하지 않습니다");
			run();
		}
		new PrintService().printBottom();
		int selectNo = scanInt("1.도서명 0.수정취소\n수정할 항목을 선택하세요 >> ");
//		int selectNo = scanInt("1.도서명 2.저자 3.출판사 0.수정취소\n수정할 항목을 선택하세요 >> ");
//		System.out.print("");
		
		IModifyQuery mod = null;
		
		switch(selectNo) {
			case 1 :
				mod = new ModTitle();
				break;
			case 2 :
//				mod = new ModAuthor();
				break;
			case 3 :
//				mod = new ModPublisher();
				break;
			case 0 :
			default :
				break;
		}
			//mod가 선택됐고 1~3번 문자열 수정항목이면
			if(mod != null && selectNo <= 3) {
				String str = mod.modify(book, searchNo, scanStr("수정할 내용을 입력하세요 >> "));
				if(str == "") {
					run();
				}
				
			} else {
				
			}
		
	}

}
