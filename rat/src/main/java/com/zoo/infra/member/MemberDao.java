package com.zoo.infra.member;

	import java.util.List;
	import org.springframework.stereotype.Repository;

import com.zoo.infra.codegroup.CodeGroupDto;
import com.zoo.infra.codegroup.CodeGroupVo;

	@Repository
	public interface MemberDao {

		public List<MemberDto> selectList(MemberVo memberVo);

		public List<MemberVo> selectList();

		public MemberDto selectOne(MemberDto memberDto);

		public int insert(MemberDto memberDto);

		public int update(MemberDto memberDto);

		public int delete(MemberDto memberDto);

		public int uelete(MemberDto memberDto);
		
		//paging
		public int selectOneCount(MemberVo vo);
		
		//for cache
		public List<MemberDto> selectListCachedCodeArrayList();

}