package com.soob.admin.vo;

public class NoticeVO {
	private int no;
	private String date;
	private String notice;
	
	
	public NoticeVO() {
		super();
	}
	public NoticeVO(int no, String date, String notice) {
		super();
		this.no = no;
		this.date = date;
		this.notice = notice;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	@Override
	public String toString() {
		//				  번호, 날짜, 내용
		System.out.printf("No.%d %s\t%s", no, date, notice);
		return "";
	}

	
}
