package com.zoo.infra.product;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ProductVo {

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Integer pdSeq;
	private String pdName;
	private Boolean pdUseNy;
	private Integer pdOrder;
	private String pdDesc;
	private Boolean pdDelNy;
	private String regDateTime;
	private String modDateTime;
	private Integer pdPrice;
	private Double pdPriceDcRate;
	private Boolean pdfavorite;
	private Integer memberMemberSeq;
	private Integer pdMedia;
	private Integer pdTerm;
	private String pdReview;
	private String pdImg;
	
	//member
	private String memberSeq;
	private String memberName;
	
	//pdrv
	private Integer pdrvSeq;
	private String pdrvTitle;
	private Integer pdrvRating;
	private String pdrvReview;
	private String productPdSeq;
	private String pdrvRegDateTime;
	private String pdrvModDateTime;
	
	private String xReviewCount;
	
	// search
	private Integer shUseNy;
	private Integer shDelNy;

	private Integer shOption;
	private String shValue;
	private Integer shOptionDate;
	private Date shDateStart;
	private Date shDateEnd;

	// paging
	public class Constants {
		public static final int ROW_NUM_TO_SHOW = 10; // 원하는 값으로 설정
		public static final int PAGE_NUM_TO_SHOW = 5; // 원하는 값으로 설정
	}
	//

	private int thisPage = 1; // 현재 페이지
	private int rowNumToShow = Constants.ROW_NUM_TO_SHOW; // 화면에 보여줄 데이터 줄 갯수
//		Constatns. 이런식으로 Constatns 객체(클래스)를 만들어서 사용해도 된다.
	private int pageNumToShow = Constants.PAGE_NUM_TO_SHOW; // 화면에 보여줄 페이징 번호 갯수

	private int totalRows; // 전체 데이터 갯수
	private int totalPages; // 전체 페이지 번호
	private int startPage; // 시작 페이지 번호
	private int endPage; // 마지막 페이지 번호

	private int startRnumForMysql = 0; // 쿼리 시작 row
	// --------------------------------------------------------------
	
	
	public Integer getPdSeq() {
		return pdSeq;
	}
	public String getxReviewCount() {
		return xReviewCount;
	}
	public void setxReviewCount(String xReviewCount) {
		this.xReviewCount = xReviewCount;
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

	public String getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(String memberSeq) {
		this.memberSeq = memberSeq;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Integer getPdrvSeq() {
		return pdrvSeq;
	}

	public void setPdrvSeq(Integer pdrvSeq) {
		this.pdrvSeq = pdrvSeq;
	}

	public String getPdrvTitle() {
		return pdrvTitle;
	}

	public void setPdrvTitle(String pdrvTitle) {
		this.pdrvTitle = pdrvTitle;
	}

	public Integer getPdrvRating() {
		return pdrvRating;
	}

	public void setPdrvRating(Integer pdrvRating) {
		this.pdrvRating = pdrvRating;
	}

	public String getPdrvReview() {
		return pdrvReview;
	}

	public void setPdrvReview(String pdrvReview) {
		this.pdrvReview = pdrvReview;
	}

	public String getProductPdSeq() {
		return productPdSeq;
	}

	public void setProductPdSeq(String productPdSeq) {
		this.productPdSeq = productPdSeq;
	}

	public String getPdrvRegDateTime() {
		return pdrvRegDateTime;
	}

	public void setPdrvRegDateTime(String pdrvRegDateTime) {
		this.pdrvRegDateTime = pdrvRegDateTime;
	}

	public String getPdrvModDateTime() {
		return pdrvModDateTime;
	}

	public void setPdrvModDateTime(String pdrvModDateTime) {
		this.pdrvModDateTime = pdrvModDateTime;
	}

	public Integer getPdMedia() {
		return pdMedia;
	}

	public void setPdMedia(Integer pdMedia) {
		this.pdMedia = pdMedia;
	}

	public Integer getPdTerm() {
		return pdTerm;
	}

	public void setPdTerm(Integer pdTerm) {
		this.pdTerm = pdTerm;
	}

	public String getPdReview() {
		return pdReview;
	}

	public void setPdReview(String pdReview) {
		this.pdReview = pdReview;
	}

	public String getPdImg() {
		return pdImg;
	}

	public void setPdImg(String pdImg) {
		this.pdImg = pdImg;
	}

	public void setPdSeq(Integer pdSeq) {
		this.pdSeq = pdSeq;
	}

	public String getPdName() {
		return pdName;
	}

	public void setPdName(String pdName) {
		this.pdName = pdName;
	}

	public Boolean getPdUseNy() {
		return pdUseNy;
	}

	public void setPdUseNy(Boolean pdUseNy) {
		this.pdUseNy = pdUseNy;
	}

	public Integer getPdOrder() {
		return pdOrder;
	}

	public void setPdOrder(Integer pdOrder) {
		this.pdOrder = pdOrder;
	}

	public String getPdDesc() {
		return pdDesc;
	}

	public void setPdDesc(String pdDesc) {
		this.pdDesc = pdDesc;
	}

	public Boolean getPdDelNy() {
		return pdDelNy;
	}

	public void setPdDelNy(Boolean pdDelNy) {
		this.pdDelNy = pdDelNy;
	}

	public Integer getPdPrice() {
		return pdPrice;
	}

	public void setPdPrice(Integer pdPrice) {
		this.pdPrice = pdPrice;
	}

	public Double getPdPriceDcRate() {
		return pdPriceDcRate;
	}

	public void setPdPriceDcRate(Double pdPriceDcRate) {
		this.pdPriceDcRate = pdPriceDcRate;
	}

	public Boolean getPdfavorite() {
		return pdfavorite;
	}

	public void setPdfavorite(Boolean pdfavorite) {
		this.pdfavorite = pdfavorite;
	}

	public Integer getMemberMemberSeq() {
		return memberMemberSeq;
	}

	public void setMemberMemberSeq(Integer memberMemberSeq) {
		this.memberMemberSeq = memberMemberSeq;
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
