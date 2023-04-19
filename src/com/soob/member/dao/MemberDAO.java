package com.soob.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.soob.member.vo.MemberVO;
import com.soob.util.ConnectionFactory;


/**
 * 오라클 DB의 Book테이블이 CRUD하는 DAO 클래스
 * @author User
 *
 */


public class MemberDAO {
	//샘플용
//		INSERT INTO MEMBER(MEM_NO, ID, PW, NAME, PHONE, RENTAL_STATUS, RENTAL_NO)
//        VALUES(SEQ_MEMBER_NO.NEXTVAL, ?, ?, ?, ?) ;

	
	
	//1. DB에 회원정보 추가하는 메소드
	public void addMember(MemberVO mem) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO MEMBER(MEM_NO, ID, PW, NAME, PHONE) ");
		sql.append("			VALUES(SEQ_MEMBER_NO.NEXTVAL, ?, ?, ?, ?) ");

		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getPw());
			pstmt.setString(3, mem.getUserName());
			pstmt.setString(4, mem.getUserPhone());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
//	//1. 저장된 모든 멤버VO리스트를 보여주는 메소드
//	public List<MemberVO> showAllMembers() {
//		List<MemberVO> memList = new ArrayList<>();
//		
//		StringBuilder sql = new StringBuilder();
//		sql.append("SELECT * FROM BOOKLIST ORDER BY NO");
//		
//		try(
//				Connection conn = new ConnectionFactory().getConnection();
//				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
//		) {
//			ResultSet rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				
//				int no 			= rs.getInt("NO");
//				String title	= rs.getString("TITLE");
//				String author	= rs.getString("AUTHOR");
//				String publisher= rs.getString("PUBLISHER");
//				int stock 		= rs.getInt("STOCK");
//				int status 		= rs.getInt("STATUS");
//				
//				BookVO book = new BookVO(no, title, author, publisher, stock, status);
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
//
	//0.회원가입/로그인1단계-ID 중복 검색하는 메소드.
	public boolean isDuplicatedId(String id) {
		
		MemberVO mem = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT INSTR(ID, ?), ID FROM MEMBER ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			//쿼리를 실행하고 결과가 있으면
			while(rs.next()) {
				//입력받은 문자와 비교하고 같으면 true
				if(rs.getString("ID").equalsIgnoreCase(id))
					return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//다르면 false 반환
		return false;
	}
	
	//0. 로그인2단계-ID&PW 둘다일치 확인하는 메소드.
	public boolean isCorrectInfo(String id, String pw) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM MEMBER WHERE ID = ? AND PW = ? ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			ResultSet rs = pstmt.executeQuery();
			//쿼리를 실행하고 정보가 둘 다 일치하면
			while(rs.next()) {
				if(rs.getString("ID").equalsIgnoreCase(id) && rs.getString("PW").equals(pw))
					return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//다르면 false 반환
		return false;
	}
	
	//0. 로그인2단계-ID&PW 둘다일치 확인하는 메소드.
	public int getMemberCode(String id, String pw) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ID, PW, MEM_CODE FROM MEMBER WHERE ID = ? "); 
		sql.append(" AND PW = ? ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			ResultSet rs = pstmt.executeQuery();
			
			//쿼리를 실행하고 정보가 둘 다 일치하면
			while(rs.next()) {
				if((rs.getString("ID").equalsIgnoreCase(id)) 
							&& (rs.getString("PW").equals(pw)))
					return rs.getInt("MEM_CODE");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//다르면 false 반환
		return 0;
	}
	
	
	
//	public boolean isDuplicated(int id) {
//		
//		MemberVO mem = null;
//		
//		StringBuilder sql = new StringBuilder();
//		sql.append("SELECT INSTR(ID, ?), ID FROM MEMBER ");
//		
//		try(
//			Connection conn = new ConnectionFactory().getConnection();
//			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
//		) {
//			
//			pstmt.setString(1, id);
//			ResultSet rs = pstmt.executeQuery();
//			
//			//쿼리를 실행하고 결과가 있으면
//			while(rs.next()) {
//				//입력받은 문자와 비교하고 같으면 true
////				System.out.println("rs.getString(1)의 결과 : " + rs.getString(1));
////				System.out.println("id.equals(rs.getString(1))의 결과 : " + id.equals(rs.getString(1)));
//				//
////				if(rs.getInt(1)!=0 && rs.getString(2).equals(id)) {
//				if(rs.getString("ID").equalsIgnoreCase(id))
//					return true;
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		//다르면 false 반환
//		return false;
//	}


	
	
	
//	//4. 관리번호로 찾아서 삭제하는
//	public BookVO deleteBook(int manageNo) {
//		
//		BookVO book = null;
//		
//		StringBuilder sql = new StringBuilder();
//		sql.append("DELETE FROM BOOKLIST ");
//		sql.append("	WHERE NO = ? ");
//		
//		try(
//			Connection conn = new ConnectionFactory().getConnection();
//			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
//		) {
//			//물음표 자리에 매개변수로 들어오는 int를 날려~
//			pstmt.setInt(1, manageNo);
//			
//			int cnt = pstmt.executeUpdate();
////			System.out.println("반영완료" + cnt);
//			
////			if(rs.next()) {
////				int no 			= rs.getInt("NO");
////				String title	= rs.getString("TITLE");
////				String author	= rs.getString("AUTHOR");
////				String publisher= rs.getString("PUBLISHER");
////				int stock 		= rs.getInt("STOCK");
////				
////				book = new BookVO(no, title, author, publisher, stock);
////			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return book;
//		
//	}
//	
	
	

	
	
}
