package com.soob.member.vo;

public class MemberVO {
	
	//회원번호(자동생성), ID, PW, 이름, 정보
	//+기본대여상태 N, 대여한 도서정보 기본NULL
	//CREATE SEQUENCE SEQ_MEMBER_NO START WITH 000001 NOCACHE;
	private int memberNo;
	private String id;
	private String pw;
	private String userName;
	private String userPhone;
	
	//추가정보
	private String rentalStatus;
	private int rentalNo;
	
	public MemberVO() {
		super();
	}
	
	public MemberVO(int memberNo, String id, String pw, String userName,
					String userPhone, String rentalStatus, int rentalNo) 
	{
		super();
		this.memberNo = memberNo;
		this.id = id;
		this.pw = pw;
		this.userName = userName;
		this.userPhone = userPhone;
		this.rentalStatus = rentalStatus;
		this.rentalNo = rentalNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getRentalStatus() {
		return rentalStatus;
	}
	public void setRentalStatus(String rentalStatus) {
		this.rentalStatus = rentalStatus;
	}
	public int getRentalNo() {
		return rentalNo;
	}
	public void setRentalNo(int rentalNo) {
		this.rentalNo = rentalNo;
	}
	@Override
	public String toString() {
		System.out.printf("ID : %s, PW : %s, 이름 : %s, 연락처 : %d",
							id, pw, userName, userPhone);
		return "";
	}


	//회원가입까지는 껌.
	
	//포인트는!!!
	//로그인
	//그리고 로그인 상태 유지
	//대여 정보
	
	

}
