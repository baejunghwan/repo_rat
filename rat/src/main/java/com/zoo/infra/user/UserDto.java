package com.zoo.infra.user;

import java.util.Date;

public class UserDto {
	
	private String usrSeq;
	private String usrName;
	private Integer usrUseNy;
	private Integer usrDelNy;
	private Integer usrOrder;
	private String usrDesc;
	private Date regDateTime;
	private Date modDateTime;
	// ------------------------------
	public String getUsrSeq() {
		return usrSeq;
	}
	public void setUsrSeq(String usrSeq) {
		this.usrSeq = usrSeq;
	}
	public String getUsrName() {
		return usrName;
	}
	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}
	public Integer getUsrUseNy() {
		return usrUseNy;
	}
	public void setUsrUseNy(Integer usrUseNy) {
		this.usrUseNy = usrUseNy;
	}
	public Integer getUsrDelNy() {
		return usrDelNy;
	}
	public void setUsrDelNy(Integer usrDelNy) {
		this.usrDelNy = usrDelNy;
	}
	public Integer getUsrOrder() {
		return usrOrder;
	}
	public void setUsrOrder(Integer usrOrder) {
		this.usrOrder = usrOrder;
	}
	public String getUsrDesc() {
		return usrDesc;
	}
	public void setUsrDesc(String usrDesc) {
		this.usrDesc = usrDesc;
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
