package com.soob.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.soob.admin.vo.BookVO;
import com.soob.util.ConnectionFactory;

/**
 * 오라클 DB의 Book테이블이 CRUD하는 DAO 클래스
 * @author User
 *
 */


public class BookDAO {
	
	//1. DB에 정보를 추가하는 메소드
	public void addBook(BookVO book) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO BOOKLIST(NO, TITLE, AUTHOR, PUBLISHER, STOCK) ");
		sql.append(" VALUES(SEQ_BOOKLIST_NO.NEXTVAL, ?, ?, ?, ?) ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setString(3, book.getPublisher());
			pstmt.setInt(4, book.getStock());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	//2. 저장된 모든 VO리스트를 보여주는 메소드
	public List<BookVO> showAllBooks() {
		List<BookVO> bookList = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM BOOKLIST ORDER BY NO");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int no 			= rs.getInt("NO");
				String title	= rs.getString("TITLE");
				String author	= rs.getString("AUTHOR");
				String publisher= rs.getString("PUBLISHER");
				int stock 		= rs.getInt("STOCK");
				
				BookVO book = new BookVO(no, title, author, publisher, stock);

//				System.out.println(book);
				bookList.add(book);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bookList;
	}

	//3. 일단은 관리번호로 검색하면 찾아지는 + 수정할 수 있는.
	public BookVO searchOneBook(int manageNo) {
		
		BookVO book = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM BOOKLIST ");
		sql.append(" WHERE NO = ? ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			
			pstmt.setInt(1, manageNo);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int no 			= rs.getInt("NO");
				String title	= rs.getString("TITLE");
				String author	= rs.getString("AUTHOR");
				String publisher= rs.getString("PUBLISHER");
				int stock 		= rs.getInt("STOCK");
				
				book = new BookVO(no, title, author, publisher, stock);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return book;
	}

	//4. 관리번호로 찾아서 삭제하는
	public BookVO deleteBook(int manageNo) {
		
		BookVO book = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM BOOKLIST ");
		sql.append("	WHERE NO = ? ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			//물음표 자리에 매개변수로 들어오는 int를 날려~
			pstmt.setInt(1, manageNo);
			
			int cnt = pstmt.executeUpdate();
//			System.out.println("반영완료" + cnt);
			
//			if(rs.next()) {
//				int no 			= rs.getInt("NO");
//				String title	= rs.getString("TITLE");
//				String author	= rs.getString("AUTHOR");
//				String publisher= rs.getString("PUBLISHER");
//				int stock 		= rs.getInt("STOCK");
//				
//				book = new BookVO(no, title, author, publisher, stock);
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
		
	}
	
	
	
	
	
	
	
//	public List<BookVO> searchBooks(int manageNo) {
//		
//		List<BookVO> bookList = new ArrayList<>();
//		
//		//3-1 관리번호로 검색
//		StringBuilder sql = new StringBuilder();
//		sql.append("SELECT * FROM BOOKLIST ");
//		sql.append(" WHERE NO = ? ");
//		
//		try(
//				Connection conn = new ConnectionFactory().getConnection();
//				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
//		) {
//			
//			pstmt.setInt(1, manageNo);
//			ResultSet rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				
//				int no 			= rs.getInt("NO");
//				String title	= rs.getString("TITLE");
//				String author	= rs.getString("AUTHOR");
//				String publisher= rs.getString("PUBLISHER");
//				int stock 		= rs.getInt("STOCK");
//				
//				BookVO book = new BookVO(no, title, author, publisher, stock);
//
////				System.out.println(book);
//				bookList.add(book);
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return bookList;
//	}
	
	
}
