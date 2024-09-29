package com.zoo.infra.member;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zoo.infra.codegroup.CodeGroupDto;

public class MemberDto {
		
  private Integer memberSeq;
  private String memberName;
  private Integer memberUseNy;
  private Integer memberOrder;
  private String memberDesc; 
  private Integer memberDelNy; 
  private Date regDateTime; 
  private Date modDateTime; 
  private Integer memberGender;
  
  //count
  private Integer memberSeqCount;
  //for cache
	public static List<MemberDto> cachedCodeArrayList = new ArrayList<MemberDto>();
  // ----------------------------
	public Integer getMemberSeq() {
		return memberSeq;
	}
	public void setMemberSeq(Integer memberSeq) {
		this.memberSeq = memberSeq;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public Integer getMemberUseNy() {
		return memberUseNy;
	}
	public void setMemberUseNy(Integer memberUseNy) {
		this.memberUseNy = memberUseNy;
	}
	public Integer getMemberOrder() {
		return memberOrder;
	}
	public void setMemberOrder(Integer memberOrder) {
		this.memberOrder = memberOrder;
	}
	public String getMemberDesc() {
		return memberDesc;
	}
	public void setMemberDesc(String memberDesc) {
		this.memberDesc = memberDesc;
	}
	public Integer getMemberDelNy() {
		return memberDelNy;
	}
	public void setMemberDelNy(Integer memberDelNy) {
		this.memberDelNy = memberDelNy;
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
	public Integer getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(Integer memberGender) {
		this.memberGender = memberGender;
	}
	public Integer getMemberSeqCount() {
		return memberSeqCount;
	}
	public void setMemberSeqCount(Integer memberSeqCount) {
		this.memberSeqCount = memberSeqCount;
	}
	public static List<MemberDto> getCachedCodeArrayList() {
		return cachedCodeArrayList;
	}
	public static void setCachedCodeArrayList(List<MemberDto> cachedCodeArrayList) {
		MemberDto.cachedCodeArrayList = cachedCodeArrayList;
	}

}