package com.zoo.infra.codegroup;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CodeGroupDao {
	
	public List<CodeGroupDto> selectList();
	
	public int insert(CodeGroupDto codeGroupDto);
//	int쓰는 이유가 mybatis가 값 몇건이렇게 보내줘서이다.
	
}
