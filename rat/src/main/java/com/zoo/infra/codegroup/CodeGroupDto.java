package com.zoo.infra.codegroup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class CodeGroupDto {

	private String ifcgSeq;
	private String ifcgName;
	private Integer ifcgUseNy;
	private Integer ifcgOrder;
	private String ifcgDesc;
	private Integer ifcgDelNy;
	private Date regDateTime;
	private Date modDateTime;

	private String formattedRegDateTime;
	private String formattedModDateTime;

	private Integer xifcgSeqCount;

	private String ifcdSeq;
	private String ifcdName;

	private Integer shDelNy; 
	private Integer shUseNy; 
	private Integer shOption; 
	private String shValue; 
	
	//AWS
	private MultipartFile uploadFile;
	private MultipartFile[] uploadFiles;
	
	private String seq;
	private Integer type;
	private Integer defaultNy;
	private Integer sort;
	private String path;
	private String originalName;
	private String uuidName;
	private String ext;
	private Integer size;
	private Integer delNy;
	private Integer pseq;
	private String regIp;
	private Integer regSeq;
	private Integer regDeviceCd;
	private Date regDateTimeSvr;
	private String tableName;
	// -----------------------------------------------------
	public void setRegDateTime(String regDateTime) {
		this.regDateTime = convertStringToDate(regDateTime);
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getDefaultNy() {
		return defaultNy;
	}

	public void setDefaultNy(Integer defaultNy) {
		this.defaultNy = defaultNy;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public String getUuidName() {
		return uuidName;
	}

	public void setUuidName(String uuidName) {
		this.uuidName = uuidName;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getDelNy() {
		return delNy;
	}

	public void setDelNy(Integer delNy) {
		this.delNy = delNy;
	}

	public Integer getPseq() {
		return pseq;
	}

	public void setPseq(Integer pseq) {
		this.pseq = pseq;
	}

	public String getRegIp() {
		return regIp;
	}

	public void setRegIp(String regIp) {
		this.regIp = regIp;
	}

	public Integer getRegSeq() {
		return regSeq;
	}

	public void setRegSeq(Integer regSeq) {
		this.regSeq = regSeq;
	}

	public Integer getRegDeviceCd() {
		return regDeviceCd;
	}

	public void setRegDeviceCd(Integer regDeviceCd) {
		this.regDeviceCd = regDeviceCd;
	}

	public Date getRegDateTimeSvr() {
		return regDateTimeSvr;
	}

	public void setRegDateTimeSvr(Date regDateTimeSvr) {
		this.regDateTimeSvr = regDateTimeSvr;
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	public MultipartFile[] getUploadFiles() {
		return uploadFiles;
	}

	public void setUploadFiles(MultipartFile[] uploadFiles) {
		this.uploadFiles = uploadFiles;
	}

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

	public String getFormattedRegDateTime() {
		return formattedRegDateTime;
	}

	public void setFormattedRegDateTime(String formattedRegDateTime) {
		this.formattedRegDateTime = formattedRegDateTime;
	}

	public String getFormattedModDateTime() {
		return formattedModDateTime;
	}

	public void setFormattedModDateTime(String formattedModDateTime) {
		this.formattedModDateTime = formattedModDateTime;
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

	public void setModDateTime(String modDateTime) {
		this.modDateTime = convertStringToDate(modDateTime);
	}

	private Date convertStringToDate(String dateString) {
		if (dateString == null || dateString.isEmpty()) {
			return null; 
		}
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return formatter.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			return null; 
		}
	}
}
