package com.soob.admin.service;

import java.util.List;

import com.soob.admin.dao.NoticeDAO;
import com.soob.admin.vo.NoticeVO;

public class NoticeService {

	private NoticeDAO noticeDao;
	
	//기본 객체 소환자
	public NoticeService() {
		noticeDao = new NoticeDAO();
	}
	
	
	//1. 공지등록
	public void addNotice(String str) {
		noticeDao.addNotice(str);
	}
	
	//2. 공지가져오기
	public List<NoticeVO> getNotice() {
		List<NoticeVO> notice = noticeDao.getNotice();
		return notice;
	}
	
	//3. 공지삭제
	public void delNotice(int no) {
		noticeDao.delNotice(no);
	}
}

