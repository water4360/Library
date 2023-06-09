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
	
	public MemberVO(String id, String pw, String userName, String userPhone)
	{
		super();
		MemberVO.id = id;
		MemberVO.pw = pw;
		MemberVO.userName = userName;
		MemberVO.userPhone = userPhone;
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
	public static int getMemberNo() {
		return memberNo;
	}
	public static void setMemberNo(int memberNo) {
		MemberVO.memberNo = memberNo;
	}
	public static String getId() {
		return id;
	}
	public static void setId(String id) {
		MemberVO.id = id;
	}
	public static String getPw() {
		return pw;
	}
	public static void setPw(String pw) {
		MemberVO.pw = pw;
	}
	public static String getUserName() {
		return userName;
	}
	public static void setUserName(String userName) {
		MemberVO.userName = userName;
	}
	public static String getUserPhone() {
		return userPhone;
	}
	public static void setUserPhone(String userPhone) {
		MemberVO.userPhone = userPhone;
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
		System.out.printf("%-10s\t\t%-10s\t\t%s\t\t%s\n",
							id, pw, userName, userPhone);
		return "";
	}


	//회원가입까지는 껌.
	
	//포인트는!!!
	//로그인
	//그리고 로그인 상태 유지
	//대여 정보
	
	

}
