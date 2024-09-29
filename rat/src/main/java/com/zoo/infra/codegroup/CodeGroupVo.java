package com.zoo.infra.codegroup;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class CodeGroupVo {

	private Integer ifcgSeq;
	private String ifcgName;
	private Integer ifcgUseNy;
	private Integer ifcgOrder;
	private String ifcgDesc;
	private Integer ifcgDelNy;
	private Date regDateTime;
	private Date modDateTime;
	// count
	private Integer xifcdSeqCount;

	// search
	private Integer shUseNy;
	private Integer shDelNy;

	private Integer shOption;
	private String shValue;
	private Integer shOptionDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date shDateStart;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date shDateEnd;	
	
	// paging
	public class Constants {
	    public static final int ROW_NUM_TO_SHOW = 5; // 원하는 값으로 설정
	    public static final int PAGE_NUM_TO_SHOW = 5; // 원하는 값으로 설정
	}
	private int thisPage = 1;									// 현재 페이지
	private int rowNumToShow = Constants.ROW_NUM_TO_SHOW;		// 화면에 보여줄 데이터 줄 갯수
//	Constatns. 이런식으로 Constatns 객체(클래스)를 만들어서 사용해도 된다.
	private int pageNumToShow = Constants.PAGE_NUM_TO_SHOW;		// 화면에 보여줄 페이징 번호 갯수

	private int totalRows;										// 전체 데이터 갯수
	private int totalPages;										// 전체 페이지 번호
	private int startPage;										// 시작 페이지 번호
	private int endPage;										// 마지막 페이지 번호

	private int startRnumForMysql = 0;							// 쿼리 시작 row	
	
	public void setParamsPaging(int totalRows) {
		//setThisPage(3);
		setTotalRows(totalRows);

		if (getTotalRows() == 0) {
			setTotalPages(1);
		} else {
			setTotalPages(getTotalRows() / getRowNumToShow());
		}

		if (getTotalRows() % getRowNumToShow() > 0) {
			setTotalPages(getTotalPages() + 1);
		}

		if (getTotalPages() < getThisPage()) {
			setThisPage(getTotalPages());
		}
		
		setStartPage(((getThisPage() - 1) / getPageNumToShow()) * getPageNumToShow() + 1);

		setEndPage(getStartPage() + getPageNumToShow() - 1);

		if (getEndPage() > getTotalPages()) {
			setEndPage(getTotalPages());
		}	
		
		if (thisPage == 1) {
			setStartRnumForMysql(0);
		} else {	
			setStartRnumForMysql((getRowNumToShow() * (getThisPage()-1)));
		}
		
		System.err.println("setTotalRows(totalRows) 결과 : ");
		System.out.println("rowNumToShow : " + getRowNumToShow());
		System.out.println("pageNumToShow : " + getPageNumToShow());
		System.out.println("totalRows : " + getTotalRows());
		System.out.println("totalPages : " + getTotalPages());
		System.out.println("startPage : "+ getStartPage());
		System.out.println("endPage : " + getEndPage());
	}
//	------

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

	public Date getShDateStart() {
		return shDateStart;
	}

	public void setShDateStart(Date shDateStart) {
		this.shDateStart = shDateStart;
	}

	public Date getShDateEnd() {
		return shDateEnd;
	}

	public void setShDateEnd(Date shDateEnd) {
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
