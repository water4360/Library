package com.soob.member.vo;

public class RequestVO {
	private int no;
	private String userId;
	private String content;
	
	
	public RequestVO() {
		super();
	}
	public RequestVO(int no, String id, String content) {
		super();
		this.no = no;
		this.userId = id;
		this.content = content;
	}
	

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
	@Override
	public String toString() {
		//				  번호, 날짜, 내용
		System.out.printf("No.%d %s\t%s", no, userId, content);
		return "";
	}

	
}
