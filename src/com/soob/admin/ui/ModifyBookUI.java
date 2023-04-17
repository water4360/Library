package com.soob.admin.ui;

import com.soob.admin.service.BookService;
import com.soob.admin.vo.BookVO;

public class ModifyBookUI extends BaseUI {

	private BookService service;
	
	public ModifyBookUI() {
		service = new BookService();
	}
	
	
	@Override
	public void run() throws Exception {
		
//		String title = scanStr("수정할 도서명을 입력하세요 : ");
		int searchNo = scanInt("수정할 도서의 관리번호를 입력하세요 : ");
		BookVO book = service.searchOneByNo(searchNo);
		
		System.out.println("-".repeat(70));
		if(book != null) {
			System.out.println("관리번호\t\t\t도 서 명\t\t\t저  자\t출판사\t재고");
			System.out.printf("%d\t%s\t\t%s\t%s\t%d\n"
					, book.getManageNo()
					, book.getTitle()
					, book.getAuthor()
					, book.getPublisher()
					, book.getStock());
		} else {
			System.out.println("[" + searchNo + "]번 도서는 존재하지 않습니다");
		}
			System.out.println("-".repeat(70));
		int selectNo = scanInt("수정할 항목을 선택하세요.\n"
							+ "1.도서명 2.저자 3.출판사 0.수정취소 >> \n");
		System.out.print("");
		
		IModifyQuery mod = null;
		
		switch(selectNo) {
			case 1 :
				mod = new ModifyTitle();
				break;
			case 2 :
//				mod = new ModifyAuthor();
				break;
			case 3 :
				break;
			case 0 :
				break;
		}
			if(mod != null) {
				mod.modify();
			} else {
				
			}
		
	}

}
