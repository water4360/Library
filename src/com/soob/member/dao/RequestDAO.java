package com.soob.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.soob.member.vo.MemberVO;
import com.soob.member.vo.RequestVO;
import com.soob.util.ConnectionFactory;

public class RequestDAO {
	
	public RequestDAO() {
		
	}

	/**
	 * 간단 게시글 남기기
	 * @param request
	 */
	
	//요청 남기기
	public void addRequest(String writing) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO T_REQUEST (NO, ID, CONTENTS) ");
		sql.append(" VALUES (SEQ_REQUEST_NO.NEXTVAL, ?, ?)  ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, MemberVO.getId());
			pstmt.setString(2, writing);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//관리자가 등록된 게시글 모두보기
	public List<RequestVO> getRequest() {
		List<RequestVO> reqList = new ArrayList<>();
		RequestVO req = null;
		StringBuilder sql = new StringBuilder();
		//게시글도 최신글이 위로 올라오도록.
		sql.append("SELECT * FROM T_REQUEST ORDER BY NO DESC ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no 			= rs.getInt("NO");
				String id 		= rs.getString("ID");
				String contents = rs.getString("CONTENTS");
				req = new RequestVO(no, id, contents);
				
				reqList.add(req);
			}
//			System.out.println(noticeList.get(0));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reqList;
	}
	
	
	
	
	
	
	
	//회원이 자기가 쓴 글 삭제
	public void delRequest(int no) {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM T_REQUEST WHERE NO = ? AND ID = ? ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setInt(1, no);
			pstmt.setString(2, MemberVO.getId());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
