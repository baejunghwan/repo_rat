package com.zoo.infra.code;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.zoo.infra.codegroup.CodeGroupDto;
import com.zoo.infra.codegroup.CodeGroupVo;

@Repository
public interface CodeDao {

	public List<CodeDto> selectList(CodeVo codeVo);

//	 내가 작성한 VO
//	public List<CodeVo> selectList();

	public CodeDto selectOne(CodeDto codeDto);
	// mybatics가 select일때는 값을 다 하나씩 땅땅 매핑해주고 나머지 insert,update,delete일때는 int형태로
	// 받아준다.
	// 이 구문의 의미는 mapper에서 쟁반을 들고 오면 dto로 넘겨주는 역할을 하는 용도.

	public int insert(CodeDto codeDto);
//	int쓰는 이유가 mybatis가 값 몇건 이렇게 정수 형식으로 보내줘서이다.

	public int update(CodeDto codeDto);

	public int delete(CodeDto codeDto);

	public int uelete(CodeDto codeDto);
	
	//paging
	public int selectOneCount(CodeVo codevo);
	
	//for cache
		public List<CodeDto> selectListCachedCodeArrayList();

}
