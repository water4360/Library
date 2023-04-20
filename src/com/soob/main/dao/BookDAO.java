package com.soob.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.soob.main.vo.BookVO;
import com.soob.util.ConnectionFactory;

/**
 * 오라클 DB의 Book테이블이 CRUD하는 DAO 클래스
 * @author User
 *
 */


public class BookDAO {
	
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
				int status 		= rs.getInt("STATUS");
				
				BookVO book = new BookVO(no, title, author, publisher, status);

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
				int status		= rs.getInt("STATUS");
				
				book = new BookVO(no, title, author, publisher, status);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return book;
	}
	//3-2 다중 검색!!!! 2=제목, 3=저자
	public List<BookVO> searchBooks(int menu, String str) {
		List<BookVO> bookList = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
//		sql.append("SELECT * FROM BOOKLIST WHERE TITLE LIKE '%?%' ");
		switch(menu) {
			case 2 : 
				sql.append("SELECT * FROM BOOKLIST WHERE INSTR(TITLE, ?) != 0 ");
				break;
			case 3 :
				sql.append("SELECT * FROM BOOKLIST WHERE INSTR(AUTHOR, ?) != 0 ");
				break;
		}
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, str);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no 			= rs.getInt("NO");
				String title	= rs.getString("TITLE");
				String author	= rs.getString("AUTHOR");
				String publisher= rs.getString("PUBLISHER");
				int stock 		= rs.getInt("STOCK");
				int status		= rs.getInt("STATUS");
				
				BookVO book = new BookVO(no, title, author, publisher, status);
				bookList.add(book);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bookList;
	}
	
	
	//도서번호로 도서명 가져오기
	public String getTitle(int bookNo) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT TITLE FROM BOOKLIST WHERE NO = ?");
	try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setInt(1, bookNo);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				return rs.getString(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	
	//도서번호로 저자명 가져오기
	public String getAuthor(int bookNo) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT AUTHOR FROM BOOKLIST WHERE NO = ?");
	try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setInt(1, bookNo);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				return rs.getString(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	
	//도서번호로 출판사 가져오기
	public String getPublisher(int bookNo) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT PUBLISHER FROM BOOKLIST WHERE NO = ?");
	try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setInt(1, bookNo);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				return rs.getString(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
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
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
		
	}
	
	//4. 타이틀 수정하는 쿼리
	public BookVO modifyTitle(int manageNo, String str) {
		BookVO book = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE BOOKLIST SET TITLE = ? ");
		sql.append(" WHERE NO = ? ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, str);
			pstmt.setInt(2, manageNo);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	

	
	
}
