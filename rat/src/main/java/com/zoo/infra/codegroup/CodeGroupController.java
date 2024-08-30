package com.zoo.infra.codegroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeGroupController {

	@Autowired
	CodeGroupService codeGroupService;
	
	@RequestMapping(value="/v1/infra/codegroup/codeGroupXdmList")
	public String codeGroupXdmList(Model model) {
		model.addAttribute("list", codeGroupService.selectList());
		return "/xdm/v1/infra/codegroup/codeGroupXdmList";
	}
	
	@RequestMapping(value="/v1/infra/codegroup/codeGroupXdmForm")
	public String codeGroupXdmForm() {
		return "/xdm/v1/infra/codegroup/codeGroupXdmForm";		
	}
	
	@RequestMapping(value="/v1/infra/codegroup/codeGroupXdmInst")
	public String codeGroupXdmInst(CodeGroupDto codeGroupDto) {
//		(데이터 타입, 변수)
//		애는 함수 정의 
		
//		html에서 넘어온 정보가 정상적인지 확인 
		System.out.println("codeGroupDto.getIfcgName(): " + codeGroupDto.getIfcgName());
		
//		codeGroupService.insert(codeGroupDto);
//		애는 service에 있는 함수 사용
		return "redirect:/v1/infra/codegroup/codeGroupXdmList";
	}
}
