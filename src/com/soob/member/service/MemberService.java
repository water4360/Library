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

	//0. ID 중복 체크 메소드
	public boolean isDuplicated(String id) {
		return memDao.isDuplicatedId(id);
	}
	
	//1. 회원 정보를 DB에 추가해주는 메소드
	public void addMember(MemberVO mem) {
		memDao.addMember(mem);
	}

	//ID, PW 둘 다 일치하는지 확인하는 메소드
	public boolean isCorrectInfo(String id, String pw) {
		return memDao.isCorrectInfo(id, pw);
	}

	//ID,PW로 회원코드 확인
	public int getMemberCode(String id, String pw) {
		return memDao.getMemberCode(id, pw);
	}

	//아이디로 회원정보 찾기
	public MemberVO getMemberById(String id) {
		return memDao.getMemberById(id);
	}
	
	//전체 회원 보기(관리자용)
	public List<MemberVO> getAllMembers() {
		return memDao.getAllMembers();
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
