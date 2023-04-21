package com.soob.main.service;

import java.util.List;

import com.soob.main.dao.RentalDAO;
import com.soob.main.vo.RentalVO;

public class RentalService {

	private RentalDAO renDao;
	
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
	
	
	
}
