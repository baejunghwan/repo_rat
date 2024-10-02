package com.zoo.infra.codegroup;

public class CodeGroupDto {

	private String ifcgSeq;
	private String ifcgName;
	private Integer ifcgUseNy;
	private Integer ifcgOrder;
	private String ifcgDesc;
	private Integer ifcgDelNy;
	private String regDateTime;
	private String modDateTime;

//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	// count
	private Integer xifcgSeqCount;
	
	private String ifcdSeq;
	private String ifcdName;
	// search
	private Integer shDelNy;
	private Integer shUseNy;
	private Integer shOption;
	private String shValue;
	// ----------------------
	public String getIfcgSeq() {
		return ifcgSeq;
	}
	public void setIfcgSeq(String ifcgSeq) {
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
	public Integer getXifcgSeqCount() {
		return xifcgSeqCount;
	}
	public void setXifcgSeqCount(Integer xifcgSeqCount) {
		this.xifcgSeqCount = xifcgSeqCount;
	}
	public String getIfcdSeq() {
		return ifcdSeq;
	}
	public void setIfcdSeq(String ifcdSeq) {
		this.ifcdSeq = ifcdSeq;
	}
	public String getIfcdName() {
		return ifcdName;
	}
	public void setIfcdName(String ifcdName) {
		this.ifcdName = ifcdName;
	}
	public Integer getShDelNy() {
		return shDelNy;
	}
	public void setShDelNy(Integer shDelNy) {
		this.shDelNy = shDelNy;
	}
	public Integer getShUseNy() {
		return shUseNy;
	}
	public void setShUseNy(Integer shUseNy) {
		this.shUseNy = shUseNy;
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
	
}
