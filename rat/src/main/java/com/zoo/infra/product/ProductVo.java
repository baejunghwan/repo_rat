package com.zoo.infra.product;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ProductVo {

	 private Integer productSeq;
	 private String productName;
	 private Integer productUseNy;
	 private String productOrder;
	 private String productDesc;
	 private Integer productDelNy;
	 private Date regDateTime;
	 private Date modDateTime;
	 private Integer member_memberSeq;
	 
	 //search
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
		    public static final int ROW_NUM_TO_SHOW = 10; // 원하는 값으로 설정
		    public static final int PAGE_NUM_TO_SHOW = 5; // 원하는 값으로 설정
		}
		//
		
		private int thisPage = 1;									// 현재 페이지
		private int rowNumToShow = Constants.ROW_NUM_TO_SHOW;		// 화면에 보여줄 데이터 줄 갯수
//		Constatns. 이런식으로 Constatns 객체(클래스)를 만들어서 사용해도 된다.
		private int pageNumToShow = Constants.PAGE_NUM_TO_SHOW;		// 화면에 보여줄 페이징 번호 갯수

		private int totalRows;										// 전체 데이터 갯수
		private int totalPages;										// 전체 페이지 번호
		private int startPage;										// 시작 페이지 번호
		private int endPage;										// 마지막 페이지 번호

		private int startRnumForMysql = 0;							// 쿼리 시작 row	
	 //--------------------------------------------------------------

		public Integer getProductSeq() {
			return productSeq;
		}

		public void setProductSeq(Integer productSeq) {
			this.productSeq = productSeq;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public Integer getProductUseNy() {
			return productUseNy;
		}

		public void setProductUseNy(Integer productUseNy) {
			this.productUseNy = productUseNy;
		}

		public String getProductOrder() {
			return productOrder;
		}

		public void setProductOrder(String productOrder) {
			this.productOrder = productOrder;
		}

		public String getProductDesc() {
			return productDesc;
		}

		public void setProductDesc(String productDesc) {
			this.productDesc = productDesc;
		}

		public Integer getProductDelNy() {
			return productDelNy;
		}

		public void setProductDelNy(Integer productDelNy) {
			this.productDelNy = productDelNy;
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

		public Integer getMember_memberSeq() {
			return member_memberSeq;
		}

		public void setMember_memberSeq(Integer member_memberSeq) {
			this.member_memberSeq = member_memberSeq;
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
