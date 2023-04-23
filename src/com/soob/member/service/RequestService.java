package com.soob.member.service;

import java.util.List;

import com.soob.member.dao.RequestDAO;
import com.soob.member.vo.RequestVO;

public class RequestService {

	private RequestDAO reqDao;
	
	//기본 객체 소환자
	public RequestService() {
		reqDao = new RequestDAO();
	}
	
	
	//1. 게시글등록
	public void addRequest(String str) {
		reqDao.addRequest(str);
	}
	
	//2. 관리자가 게시글 전부 보기
	public List<RequestVO> getRequest() {
		List<RequestVO> notice = reqDao.getRequest();
		return notice;
	}
	
	//3. 회원이 게시글삭제 - 일단 보류
	public void delRequest(int no) {
		reqDao.delRequest(no);
	}
}

