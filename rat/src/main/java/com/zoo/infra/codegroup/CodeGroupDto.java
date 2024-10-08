package com.zoo.infra.codegroup;

// 필요한 라이브러리 임포트
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CodeGroupDto {

	// 코드 그룹의 고유 식별자
	private String ifcgSeq;
	// 코드 그룹의 이름
	private String ifcgName;
	// 코드 그룹 사용 여부 (1: 사용, 0: 미사용)
	private Integer ifcgUseNy;
	// 코드 그룹의 정렬 순서
	private Integer ifcgOrder;
	// 코드 그룹 설명
	private String ifcgDesc;
	// 코드 그룹 삭제 여부 (1: 삭제됨, 0: 정상)
	private Integer ifcgDelNy;
	// 등록 일시
	private Date regDateTime;
	// 수정 일시
	private Date modDateTime;

	// 포맷된 날짜 문자열 (등록 일시)
	private String formattedRegDateTime;
	// 포맷된 날짜 문자열 (수정 일시)
	private String formattedModDateTime;

	// 코드 그룹의 항목 수 카운트
	private Integer xifcgSeqCount;

	// 관련 코드의 고유 식별자
	private String ifcdSeq;
	// 관련 코드의 이름
	private String ifcdName;

	// 검색 필드
	private Integer shDelNy; // 삭제 여부로 필터링
	private Integer shUseNy; // 사용 여부로 필터링
	private Integer shOption; // 검색 옵션
	private String shValue; // 검색 값

	// -----------------------------------------------------

	// 등록 일시를 문자열로 설정 (변환 후 Date 객체로 저장)
	public void setRegDateTime(String regDateTime) {
		this.regDateTime = convertStringToDate(regDateTime);
	}

	// 각 필드에 대한 getter 및 setter 메서드

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

	// 수정 일시를 문자열로 설정 (변환 후 Date 객체로 저장)
	public void setModDateTime(String modDateTime) {
		this.modDateTime = convertStringToDate(modDateTime);
	}

	// 문자열을 Date 객체로 변환하는 메서드
	private Date convertStringToDate(String dateString) {
		if (dateString == null || dateString.isEmpty()) {
			return null; // null 또는 빈 문자열 처리
		}
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return formatter.parse(dateString); // 문자열을 Date 객체로 변환
		} catch (ParseException e) {
			e.printStackTrace(); // 변환 중 에러 발생 시 스택 트레이스 출력
			return null; // 변환 실패 시 null 반환
		}
	}
}
