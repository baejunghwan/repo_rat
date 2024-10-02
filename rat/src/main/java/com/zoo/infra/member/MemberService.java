package com.zoo.infra.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	public MemberDao memberDao;

	public List<MemberDto> selectList(MemberVo memberVo) {
		return memberDao.selectList(memberVo);
	}

	public MemberDto selectOne(MemberDto memberDto) {
		return memberDao.selectOne(memberDto);
	}

	public int insert(MemberDto memberDto) {
		return memberDao.insert(memberDto);
	}

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
	
	//login
	public MemberDto selectOneLogin(MemberDto memberDto) {
		return memberDao.selectOneLogin(memberDto);
	}
	
}