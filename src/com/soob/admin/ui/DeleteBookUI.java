package com.soob.admin.ui;

import com.soob.admin.service.BookService;
import com.soob.admin.vo.BookVO;

public class DeleteBookUI extends BaseUI {
	
	private BookService service;
	
	public DeleteBookUI() {
		service = new BookService();
	}

	@Override
	public void run() throws Exception {
		BookVO book = null;
		int manageNo = scanInt("삭제할 도서의 관리번호를 입력하세요 : ");
		//맞는지 확인?
		book = service.searchOneByNo(manageNo);
		
		System.out.println("-".repeat(70));
		System.out.println("관리번호\t\t\t도 서 명\t\t\t저  자\t출판사\t재고");
		System.out.println(book);
		System.out.println("-".repeat(70));
		String answer = "";
		if(book != null) {
			answer = scanStr("삭제할 도서의 정보가 맞습니까?(Y/N) >> ");
		} else {
			System.out.println(">> 입력하신 관리번호가 존재하지 않습니다. 다시 입력해주세요.");
			run();
		}
		if(answer.equals("Y") || answer.equals("y")) {
			book = service.deleteByNo(manageNo);
		} else {
			System.out.println("삭제를 취소하고 냅다 종료합니다.");
			System.exit(0);
		}
		
		
		book = service.deleteByNo(manageNo);
		System.out.println("관리번호 " + manageNo + " 도서가 삭제되었습니다.");

	}

}
