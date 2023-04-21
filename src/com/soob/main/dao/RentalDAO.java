package com.soob.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.soob.main.service.BookService;
import com.soob.main.service.RentalService;
import com.soob.main.vo.RentalVO;
import com.soob.util.ConnectionFactory;

/**
 * 오라클 DB의 T_RENTAL
 * @author User
 *
 */


public class RentalDAO {
	
	private BookService service;
	private RentalService renService;
	private RentalVO ren;
	
	//대여정보 등록
	public RentalVO addRental(String id, int bookNo) {
		service = new BookService();
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
	
	//ID에 따른 대여목록
		public List<RentalVO> getRentalList(String id) {
			List<RentalVO> rentalList= new ArrayList<>();
			SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT T_RENTAL.*, ROUND(SYSDATE-DUE_DATE) AS OVERDUE FROM T_RENTAL WHERE RENT_ID = ? ");
			try(
					Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
				pstmt.setString(1, id);
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					int no 			= rs.getInt("NO");
					String title	= rs.getString("TITLE");
					String author	= rs.getString("AUTHOR");
					String publisher= rs.getString("PUBLISHER");
					String rentId	= rs.getString("RENT_ID");
					String renDate 	= sdf.format(rs.getDate("REN_DATE"));
					String dueDate 	= sdf.format(rs.getDate("DUE_DATE"));
					int overdueDays = rs.getInt("OVERDUE");
					
					ren = new RentalVO(no, title, author, publisher, rentId, renDate, dueDate, overdueDays);
					rentalList.add(ren);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return rentalList;
		}
	
	//도서반납(대여정보 수정)
	public void returnBook(String id, int bookNo) {
		service = new BookService();
		RentalVO ren = new RentalVO();
		service.searchOneByNo(bookNo);
		
		StringBuilder sql = new StringBuilder();
		//책넘버, ID에 따라 OVERDUE STATE만 NULL로 바꿀까?
		//OVERDUE_STATE가 만약 NOT NULL로 돼있으면 빼줄것.
		sql.append("DELETE FROM T_RENTAL WHERE NO = ? AND RENT_ID = ? ");
	
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setInt(1, bookNo);
			pstmt.setString(2, id);
			
			if(pstmt.executeUpdate()==0) {
				System.out.println("여기는 RentalDAO, 업데이트 에러");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	//대여중인 도서 목록
//	public List<RentalVO> getRentalBookList(String id) {
//		renService = new RentalService();
//		RentalVO ren = new RentalVO();
//		
//		List<RentalVO> bookList = null;  
//		
//		StringBuilder sql = new StringBuilder();
//		sql.append("SELECT * FROM T_RENTAL WHERE ID = ? ");
//	
//		try(
//				Connection conn = new ConnectionFactory().getConnection();
//				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
//		) {
//			pstmt.setString(1, id);
//			
//			ResultSet rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				int no = rs.getInt("NO");
//				String title = rs.getString("TITLE");
//				String author = rs.getString("");
//				String publisher = rs.getString("TITLE");
////				int rentDate = rs.getDate("RENT_DATE");
////				int dueDate = rs.getDate("DUE_DATE");
//			}
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return bookList;
//	}
	
	
}
