package com.zoo.infra.user;

import java.util.Date;

public class UserVo {

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

	private String shUseNy;
	private String shDelNy;
	private String shOptionDate;
	private String shOption;
	private Integer rowNumToShow;

	// ---------------------------------
	
	public String getUsrSeq() {
		return userSeq;
	}

	public Integer getRowNumToShow() {
		return rowNumToShow;
	}

	public void setRowNumToShow(Integer rowNumToShow) {
		this.rowNumToShow = rowNumToShow;
	}

	public String getShOption() {
		return shOption;
	}

	public void setShOption(String shOption) {
		this.shOption = shOption;
	}

	public String getShOptionDate() {
		return shOptionDate;
	}

	public void setShOptionDate(String shOptionDate) {
		this.shOptionDate = shOptionDate;
	}

	public String getShDelNy() {
		return shDelNy;
	}

	public void setShDelNy(String shDelNy) {
		this.shDelNy = shDelNy;
	}

	public String getShUseNy() {
		return shUseNy;
	}

	public void setShUseNy(String shUseNy) {
		this.shUseNy = shUseNy;
	}

	public String getUserSeq() {
		return userSeq;
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

	public void setUsrSeq(String userSeq) {
		this.userSeq = userSeq;
	}

	public String getUsrName() {
		return userName;
	}

	public void setUsrName(String userName) {
		this.userName = userName;
	}

	public Integer getUsrUseNy() {
		return userUseNy;
	}

	public void setUsrUseNy(Integer userUseNy) {
		this.userUseNy = userUseNy;
	}

	public Integer getUsrDelNy() {
		return userDelNy;
	}

	public void setUsrDelNy(Integer userDelNy) {
		this.userDelNy = userDelNy;
	}

	public Integer getUsrOrder() {
		return userOrder;
	}

	public void setUsrOrder(Integer userOrder) {
		this.userOrder = userOrder;
	}

	public String getUsrDesc() {
		return userDesc;
	}

	public void setUsrDesc(String userDesc) {
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

}
