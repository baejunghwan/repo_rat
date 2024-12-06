package com.zoo.infra.product;

import org.springframework.format.annotation.DateTimeFormat;

public class ProductDto {
	
//	날짜 타입 정하는 법 : (db)에서 datetime으로 설정 > dto (정의되어 있는 필드) String으로 타입 - @Datetimeformat 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String pdSeq;
	private String pdName;
	private Boolean pdUseNy;
	private Integer pdOrder;
	private String pdDesc;
	private Boolean pdDelNy;
	private String regDateTime;
	private String modDateTime;
	private Integer pdPrice;
	private Integer pdPriceDcRate;
	private Boolean pdfavorite;
	private Integer pdMedia;
	private Integer pdTerm;
	private String pdImg;
	private Integer pdRating;
	private String memberMemberSeq;

	private String pdReview;
	private String memberName;
	
	//member
	private String memberId;
	
	private Integer pdrvSeq;
	private String pdrvTitle;
	private Integer pdrvRating;
	private String pdrvReview;
	private String productPdSeq;
	
	private String pdrvRegDateTime;
	private String pdrvModDateTime;
	private String member_memberSeq;
	
//	private Integer xReviewCount;
	// ----------------------------------
	
	public String getPdSeq() {
		return pdSeq;
	}
//	public Integer getxReviewCount() {
//		return xReviewCount;
//	}
//	public void setxReviewCount(Integer xReviewCount) {
//		this.xReviewCount = xReviewCount;
//	}
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
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMember_memberSeq() {
		return member_memberSeq;
	}
	public void setMember_memberSeq(String member_memberSeq) {
		this.member_memberSeq = member_memberSeq;
	}
	public Integer getPdPriceDcRate() {
		return pdPriceDcRate;
	}
	public void setPdPriceDcRate(Integer pdPriceDcRate) {
		this.pdPriceDcRate = pdPriceDcRate;
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
	public void setPdSeq(String pdSeq) {
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
	public Boolean getPdfavorite() {
		return pdfavorite;
	}
	public void setPdfavorite(Boolean pdfavorite) {
		this.pdfavorite = pdfavorite;
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
	public String getPdImg() {
		return pdImg;
	}
	public void setPdImg(String pdImg) {
		this.pdImg = pdImg;
	}
	public Integer getPdRating() {
		return pdRating;
	}
	public void setPdRating(Integer pdRating) {
		this.pdRating = pdRating;
	}
	public String getMemberMemberSeq() {
		return memberMemberSeq;
	}
	public void setMemberMemberSeq(String memberMemberSeq) {
		this.memberMemberSeq = memberMemberSeq;
	}
	public String getPdReview() {
		return pdReview;
	}
	public void setPdReview(String pdReview) {
		this.pdReview = pdReview;
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
}