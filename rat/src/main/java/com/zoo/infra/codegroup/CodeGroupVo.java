package com.zoo.infra.codegroup;

import org.springframework.format.annotation.DateTimeFormat;

// 코드 그룹 검색 및 페이징 정보를 담는 VO 클래스
public class CodeGroupVo {

	private Integer ifcgSeq; // 코드 그룹 시퀀스
	private String ifcgName; // 코드 그룹 이름
	private Integer ifcgUseNy; // 사용 여부 (Y/N)
	private Integer ifcgOrder; // 정렬 순서
	private String ifcgDesc; // 코드 그룹 설명
	private Integer ifcgDelNy; // 삭제 여부 (Y/N)
	private String regDateTime; // 등록 시간
	private String modDateTime; // 수정 시간

	// 코드 그룹 내 코드 수 카운트
	private Integer xifcdSeqCount;

	// 검색 관련 변수
	private Integer shUseNy; // 검색 사용 여부
	private Integer shDelNy; // 검색 삭제 여부
	private Integer shOption; // 검색 옵션
	private String shValue; // 검색 값
	private Integer shOptionDate; // 날짜 검색 옵션

	// 날짜 검색 시작 및 종료
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String shDateStart; // 시작 날짜
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String shDateEnd; // 종료 날짜

	// 페이징 관련 변수
	private int thisPage = 1; // 현재 페이지
	private int rowNumToShow = Constants.ROW_NUM_TO_SHOW; // 보여줄 데이터 수
	private int pageNumToShow = Constants.PAGE_NUM_TO_SHOW; // 보여줄 페이지 수

	private int totalRows; // 전체 데이터 수
	private int totalPages; // 전체 페이지 수
	private int startPage; // 시작 페이지 번호
	private int endPage; // 마지막 페이지 번호
	private int startRnumForMysql = 0; // MySQL 쿼리 시작 row

	// 상단 페이징 유효성 검사 메서드
	public void validate() {
		if (thisPage < 1) {
			thisPage = 1; // 기본값 설정
		}
		if (rowNumToShow <= 0) {
			rowNumToShow = Constants.ROW_NUM_TO_SHOW; // 기본값 설정
		}
	}

	// 페이징 파라미터 설정 메서드
	public void setParamsPaging(int totalRows) {
		setTotalRows(totalRows); // 전체 데이터 수 설정

		if (getTotalRows() == 0) {
			setTotalPages(1); // 데이터가 없으면 페이지 수는 1
		} else {
			setTotalPages(getTotalRows() / getRowNumToShow()); // 페이지 수 계산
		}

		if (getTotalRows() % getRowNumToShow() > 0) {
			setTotalPages(getTotalPages() + 1); // 나머지 데이터가 있으면 페이지 수 증가
		}

		if (getTotalPages() < getThisPage()) {
			setThisPage(getTotalPages()); // 현재 페이지가 총 페이지 수보다 크면 조정
		}

		setStartPage(((getThisPage() - 1) / getPageNumToShow()) * getPageNumToShow() + 1); // 시작 페이지 계산
		setEndPage(getStartPage() + getPageNumToShow() - 1); // 마지막 페이지 계산

		if (getEndPage() > getTotalPages()) {
			setEndPage(getTotalPages()); // 마지막 페이지가 총 페이지 수보다 크면 조정
		}

		if (thisPage == 1) {
			setStartRnumForMysql(0); // 첫 페이지의 경우 시작 row는 0
		} else {
			setStartRnumForMysql((getRowNumToShow() * (getThisPage() - 1))); // 시작 row 계산
		}

		// 디버깅 출력
		System.err.println("setTotalRows(totalRows) 결과 : ");
		System.out.println("rowNumToShow : " + getRowNumToShow());
		System.out.println("pageNumToShow : " + getPageNumToShow());
		System.out.println("totalRows : " + getTotalRows());
		System.out.println("totalPages : " + getTotalPages());
		System.out.println("startPage : " + getStartPage());
		System.out.println("endPage : " + getEndPage());
	}

	// Getter와 Setter 메서드들
	// 각 필드에 대한 접근 메서드를 정의
	// -----------------------------------------

	public Integer getIfcgSeq() {
		return ifcgSeq;
	}

	public void setIfcgSeq(Integer ifcgSeq) {
		this.ifcgSeq = ifcgSeq;
	}

	public String getIfcgName() {
		return ifcgName;
	}

	public void setIfcgName(String ifcgName) {
		this.ifcgName = ifcgName;
	}

	public Integer getIfcgUseNy() {
		return ifcgUseNy;
	}

	public void setIfcgUseNy(Integer ifcgUseNy) {
		this.ifcgUseNy = ifcgUseNy;
	}

	public Integer getIfcgOrder() {
		return ifcgOrder;
	}

	public void setIfcgOrder(Integer ifcgOrder) {
		this.ifcgOrder = ifcgOrder;
	}

	public String getIfcgDesc() {
		return ifcgDesc;
	}

	public void setIfcgDesc(String ifcgDesc) {
		this.ifcgDesc = ifcgDesc;
	}

	public Integer getIfcgDelNy() {
		return ifcgDelNy;
	}

	public void setIfcgDelNy(Integer ifcgDelNy) {
		this.ifcgDelNy = ifcgDelNy;
	}

	public String getRegDateTime() {
		return regDateTime;
	}

	public void setRegDateTime(String regDateTime) {
		this.regDateTime = regDateTime;
	}

	public String getModDateTime() {
		return modDateTime;
	}

	public void setModDateTime(String modDateTime) {
		this.modDateTime = modDateTime;
	}

	public Integer getXifcdSeqCount() {
		return xifcdSeqCount;
	}

	public void setXifcdSeqCount(Integer xifcdSeqCount) {
		this.xifcdSeqCount = xifcdSeqCount;
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
}

// 상수 클래스를 외부 클래스로 분리
class Constants {
	public static final int ROW_NUM_TO_SHOW = 5; // 한 페이지에 보여줄 데이터 수
	public static final int PAGE_NUM_TO_SHOW = 5; // 한 페이지에 보여줄 페이지 수
}
