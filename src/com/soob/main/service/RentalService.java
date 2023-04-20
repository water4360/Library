package com.soob.main.service;

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
	
}
