package com.soob.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.soob.main.service.BookService;
import com.soob.main.vo.BookVO;
import com.soob.main.vo.RentalVO;
import com.soob.util.ConnectionFactory;

/**
 * 오라클 DB의 T_RENTAL
 * @author User
 *
 */


public class RentalDAO {
	
	private BookService service;
	
	//대여정보 등록
	public RentalVO addRental(String id, int bookNo) {
		service = new BookService();
		RentalVO ren = new RentalVO();
		service.searchOneByNo(bookNo);
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO T_RENTAL(NO, TITLE, AUTHOR, PUBLISHER, RENT_ID) ");
		sql.append("            VALUES(?, ?, ?, ?, ?) ");
	
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setInt(1, bookNo);
			pstmt.setString(2, service.getTitle(bookNo));
			pstmt.setString(3, service.getAuthor(bookNo));
			pstmt.setString(4, service.getPublisher(bookNo));
			pstmt.setString(5, id);
			
			int cnt = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ren;
		
	}
	
}
