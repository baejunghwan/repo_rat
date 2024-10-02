package com.zoo.infra.code;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.zoo.infra.codegroup.CodeGroupDto;

public class CodeDto {

	private String ifcdSeq;
	private String ifcdName;
	private Integer ifcdUseNy;
	private Integer ifcdOrder;
	private String ifcdDesc;
	private Integer ifcdDelNy;
	private Date regDateTime;
	private Date modDateTime;
	private Integer infrcodegroup_ifcgSeq;

	// count
	private Integer xifcdSeqCount;

	// search 관련된건 vo
	private String ifcgSeq;
	private String ifcgName;
	
	// search
	private Integer shDelNy;
	private Integer shUseNy;
	private Integer shOption;
	private String shValue;

//	for cache
	public static List<CodeDto> cachedCodeArrayList = new ArrayList<CodeDto>();
	// ----------------------
	public String getIfcdSeq() {
		return ifcdSeq;
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

	public void setIfcdSeq(String ifcdSeq) {
		this.ifcdSeq = ifcdSeq;
	}

	public String getIfcdName() {
		return ifcdName;
	}

	public void setIfcdName(String ifcdName) {
		this.ifcdName = ifcdName;
	}

	public Integer getIfcdUseNy() {
		return ifcdUseNy;
	}

	public void setIfcdUseNy(Integer ifcdUseNy) {
		this.ifcdUseNy = ifcdUseNy;
	}

	public Integer getIfcdOrder() {
		return ifcdOrder;
	}

	public void setIfcdOrder(Integer ifcdOrder) {
		this.ifcdOrder = ifcdOrder;
	}

	public String getIfcdDesc() {
		return ifcdDesc;
	}

	public void setIfcdDesc(String ifcdDesc) {
		this.ifcdDesc = ifcdDesc;
	}

	public Integer getIfcdDelNy() {
		return ifcdDelNy;
	}

	public void setIfcdDelNy(Integer ifcdDelNy) {
		this.ifcdDelNy = ifcdDelNy;
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

	public Integer getInfrcodegroup_ifcgSeq() {
		return infrcodegroup_ifcgSeq;
	}

	public void setInfrcodegroup_ifcgSeq(Integer infrcodegroup_ifcgSeq) {
		this.infrcodegroup_ifcgSeq = infrcodegroup_ifcgSeq;
	}

	public Integer getXifcdSeqCount() {
		return xifcdSeqCount;
	}

	public void setXifcdSeqCount(Integer xifcdSeqCount) {
		this.xifcdSeqCount = xifcdSeqCount;
	}

	public String getIfcgName() {
		return ifcgName;
	}

	public void setIfcgName(String ifcgName) {
		this.ifcgName = ifcgName;
	}

	public String getIfcgSeq() {
		return ifcgSeq;
	}

	public void setIfcgSeq(String ifcgSeq) {
		this.ifcgSeq = ifcgSeq;
	}

	public static List<CodeDto> getCachedCodeArrayList() {
		return cachedCodeArrayList;
	}

	public static void setCachedCodeArrayList(List<CodeDto> cachedCodeArrayList) {
		CodeDto.cachedCodeArrayList = cachedCodeArrayList;
	}
	
}
