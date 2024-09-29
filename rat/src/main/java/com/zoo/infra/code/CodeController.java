package com.zoo.infra.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zoo.infra.codegroup.CodeGroupDto;
import com.zoo.infra.codegroup.CodeGroupVo;

@Controller
public class CodeController {

	@Autowired
	CodeService codeService;

	@RequestMapping(value = "/xdm/v1/infra/code/codeXdmForm")
	public String codeXdmForm(Model model,CodeVo codeVo) {
		List<CodeDto> ifcdSeq = codeService.selectList(codeVo);
		model.addAttribute("list", ifcdSeq);
		return "/xdm/v1/infra/code/codeXdmForm";
	}

	@RequestMapping(value = "/xdm/v1/infra/code/codeXdmInst")
	public String codeXdmInst(CodeDto codeDto) {
//		html에서 넘어온 정보가 정상적인지 확인 
//		System.out.println("codeDto.getIfcdName(): " + codeDto.getIfcdName());

		int a = codeService.insert(codeDto);
//		System.out.println("codeService.insert(codeDto): " + a);

		return "redirect:/xdm/v1/infra/code/codeXdmList";
		// return값이 아니라 주소를 써넣어야 한다.
//		-----
//			Inst에서 CodeDto의 codeDto 함수를 끌어와서 사용
//			중간에 sysout은 html에서 서버쪽으로 정보가 넘어가는지 확인하는 로그	
//			redirect:는 내가 Inst하는 과정을 클라이언트한테 보여줄 필요가 없으니까 대체할 화면으로 사용하는 목적.
	}

	@RequestMapping(value = "/xdm/v1/infra/code/codeXdmMfom")
	public String codeXdmMfom(CodeDto codeDto, Model model) {
		model.addAttribute("item", codeService.selectOne(codeDto));
		return "/xdm/v1/infra/code/codeXdmMfom";
	}

////	#내가 임의로 Update 작성한 부분 
	@RequestMapping(value = "/xdm/v1/infra/code/codeXdmUpdate")
	public String codeXdmUpdate(CodeDto codeDto) {
//		html에서 넘어온 정보가 정상적인지 확인 
		System.out.println("codeDto.getIfcdSeq(): " + codeDto.getIfcdSeq());

		int b = codeService.update(codeDto);
		System.out.println("codeService.update(codeDto): " + b);
		return "redirect:/xdm/v1/infra/code/codeXdmList";
	}

	//// #내가 임의로 delete 작성한 부분
	@RequestMapping(value = "/xdm/v1/infra/code/codeXdmDelete")
	public String codeXdmDelete(CodeDto codeDto) {
		// html에서 넘어온 정보가 정상적인지 확인
		System.out.println("codeDto.getIfcdSeq(): " + codeDto.getIfcdSeq());

		int c = codeService.delete(codeDto);
		System.out.println("codeService.delete(codeDto): " + c);
		return "redirect:/xdm/v1/infra/code/codeXdmList";
	}

	//// #내가 임의로 uelete 작성한 부분
	@RequestMapping(value = "/xdm/v1/infra/code/codeXdmUelete")
	public String codeXdmUelete(CodeDto codeDto) {
		// html에서 넘어온 정보가 정상적인지 확인
		System.out.println("codeDto.getIfcdSeq(): " + codeDto.getIfcdSeq());

		int d = codeService.uelete(codeDto);
		System.out.println("codeService.uelete(codeDto): " + d);
		return "redirect:/xdm/v1/infra/code/codeXdmList";
	}

//	codeService.update(codeDto);
//	System.out.println("codeService.update(codeDto): " + codeService.update(codeDto));

//		@RequestMapping(value="/v1/infra/code/codeXdmMfom") 
//		public String codeXdmMfom(CodeDto codeDto, Model model) { 
//			CodeDto dto = codeService.selectOne(codeDto); 
//			model.addAttribute("item", dto); 
//			return "/xdm/v1/infra/code/codeXdmMfom";		
//}
	
	@RequestMapping(value = "/xdm/v1/infra/code/codeXdmList")
	public String codeXdmList(@ModelAttribute("vo") CodeVo codeVo, Model model) throws Exception{
		List<CodeDto> ifcdSeq = codeService.selectList(codeVo);
		for (CodeDto codeDto : ifcdSeq) {
			System.out.println("CodeDto codeDto : " + codeDto.getModDateTime());
		}

		model.addAttribute("list", codeService.selectList(codeVo));
//		for (int i=0; i<10; i++) {
//			System.out.println("ifcdSeq : " + codeService.selectList(codeVo).get(i));
//		}
		
		codeVo.setParamsPaging(codeService.selectOneCount(codeVo));
		
		if (codeVo.getTotalRows() > 0) {
//			List<CodeGroupDao> list = codeGroupService.selectList(vo));
			model.addAttribute("list", codeService.selectList(codeVo));
		}
		
		return "/xdm/v1/infra/code/codeXdmList";	
		
	}
}
