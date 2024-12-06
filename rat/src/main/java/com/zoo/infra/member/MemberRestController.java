package com.zoo.infra.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "/rest/member")
public class MemberRestController {

	@Autowired
	MemberService memberService;
	
//	@RequestMapping(value = "", method = RequestMethod.GET) 옛날에 쓰던 방식 (지금은 거의안씀)
	@GetMapping("")
	public List<MemberDto> selectList(MemberVo vo) throws Exception {
		List<MemberDto> list = memberService.selectList(vo);
		System.out.println(list+"@@@@@@@@@@@@@");
		return list;
	}
	
	@GetMapping("/{memberSeq}")
	public MemberDto selectOne(MemberDto dto) throws Exception {
		MemberDto item = memberService.selectOne(dto);
		return item;
	}
	
}