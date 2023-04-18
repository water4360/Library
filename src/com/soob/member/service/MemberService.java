package com.soob.member.service;

import java.util.List;

import com.soob.member.dao.MemberDAO;
import com.soob.member.vo.MemberVO;


public class MemberService {

	//MemService를 왜 빼준다고??
	//매번 MemDAO를 new 생성하면 데이터 다 날아가니까~~
	//공통된 테이블에서 유지되는 데이터를 가져오기 위해서라고~~
	private MemberDAO memDao;
	
	public MemberService() {
			memDao = new MemberDAO();
	}

	//1. 회원 정보를 DB에 추가해주는 메소드
	public void addMember(MemberVO mem) {
		memDao.addMember(mem);
	}
	
	//2. 모든 bookList를 보여주는 메소드
//	public List<MemberVO> showAllBooks() {
//		List<MemberVO> bookList = memDao.showAllMems();
//		return bookList;
//	}
//
//	//3. 번호로 찾아서 보여주는 메소드(일단 단일)
//	public MemberVO searchOneyNo(int manageNo) {
//		MemberVO book = memDao.searchOneBook(manageNo);
//		return book;
//	}
//	
//	//3-2 메뉴에 따라 도서명/저자명 검색
//	public List<MemberVO> searchBooks(int menu, String str) {
//		List<MemberVO> bookList = memDao.searchBooks(menu, str);
//		return bookList;
//	}
//	
}
