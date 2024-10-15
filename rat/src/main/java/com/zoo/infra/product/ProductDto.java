package com.zoo.infra.product;

import java.math.BigDecimal;
import java.util.Date;

public class ProductDto {

	private Integer productSeq;
	private String productName;
	private Integer productUseNy;
	private Integer productOrder;
	private String productDesc;
	private Integer productDelNy;
	private Date regDateTime;
	private Date modDateTime;
	private Integer member_memberSeq;

	// 새로 추가한 칼럼들
	private String productImg;
	private String productTitle;
	private String productReview;
	private Integer productPrice;
	private Integer productPriceDcRate;
	private BigDecimal productRating;
	private String productReply;
	private Integer productfavorite;	
	// ----------------------------------
	
	public Integer getProductSeq() {
		return productSeq;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getProductReview() {
		return productReview;
	}

	public void setProductReview(String productReview) {
		this.productReview = productReview;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getProductPriceDcRate() {
		return productPriceDcRate;
	}

	public void setProductPriceDcRate(Integer productPriceDcRate) {
		this.productPriceDcRate = productPriceDcRate;
	}

	public BigDecimal getProductRating() {
		return productRating;
	}

	public void setProductRating(BigDecimal productRating) {
		this.productRating = productRating;
	}

	public String getProductReply() {
		return productReply;
	}

	public void setProductReply(String productReply) {
		this.productReply = productReply;
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

	public Integer getProductOrder() {
		return productOrder;
	}

	public void setProductOrder(Integer productOrder) {
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

}
