package com.zoo.infra.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoo.infra.codegroup.CodeGroupDto;
import com.zoo.infra.codegroup.CodeGroupVo;

import jakarta.annotation.PostConstruct;

@Service
public class MemberService {
	// 로직 알고리즘 영역 = service
	@Autowired
	public MemberDao memberDao;

	public List<MemberDto> selectList(MemberVo memberVo) {
		return memberDao.selectList(memberVo);
	}

	public int insert(MemberDto memberDto) {
		return memberDao.insert(memberDto);
	}

	public MemberDto selectOne(MemberDto memberDto) {
		return memberDao.selectOne(memberDto);
	}
//  함수 선언은 (데이터 타입, 데이터) 사용은 (하나만) : 이게 제일큰 차이점.

	public int update(MemberDto memberDto) {
		return memberDao.update(memberDto);
	}

	public int delete(MemberDto memberDto) {
		return memberDao.delete(memberDto);
	}

	public int uelete(MemberDto memberDto) {
		return memberDao.uelete(memberDto);
	}
	
	//paging
		public int selectOneCount(MemberVo vo) { 
	    	return memberDao.selectOneCount(vo); 
	    }
}
