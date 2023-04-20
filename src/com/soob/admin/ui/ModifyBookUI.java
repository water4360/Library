package com.soob.admin.ui;

import com.soob.admin.service.BookServiceFactory;
import com.soob.main.vo.BookVO;

public class ModifyBookUI extends BaseUI {

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
			p.printTop();
			System.out.print(book);
		} else {
			System.out.println("::[" + searchNo + "]번 도서는 존재하지 않습니다");
			run();
		}
		p.printBottom();
		int selectNo = scanInt("1.도서명 0.수정취소\n수정할 항목을 선택하세요 >> ");
		
		if(selectNo!=1 && selectNo!=0) {
			System.out.println("::잘못입력하셨습니다");
			run();
		}
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
					System.out.println("::올바른 수정내용이 아닙니다.");
					run();
				}
				
			} else {
				
			}
		
	}

}
