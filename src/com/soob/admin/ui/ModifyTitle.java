package com.soob.admin.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.soob.admin.vo.BookVO;
import com.soob.util.ConnectionFactory;

public class ModifyTitle implements IModifyQuery {

	@Override
	public void modify() {
		
		System.out.println("타이틀 수정하고 싶다");
//		BookVO book = null;
//		
//		StringBuilder sql = new StringBuilder();
//		sql.append("UPDATE BOOKLIST SET TITLE = ? ");
//		sql.append(" WHERE NO = ? ");
//		
//		try(
//			Connection conn = new ConnectionFactory().getConnection();
//			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
//		) {
//			pstmt.setString(1, "");
//			int cnt = pstmt.executeUpdate();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

	}

}
