package com.soob.member.service;

import java.text.SimpleDateFormat;
import java.util.List;

import com.soob.member.dao.RentalDAO;
import com.soob.member.vo.RentalVO;

public class RentalService {

	private RentalDAO renDao;
	SimpleDateFormat sdf = new SimpleDateFormat("YY-MM-dd");
	public RentalService() {
		renDao = new RentalDAO();
	}
	
	//대여정보 등록
	public RentalVO addRental(String id, int bookNo) {
		RentalVO ren = renDao.addRental(id, bookNo);
		return ren;
	}

	//반납(대여정보 삭제)
	public void returnBook(String id, int bookNo) {
		renDao.returnBook(id, bookNo);
	}
	
	//사용자 대여목록 보여주기
	public List<RentalVO> getRentalList(String id) {
		List<RentalVO> rentalList = renDao.getRentalList(id);
		return rentalList;
	}
	
	//반납기한 가져오기
	public String getDueDate(int bookNo) {
		return renDao.getDueDate(bookNo);
	}
	
	//연체일수 가져오기
	public int getOverDue(int bookNo) {
		return renDao.getOverDue(bookNo);
	}

	
}
