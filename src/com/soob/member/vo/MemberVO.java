package com.soob.member.vo;

public class MemberVO {
	
	//회원번호(자동생성), ID, PW, 이름, 정보
	//+기본대여상태 N, 대여한 도서정보 기본NULL
	//CREATE SEQUENCE SEQ_MEMBER_NO START WITH 000001 NOCACHE;
	private static int memberNo;
	private static String id;
	private static String pw;
	private static String userName;
	private static String userPhone;
	
	//추가정보
	private String rentalStatus;
	private int rentalNo;
	
	public MemberVO() {
		super();
	}
	
	public MemberVO(int memberNo, String id, String pw, String userName,
					String userPhone) 
	{
		super();
		MemberVO.memberNo = memberNo;
		MemberVO.id = id;
		MemberVO.pw = pw;
		MemberVO.userName = userName;
		MemberVO.userPhone = userPhone;
//		this.rentalStatus = rentalStatus;
//		this.rentalNo = rentalNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public static String getId() {
		return id;
	}
	public void setId(String id) {
		MemberVO.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public static String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public static String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
//	public String getRentalStatus() {
//		return rentalStatus;
//	}
//	public void setRentalStatus(String rentalStatus) {
//		this.rentalStatus = rentalStatus;
//	}
//	public int getRentalNo() {
//		return rentalNo;
//	}
//	public void setRentalNo(int rentalNo) {
//		this.rentalNo = rentalNo;
//	}
	@Override
	public String toString() {
		System.out.printf("ID : %s, PW : %s, 이름 : %s, 연락처 : %s",
							id, pw, userName, userPhone);
		return "";
	}


	//회원가입까지는 껌.
	
	//포인트는!!!
	//로그인
	//그리고 로그인 상태 유지
	//대여 정보
	
	

}
