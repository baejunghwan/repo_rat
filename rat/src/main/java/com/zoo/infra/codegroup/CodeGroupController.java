package com.zoo.infra.codegroup;

// 필요한 라이브러리와 클래스 임포트
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired; // 의존성 주입을 위한 어노테이션
import org.springframework.stereotype.Controller; // 컨트롤러 클래스 표시
import org.springframework.ui.Model; // 모델을 다루기 위한 클래스
import org.springframework.web.bind.annotation.ModelAttribute; // 모델 속성을 바인딩
import org.springframework.web.bind.annotation.RequestMapping; // 요청 매핑을 위한 어노테이션

@Controller
public class CodeGroupController {

	@Autowired
	private CodeGroupService codeGroupService; // 서비스 클래스 주입: 비즈니스 로직을 처리하는 클래스

	// 코드 그룹 목록을 보여주는 메서드
	@RequestMapping(value = "/xdm/v1/infra/codegroup/codeGroupXdmList")
	public String codeGroupXdmList(@ModelAttribute("vo") CodeGroupVo vo, Model model) throws Exception {
		// 현재 페이지, 보여줄 행 수, 페이지 수 출력
		System.out.println("Initial values: thisPage = " + vo.getThisPage() + ", rowNumToShow = " + vo.getRowNumToShow()
				+ ", pageNumToShow = " + vo.getPageNumToShow());

		// 페이지네이션을 위한 시작 행 번호 계산
		vo.setStartRnumForMysql((vo.getThisPage() - 1) * vo.getRowNumToShow());

		// 코드 그룹 리스트 조회
		List<CodeGroupDto> ifcgSeq = codeGroupService.selectList(vo);
		model.addAttribute("list", ifcgSeq); // 조회한 리스트를 모델에 추가

		// 조회한 리스트 크기 출력
		System.out.println("Fetched list size: " + ifcgSeq.size());

		// 데이터베이스에서 총 행 수를 조회
		int totalRows = codeGroupService.selectOneCount(vo);
		System.out.println("Total rows from database: " + totalRows);

		// 페이지네이션 세부사항 설정
		vo.setParamsPaging(totalRows);

		// 페이지네이션 상태 출력
		System.out.println("After pagination setup: ");
		System.out.println("rowNumToShow: " + vo.getRowNumToShow());
		System.out.println("pageNumToShow: " + vo.getPageNumToShow());
		System.out.println("totalRows: " + vo.getTotalRows());
		System.out.println("totalPages: " + vo.getTotalPages());
		System.out.println("startPage: " + vo.getStartPage());
		System.out.println("endPage: " + vo.getEndPage());

		return "/xdm/v1/infra/codegroup/codeGroupXdmList"; // 최종적으로 렌더링할 템플릿 경로 반환
	}

	// 코드 그룹 생성 폼을 반환하는 메서드
	@RequestMapping(value = "/xdm/v1/infra/codegroup/codeGroupXdmForm")
	public String codeGroupXdmForm() {
		return "/xdm/v1/infra/codegroup/codeGroupXdmForm"; // 생성 폼 페이지 반환
	}

	// 코드 그룹을 등록하는 메서드
	@RequestMapping(value = "/xdm/v1/infra/codegroup/codeGroupXdmInst")
	public String codeGroupXdmInst(CodeGroupDto codeGroupDto) {
		// 등록할 DTO 정보 출력
		System.out.println("codeGroupDto.getIfcgName(): " + codeGroupDto.getIfcgName());

		// 데이터베이스에 DTO 정보 저장
		int a = codeGroupService.insert(codeGroupDto);
		System.out.println("codeGroupService.insert(codeGroupDto): " + a);

		// 리스트 페이지로 리다이렉트
		return "redirect:/xdm/v1/infra/codegroup/codeGroupXdmList";
	}

	// 코드 그룹 수정 폼을 반환하는 메서드
	@RequestMapping(value = "/xdm/v1/infra/codegroup/codeGroupXdmMfom")
	public String codeGroupXdmMfom(CodeGroupDto codeGroupDto, Model model) {
		// 수정할 항목을 모델에 추가
		model.addAttribute("item", codeGroupService.selectOne(codeGroupDto));
		return "/xdm/v1/infra/codegroup/codeGroupXdmMfom"; // 수정 폼 페이지 반환
	}

	// 코드 그룹을 업데이트하는 메서드
	@RequestMapping(value = "/xdm/v1/infra/codegroup/codeGroupXdmUpdate")
	public String codeGroupXdmUpdate(CodeGroupDto codeGroupDto) {
		// 수정할 DTO 정보 출력
		System.out.println("codeGroupDto.getIfcgSeq(): " + codeGroupDto.getIfcgSeq());

		// 데이터베이스에서 DTO 정보를 업데이트
		int b = codeGroupService.update(codeGroupDto);
		System.out.println("codeGroupService.update(codeGroupDto): " + b);

		// 리스트 페이지로 리다이렉트
		return "redirect:/xdm/v1/infra/codegroup/codeGroupXdmList";
	}

	// 코드 그룹을 삭제하는 메서드
	@RequestMapping(value = "/xdm/v1/infra/codegroup/codeGroupXdmDelete")
	public String codeGroupXdmDelete(CodeGroupDto codeGroupDto) {
		// 삭제할 DTO 정보 출력
		System.out.println("codeGroupDto.getIfcgSeq(): " + codeGroupDto.getIfcgSeq());

		// 데이터베이스에서 DTO 정보를 삭제
		int c = codeGroupService.delete(codeGroupDto);
		System.out.println("codeGroupService.delete(codeGroupDto): " + c);

		// 리스트 페이지로 리다이렉트
		return "redirect:/xdm/v1/infra/codegroup/codeGroupXdmList";
	}

	// 코드 그룹을 복구하는 메서드 (Soft Delete)
	@RequestMapping(value = "/xdm/v1/infra/codegroup/codeGroupXdmUelete")
	public String codeGroupXdmUelete(CodeGroupDto codeGroupDto) {
		// 복구할 DTO 정보 출력
		System.out.println("codeGroupDto.getIfcgSeq(): " + codeGroupDto.getIfcgSeq());

		// 데이터베이스에서 DTO 정보를 복구
		int d = codeGroupService.uelete(codeGroupDto);
		System.out.println("codeGroupService.uelete(codeGroupDto): " + d);

		// 리스트 페이지로 리다이렉트
		return "redirect:/xdm/v1/infra/codegroup/codeGroupXdmList";
	}

	// 모든 코드 그룹을 가져오는 메서드
	public List<CodeGroupDto> getAllCodeGroups() {
		return codeGroupService.getAllCodeGroups(); // 서비스 호출
	}
}
