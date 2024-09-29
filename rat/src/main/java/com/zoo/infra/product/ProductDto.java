package com.zoo.infra.product;

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
  // ----------------------------------
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
