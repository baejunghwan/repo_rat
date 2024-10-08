package com.zoo.infra.member;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class MemberVo {

	private Integer memberSeq;
	private String memberName;
	private Integer memberUseNy;
	private Integer memberOrder;
	private String memberDesc;
	private Integer memberDelNy;
	private Date regDateTime;
	private Date modDateTime;
	private String memberGender;

	// Login
	private String memberId;
	private String memberPw;
	private String memberEmail;
	private String memberTel;

	private String rtMember;

	// search
	private Integer shUseNy;
	private Integer shDelNy;
	private Integer shOption;
	private String shValue;
	private Integer shOptionDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String shDateStart;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String shDateEnd;

	// paging
	public class Constants {
		public static final int ROW_NUM_TO_SHOW = 5; // 원하는 값으로 설정
		public static final int PAGE_NUM_TO_SHOW = 5; // 원하는 값으로 설정
	}
	//

	private int thisPage = 1; // 현재 페이지
	private int rowNumToShow = Constants.ROW_NUM_TO_SHOW; // 화면에 보여줄 데이터 줄 갯수
//	Constatns. 이런식으로 Constatns 객체(클래스)를 만들어서 사용해도 된다.
	private int pageNumToShow = Constants.PAGE_NUM_TO_SHOW; // 화면에 보여줄 페이징 번호 갯수

	private int totalRows; // 전체 데이터 갯수
	private int totalPages; // 전체 페이지 번호
	private int startPage; // 시작 페이지 번호
	private int endPage; // 마지막 페이지 번호

	private int startRnumForMysql = 0; // 쿼리 시작 row

	public void setParamsPaging(int totalRows) {
		// setThisPage(3);
		// 전체 행 수를 설정합니다.
		setTotalRows(totalRows);

		// 총 행 수가 0일 경우, 페이지 수를 1로 설정합니다.
		if (getTotalRows() == 0) {
			setTotalPages(1);
		} else {
			// 총 행 수를 페이지당 보여줄 행 수로 나누어 총 페이지 수를 계산합니다.
			setTotalPages(getTotalRows() / getRowNumToShow());
		}

		// 전체 행 수가 페이지당 행 수로 나누어 떨어지지 않는 경우, 추가 페이지가 필요하므로 총 페이지 수를 1 증가시킵니다.
		if (getTotalRows() % getRowNumToShow() > 0) {
			setTotalPages(getTotalPages() + 1);
		}

		// 현재 페이지가 총 페이지 수를 초과하는 경우, 현재 페이지를 총 페이지 수로 설정합니다.
		if (getTotalPages() < getThisPage()) {
			setThisPage(getTotalPages());
		}

		// 현재 페이지에 따라 보여줄 페이지 그룹의 시작 페이지를 계산합니다.
		// (현재 페이지 - 1) / 페이지 그룹 수 * 페이지 그룹 수 + 1
		setStartPage(((getThisPage() - 1) / getPageNumToShow()) * getPageNumToShow() + 1);

		// 시작 페이지를 기반으로 끝 페이지를 계산합니다.
		setEndPage(getStartPage() + getPageNumToShow() - 1);

		// 끝 페이지가 총 페이지 수를 초과하지 않도록 설정합니다.
		if (getEndPage() > getTotalPages()) {
			setEndPage(getTotalPages());
		}

		// 현재 페이지가 1인 경우 MySQL 쿼리를 위한 시작 행 번호를 0으로 설정합니다.
		if (getThisPage() == 1) {
			setStartRnumForMysql(0);
		} else {
			// 그렇지 않은 경우, (페이지당 보여줄 행 수 * (현재 페이지 - 1))로 시작 행 번호를 계산합니다.
			setStartRnumForMysql((getRowNumToShow() * (getThisPage() - 1)));
		}

		System.err.println("setTotalRows(totalRows) 결과 : ");
		System.out.println("rowNumToShow : " + getRowNumToShow());
		System.out.println("pageNumToShow : " + getPageNumToShow());
		System.out.println("totalRows : " + getTotalRows());
		System.out.println("totalPages : " + getTotalPages());
		System.out.println("startPage : " + getStartPage());
		System.out.println("endPage : " + getEndPage());
	}
// ----------------------------------

	public Integer getMemberSeq() {
		return memberSeq;
	}

	public String getRtMember() {
		return rtMember;
	}

	public void setRtMember(String rtMember) {
		this.rtMember = rtMember;
	}

	public String getMemberTel() {
		return memberTel;
	}

	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public Integer getShUseNy() {
		return shUseNy;
	}

	public void setShUseNy(Integer shUseNy) {
		this.shUseNy = shUseNy;
	}

	public Integer getShDelNy() {
		return shDelNy;
	}

	public void setShDelNy(Integer shDelNy) {
		this.shDelNy = shDelNy;
	}

	public Integer getShOption() {
		return shOption;
	}

	public void setShOption(Integer shOption) {
		this.shOption = shOption;
	}

	public String getShValue() {
		return shValue;
	}

	public void setShValue(String shValue) {
		this.shValue = shValue;
	}

	public Integer getShOptionDate() {
		return shOptionDate;
	}

	public void setShOptionDate(Integer shOptionDate) {
		this.shOptionDate = shOptionDate;
	}

	public String getShDateStart() {
		return shDateStart;
	}

	public void setShDateStart(String shDateStart) {
		this.shDateStart = shDateStart;
	}

	public String getShDateEnd() {
		return shDateEnd;
	}

	public void setShDateEnd(String shDateEnd) {
		this.shDateEnd = shDateEnd;
	}

	public int getThisPage() {
		return thisPage;
	}

	public void setThisPage(int thisPage) {
		this.thisPage = thisPage;
	}

	public int getRowNumToShow() {
		return rowNumToShow;
	}

	public void setRowNumToShow(int rowNumToShow) {
		this.rowNumToShow = rowNumToShow;
	}

	public int getPageNumToShow() {
		return pageNumToShow;
	}

	public void setPageNumToShow(int pageNumToShow) {
		this.pageNumToShow = pageNumToShow;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getStartRnumForMysql() {
		return startRnumForMysql;
	}

	public void setStartRnumForMysql(int startRnumForMysql) {
		this.startRnumForMysql = startRnumForMysql;
	}

	public void setMemberSeq(Integer memberSeq) {
		this.memberSeq = memberSeq;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Integer getMemberUseNy() {
		return memberUseNy;
	}

	public void setMemberUseNy(Integer memberUseNy) {
		this.memberUseNy = memberUseNy;
	}

	public Integer getMemberOrder() {
		return memberOrder;
	}

	public void setMemberOrder(Integer memberOrder) {
		this.memberOrder = memberOrder;
	}

	public String getMemberDesc() {
		return memberDesc;
	}

	public void setMemberDesc(String memberDesc) {
		this.memberDesc = memberDesc;
	}

	public Integer getMemberDelNy() {
		return memberDelNy;
	}

	public void setMemberDelNy(Integer memberDelNy) {
		this.memberDelNy = memberDelNy;
	}

	public Date getRegDateTime() {
		return regDateTime;
	}

	public void setRegDateTime(Date regDateTime) {
		this.regDateTime = regDateTime;
	}

	public Date getModDateTime() {
		return modDateTime;
	}

	public void setModDateTime(Date modDateTime) {
		this.modDateTime = modDateTime;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

}
