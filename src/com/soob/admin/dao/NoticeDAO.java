package com.soob.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.soob.admin.vo.NoticeVO;
import com.soob.util.ConnectionFactory;

public class NoticeDAO {
	
	public NoticeDAO() {
		
	}

	/**
	 * 간단 공지사항 등록/삭제
	 * @param notice
	 */
	
	//공지 등록
	public void addNotice(String writing) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO T_NOTICE (NO, CONTENTS) ");
		sql.append(" VALUES (SEQ_NOTICE_NO.NEXTVAL, ?) ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, writing);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//등록된 공지 가져오기
	public List<NoticeVO> getNotice() {
		List<NoticeVO> noticeList = new ArrayList<>();
		NoticeVO notice = null;
		StringBuilder sql = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("YY-MM-dd");
		sql.append("SELECT * FROM T_NOTICE ORDER BY NO DESC ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no 			= rs.getInt("NO");
				String date 	= sdf.format(rs.getDate("UP_DATE"));
				String contents = rs.getString("CONTENTS");
				notice = new NoticeVO(no, date, contents);
				
				noticeList.add(notice);
			}
//			System.out.println(noticeList.get(0));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return noticeList;
	}
	
	//공지 삭제
	public void delNotice(int no_no) {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM T_NOTICE WHERE NO = ? ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setInt(1, no_no);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
