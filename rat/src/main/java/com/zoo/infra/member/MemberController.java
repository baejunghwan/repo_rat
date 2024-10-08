package com.zoo.infra.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

// 회원 관련 요청을 처리하는 컨트롤러
@Controller
public class MemberController {

	@Autowired
	MemberService memberService; // MemberService를 자동 주입

	// 회원 목록 페이지 요청
	@RequestMapping(value = "/xdm/v1/infra/member/memberXdmList")
	public String memberXdmList(@ModelAttribute("vo") MemberVo vo, Model model) throws Exception {
		List<MemberDto> memberSeq = memberService.selectList(vo); // 회원 목록 조회
		for (MemberDto memberDto : memberSeq) {
			System.out.println("MemberDto memberDto : " + memberDto.getModDateTime()); // 수정 시간 출력
		}

		model.addAttribute("list", memberService.selectList(vo)); // 모델에 회원 목록 추가
		vo.setParamsPaging(memberService.selectOneCount(vo)); // 페이징 정보 설정

		return "/xdm/v1/infra/member/memberXdmList"; // 회원 목록 페이지 반환
	}

	// 회원 등록 폼 요청
	@RequestMapping(value = "/xdm/v1/infra/member/memberXdmForm")
	public String memberXdmForm() {
		return "/xdm/v1/infra/member/memberXdmForm"; // 회원 등록 폼 페이지 반환
	}

	// 회원 등록 처리
	@RequestMapping(value = "/xdm/v1/infra/member/memberXdmInst")
	public String memberXdmInst(MemberDto memberDto) {
		System.out.println("memberDto.getMemberName(): " + memberDto.getMemberName()); // 회원 이름 출력
		int a = memberService.insert(memberDto); // 회원 정보 등록
		System.out.println("memberService.insert(memberDto): " + a); // 등록 결과 출력
		return "redirect:/xdm/v1/infra/member/memberXdmList"; // 회원 목록 페이지로 리다이렉트
	}

	// 회원 상세 정보 요청
	@RequestMapping(value = "/xdm/v1/infra/member/memberXdmMfom")
	public String memberXdmMfom(MemberDto memberDto, Model model) {
		model.addAttribute("item", memberService.selectOne(memberDto)); // 회원 상세 정보 조회
		System.out.println("memberMfom Gender : " + memberService.selectOne(memberDto).getMemberGender()); // 성별 출력
		return "/xdm/v1/infra/member/memberXdmMfom"; // 상세 정보 페이지 반환
	}

	// 회원 정보 업데이트 처리
	@RequestMapping(value = "/xdm/v1/infra/member/memberXdmUpdate")
	public String memberXdmUpdate(MemberDto memberDto) {
		System.out.println("memberDto.getMemberSeq(): " + memberDto.getMemberSeq()); // 회원 시퀀스 출력
		int b = memberService.update(memberDto); // 회원 정보 업데이트
		System.out.println("memberService.update(memberDto): " + b); // 업데이트 결과 출력
		return "redirect:/xdm/v1/infra/member/memberXdmList"; // 회원 목록 페이지로 리다이렉트
	}

	// 회원 삭제 처리
	@RequestMapping(value = "/xdm/v1/infra/member/memberXdmDelete")
	public String memberXdmDelete(MemberDto memberDto) {
		System.out.println("memberDto.getMemberSeq(): " + memberDto.getMemberSeq()); // 회원 시퀀스 출력
		int c = memberService.delete(memberDto); // 회원 삭제
		System.out.println("memberService.delete(memberDto): " + c); // 삭제 결과 출력
		return "redirect:/xdm/v1/infra/member/memberXdmList"; // 회원 목록 페이지로 리다이렉트
	}

	// 회원 비활성화 처리
	@RequestMapping(value = "/xdm/v1/infra/member/memberXdmUelete")
	public String memberXdmUelete(MemberDto memberDto) {
		System.out.println("memberDto.getMemberSeq(): " + memberDto.getMemberSeq()); // 회원 시퀀스 출력
		int d = memberService.uelete(memberDto); // 회원 비활성화
		System.out.println("memberService.uelete(memberDto): " + d); // 비활성화 결과 출력
		return "redirect:/xdm/v1/infra/member/memberXdmList"; // 회원 목록 페이지로 리다이렉트
	}

	// 로그인 폼 요청
	@RequestMapping(value = "/xdm/v1/infra/member/membersigninXdmForm")
	public String membersigninXdmForm() {
		return "/xdm/v1/infra/member/membersigninXdmForm"; // 로그인 폼 페이지 반환
	}

	// AJAX 로그인 처리
	@ResponseBody
	@RequestMapping(value = "/xdm/v1/infra/member/membersigninProc")
	public Map<String, Object> membersigninProc(MemberDto memberdto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<>(); // 결과를 담을 맵
		MemberDto rtMember = memberService.selectOneLogin(memberdto); // 로그인 정보 조회

		if (rtMember != null) {
			System.out.println("성공"); // 로그인 성공 출력
			httpSession.setMaxInactiveInterval(60 * 3000); // 세션 만료 시간 설정
			httpSession.setAttribute("sessSeqXdm", rtMember.getMemberSeq()); // 세션에 회원 시퀀스 저장
			httpSession.setAttribute("sessIdXdm", rtMember.getMemberId()); // 세션에 회원 ID 저장
			httpSession.setAttribute("sessNameXdm", rtMember.getMemberName()); // 세션에 회원 이름 저장
			returnMap.put("rt", "success"); // 결과에 성공 추가
		} else {
			System.out.println("실패"); // 로그인 실패 출력
			returnMap.put("rt", "fail"); // 결과에 실패 추가
		}
		return returnMap; // 결과 반환
	}

	// 로그아웃 처리
	@ResponseBody
	@RequestMapping(value = "/xdm/v1/infra/member/signoutXdmProc")
	public Map<String, Object> signoutXdmProc(HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<>(); // 결과를 담을 맵
		httpSession.invalidate(); // 세션 무효화
		returnMap.put("rt", "success"); // 결과에 성공 추가
		return returnMap; // 결과 반환
	}

	// 회원가입 요청
	@RequestMapping(value = "/xdm/v1/infra/member/membersignupXdmForm")
	public String membersignupXdmForm() {
		return "/xdm/v1/infra/member/membersignupXdmForm"; // 회원가입 페이지 반환
	}

	// index 요청
	@RequestMapping(value = "/xdm/v1/infra/member/memberIndex")
	public String memberIndex() {
		return "/xdm/v1/infra/member/memberIndex"; // 회원가입 페이지 반환
	}

}