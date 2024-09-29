package com.zoo.infra.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zoo.common.util.UtilDateTime;

@Controller
public class CodeGroupController {

	@Autowired
	CodeGroupService codeGroupService;

//	@RequestMapping(value = "/xdm/v1/infra/codegroup/codeGroupXdmList")
//	public String codeGroupXdmList(Model model, CodeGroupVo codeGroupVo) {
//		List<CodeGroupDto> ifcgSeq = codeGroupService.selectList(codeGroupVo);
//		for (CodeGroupDto codeGroupDto : ifcgSeq) {
//			System.out.println("CodeGroupDto codeGroupDto : " + codeGroupDto.getModDateTime());
//		}
//
//		model.addAttribute("list", codeGroupService.selectList(codeGroupVo));
////		for (int i=0; i<10; i++) {
////			
////			System.out.println("ifcgSeq : " + codeGroupService.selectList(codeGroupVo).get(i));
////		}
//		
//		return "/xdm/v1/infra/codegroup/codeGroupXdmList";	
//	}

	@RequestMapping(value = "/xdm/v1/infra/codegroup/codeGroupXdmForm")
	public String codeGroupXdmForm() {
		
		return "/xdm/v1/infra/codegroup/codeGroupXdmForm";
		
	}

	@RequestMapping(value = "/xdm/v1/infra/codegroup/codeGroupXdmInst")
	public String codeGroupXdmInst(CodeGroupDto codeGroupDto) {
//		html에서 넘어온 정보가 정상적인지 확인 
		System.out.println("codeGroupDto.getIfcgName(): " + codeGroupDto.getIfcgName());

		int a = codeGroupService.insert(codeGroupDto);
		System.out.println("codeGroupService.insert(codeGroupDto): " + a);

		return "redirect:/xdm/v1/infra/codegroup/codeGroupXdmList";
		// return값이 아니라 주소를 써넣어야 한다.
//			Inst에서 CodeGroupDto의 codeGroupDto 함수를 끌어와서 사용
//			중간에 sysout은 html에서 서버쪽으로 정보가 넘어가는지 확인하는 로그	
//			redirect:는 내가 Inst하는 과정을 클라이언트한테 보여줄 필요가 없으니까 대체할 화면으로 사용하는 목적.
	}

	@RequestMapping(value = "/xdm/v1/infra/codegroup/codeGroupXdmMfom")
	public String codeGroupXdmMfom(CodeGroupDto codeGroupDto, Model model) {
		model.addAttribute("item", codeGroupService.selectOne(codeGroupDto));
		return "/xdm/v1/infra/codegroup/codeGroupXdmMfom";
	}

////	#내가 임의로 Update 작성한 부분 
	@RequestMapping(value = "/xdm/v1/infra/codegroup/codeGroupXdmUpdate")
	public String codeGroupXdmUpdate(CodeGroupDto codeGroupDto) {
//		html에서 넘어온 정보가 정상적인지 확인 
		System.out.println("codeGroupDto.getIfcgSeq(): " + codeGroupDto.getIfcgSeq());

		int b = codeGroupService.update(codeGroupDto);
		System.out.println("codeGroupService.update(codeGroupDto): " + b);
		return "redirect:/xdm/v1/infra/codegroup/codeGroupXdmList";
	}

	//// #내가 임의로 delete 작성한 부분
	@RequestMapping(value = "/xdm/v1/infra/codegroup/codeGroupXdmDelete")
	public String codeGroupXdmDelete(CodeGroupDto codeGroupDto) {
		// html에서 넘어온 정보가 정상적인지 확인
		System.out.println("codeGroupDto.getIfcgSeq(): " + codeGroupDto.getIfcgSeq());

		int c = codeGroupService.delete(codeGroupDto);
		System.out.println("codeGroupService.delete(codeGroupDto): " + c);
		return "redirect:/xdm/v1/infra/codegroup/codeGroupXdmList";
	}

	//// #내가 임의로 uelete 작성한 부분
	@RequestMapping(value = "/xdm/v1/infra/codegroup/codeGroupXdmUelete")
	public String codeGroupXdmUelete(CodeGroupDto codeGroupDto) {
		// html에서 넘어온 정보가 정상적인지 확인
		System.out.println("codeGroupDto.getIfcgSeq(): " + codeGroupDto.getIfcgSeq());

		int d = codeGroupService.uelete(codeGroupDto);
		System.out.println("codeGroupService.uelete(codeGroupDto): " + d);
		return "redirect:/xdm/v1/infra/codegroup/codeGroupXdmList";
	}

//	codeGroupService.update(codeGroupDto);
//	System.out.println("codeGroupService.update(codeGroupDto): " + codeGroupService.update(codeGroupDto));

//		@RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmMfom") 
//		public String codeGroupXdmMfom(CodeGroupDto codeGroupDto, Model model) { 
//			CodeGroupDto dto = codeGroupService.selectOne(codeGroupDto); 
//			model.addAttribute("item", dto); 
//			return "/xdm/v1/infra/codegroup/codeGroupXdmMfom";		
//}
	@RequestMapping(value = "/xdm/v1/infra/codegroup/codeGroupXdmList")
	public String codeGroupXdmList(@ModelAttribute("vo") CodeGroupVo vo, Model model) throws Exception{
		
		/* 초기값 세팅이 없는 경우 사용 */
//		vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(vo.getShDateStart()));
//		vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(vo.getShDateEnd()));

		List<CodeGroupDto> ifcgSeq = codeGroupService.selectList(vo);
		for (CodeGroupDto codeGroupDto : ifcgSeq) {
			System.out.println("CodeGroupDto codeGroupDto : " + codeGroupDto.getModDateTime());
		}
		
		model.addAttribute("list", codeGroupService.selectList(vo));
//		for (int i=0; i<10; i++) {
//		
//		System.out.println("ifcgSeq : " + codeGroupService.selectList(vo).get(i));
//	}
		
		vo.setParamsPaging(codeGroupService.selectOneCount(vo));
		
		if (vo.getTotalRows() > 0) {
//			List<CodeGroupDao> list = codeGroupService.selectList(vo));
			model.addAttribute("list", codeGroupService.selectList(vo));
		}
		
//		return pathCommonXdm + "codeGroupXdmList";
		return "/xdm/v1/infra/codegroup/codeGroupXdmList";
  	}
}