package com.zoo.infra.user;

import java.util.Date;
import java.util.List;

import com.zoo.infra.code.CodeDto;
import com.zoo.infra.product.ProductDto;

public class UserDto {

	private String userSeq;
	private String userName;
	private Integer userUseNy;
	private Integer userDelNy;
	private Integer userOrder;
	private String userDesc;
	private Date regDateTime;
	private Date modDateTime;

	// Login
	private String userId;
	private String userPw;
	private String userEmail;
	private String userTel;

	private String rtUser;
	
	private Integer xuserSeqCount;
	
	// 다른 필드
	// Product 관련 필드
	private List<ProductDto> productList;
	private List<CodeDto> codeList;
	
	// ------------------------------
	
	public String getUserSeq() {
		return userSeq;
	}

	public Integer getXuserSeqCount() {
		return xuserSeqCount;
	}

	public void setXuserSeqCount(Integer xuserSeqCount) {
		this.xuserSeqCount = xuserSeqCount;
	}

	public List<CodeDto> getCodeList() {
		return codeList;
	}

	public void setCodeList(List<CodeDto> codeList) {
		this.codeList = codeList;
	}

	public void setUserSeq(String userSeq) {
		this.userSeq = userSeq;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserUseNy() {
		return userUseNy;
	}

	public void setUserUseNy(Integer userUseNy) {
		this.userUseNy = userUseNy;
	}

	public Integer getUserDelNy() {
		return userDelNy;
	}

	public void setUserDelNy(Integer userDelNy) {
		this.userDelNy = userDelNy;
	}

	public Integer getUserOrder() {
		return userOrder;
	}

	public void setUserOrder(Integer userOrder) {
		this.userOrder = userOrder;
	}

	public String getUserDesc() {
		return userDesc;
	}

	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getRtUser() {
		return rtUser;
	}

	public void setRtUser(String rtUser) {
		this.rtUser = rtUser;
	}

	public List<ProductDto> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductDto> productList) {
		this.productList = productList;
	}

}
