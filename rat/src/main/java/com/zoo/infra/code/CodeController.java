package com.zoo.infra.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zoo.infra.codegroup.CodeGroupDto;
import com.zoo.infra.codegroup.CodeGroupService;

@Controller
public class CodeController {

	@Autowired
	CodeService codeService;

	@Autowired
	private CodeGroupService codeGroupService;

	@RequestMapping(value = "/xdm/v1/infra/code/codeXdmForm")
	public String codeXdmForm(Model model, CodeVo codeVo) {
		List<CodeDto> ifcdSeq = codeService.selectList(codeVo);
		model.addAttribute("list", ifcdSeq); // list를 model에 추가

		List<CodeGroupDto> codeGroups = codeGroupService.getAllCodeGroups(); // 코드 그룹 가져오기
		model.addAttribute("codeGroups", codeGroups); // 코드 그룹을 모델에 추가
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
	public String codeXdmList(@ModelAttribute("vo") CodeVo codeVo, Model model) throws Exception {
//		System.out.println("Initial values: thisPage = " + codeVo.getThisPage() + ", rowNumToShow = "
//				+ codeVo.getRowNumToShow() + ", pageNumToShow = " + codeVo.getPageNumToShow());
//
//		// 페이지네이션을 위한 파라미터 설정
//		codeVo.setStartRnumForMysql((codeVo.getThisPage() - 1) * codeVo.getRowNumToShow());
//
//		// 리스트 조회
//		List<CodeDto> ifcdSeq = codeService.selectList(codeVo);
//		for (CodeDto codeDto : ifcdSeq) {
//			System.out.println("CodeDto codeDto : " + codeDto.getModDateTime());
//		}
//
//		model.addAttribute("list", codeService.selectList(codeVo));
////		for (int i=0; i<10; i++) {
////			System.out.println("ifcdSeq : " + codeService.selectList(codeVo).get(i));
////		}
//
//		// totalRows를 조회하여 확인
//		int totalRows = codeService.selectOneCount(codeVo);
//		System.out.println("Total rows from database: " + totalRows);
//
//		codeVo.setParamsPaging(codeService.selectOneCount(codeVo));
//
//		if (codeVo.getTotalRows() > 0) {
////			List<CodeGroupDao> list = codeGroupService.selectList(vo));
//			model.addAttribute("list", codeService.selectList(codeVo));
//		}

		//
		System.out.println("Initial values: thisPage = " + codeVo.getThisPage() + ", rowNumToShow = "
				+ codeVo.getRowNumToShow() + ", pageNumToShow = " + codeVo.getPageNumToShow());

// 페이지네이션을 위한 파라미터 설정
		codeVo.setStartRnumForMysql((codeVo.getThisPage() - 1) * codeVo.getRowNumToShow());

// 리스트 조회
		List<CodeDto> ifcgSeq = codeService.selectList(codeVo);
		model.addAttribute("list", ifcgSeq);

// 조회한 리스트 크기 확인
		System.out.println("Fetched list size: " + ifcgSeq.size());

// totalRows를 조회하여 확인
		int totalRows = codeService.selectOneCount(codeVo);
		System.out.println("Total rows from database: " + totalRows);

// 페이지네이션 세부사항 설정
		codeVo.setParamsPaging(totalRows);

		// 페이지네이션 상태 확인
		System.out.println("After pagination setup: ");
		System.out.println("rowNumToShow: " + codeVo.getRowNumToShow());
		System.out.println("pageNumToShow: " + codeVo.getPageNumToShow());
		System.out.println("totalRows: " + codeVo.getTotalRows());
		System.out.println("totalPages: " + codeVo.getTotalPages());
		System.out.println("startPage: " + codeVo.getStartPage());
		System.out.println("endPage: " + codeVo.getEndPage());

		return "/xdm/v1/infra/code/codeXdmList";
	}

}
