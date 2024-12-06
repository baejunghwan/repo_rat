package com.zoo.infra.code;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CodeDao {

	public List<CodeDto> selectList(CodeVo codeVo);

	// mybatics가 select일때는 값을 다 하나씩 땅땅 매핑해주고 나머지 insert,update,delete일때는 int형태로 받아줌
	public CodeDto selectOne(CodeDto codeDto);

	//int쓰는 이유가 mybatis가 값 몇건 이렇게 정수 형식으로 보내줘서이다.
	public int insert(CodeDto codeDto);

	public int update(CodeDto codeDto);

	public int delete(CodeDto codeDto);

	public int uelete(CodeDto codeDto);

	// paging
	public int selectOneCount(CodeVo vo);

	// for cache
	public List<CodeDto> selectListCachedCodeArrayList();
}