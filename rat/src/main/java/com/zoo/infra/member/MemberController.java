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
	@ResponseBody // 이 메서드의 반환값이 HTTP 응답 본문으로 직접 사용됨을 나타냄
	@RequestMapping(value = "/xdm/v1/infra/member/membersigninProc") // 이 URL로 요청이 들어오면 해당 메서드 호출
	public Map<String, Object> membersigninProc(MemberDto memberdto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>(); // 결과를 담을 맵 생성

		// 로그인 요청 로그 추가
		System.out.println("로그인 요청 - ID: " + memberdto.getMemberId() + ", PW: " + memberdto.getMemberPw());

		// 로그인 정보를 조회하여 MemberDto 객체로 반환
		MemberDto rtMember = memberService.selectOneLogin(memberdto); // 로그인 정보 조회
		System.out.println("로그인 정보 조회 결과: " + rtMember);

		if (rtMember != null) { // 로그인 성공 시
			System.out.println("rtMember ID: " + rtMember.getMemberId()); // 로그인 성공 메시지 출력
			httpSession.setMaxInactiveInterval(60 * 30); // 세션 만료 시간 설정 (60초 * 30분)
			httpSession.setAttribute("sessSeqXdm", rtMember.getMemberSeq()); // 세션에 회원 시퀀스 저장
			httpSession.setAttribute("sessIdXdm", rtMember.getMemberId()); // 세션에 회원 ID 저장
			httpSession.setAttribute("sessNameXdm", rtMember.getMemberName()); // 세션에 회원 이름 저장

			System.out.println("세션에 저장할 ID: " + rtMember.getMemberId());
			System.out.println("세션의 sessIdXdm: " + httpSession.getAttribute("sessIdXdm")); // 세션에 저장된 ID 출력

			returnMap.put("rt", "success"); // 결과 맵에 "success" 추가
		} else { // 로그인 실패 시
			System.out.println("로그인 실패: " + memberdto.getMemberId()); // 실패 메시지 및 입력한 ID 출력
			returnMap.put("rt", "fail"); // 결과 맵에 "fail" 추가
		}
		return returnMap; // 결과 맵 반환
	}
	// ------------------------------------------------
//	*slack구문
//	@ResponseBody // HTTP 응답 본문을 JSON 형식으로 반환함을 나타냄
//	@RequestMapping(value = "/xdm/v1/member/membersigninXdmProc") // 이 메서드는 "signinXdmProc" URL 요청을 처리함
//	public Map<String, Object> membersigninXdmProc(MemberDto dto, HttpSession httpSession) throws Exception {
//		Map<String, Object> returnMap = new HashMap<String, Object>(); // 결과를 담을 맵 생성
//
//		MemberDto rtMember = service.selectOneId(dto); // 주어진 dto를 기반으로 회원 정보를 조회
//
//		if (rtMember != null) { // 조회된 회원 정보가 존재할 경우
//			// 비밀번호 암호화 로직이 주석 처리됨
//			MemberDto rtMember2 = service.selectOneLogin(dto); // 로그인 정보 확인
//
//			if (rtMember2 != null) { // 로그인 성공 시
//				if (dto.getAutoLogin() == true) { // 자동 로그인 요청이 있을 경우
//					// 쿠키 생성
//					UtilCookie.createCookie(Constants.COOKIE_SEQ_NAME_XDM, // 쿠키 이름
//							rtMember2.getIfmmSeq(), // 쿠키 값 (회원 시퀀스)
//							Constants.COOKIE_DOMAIN_XDM, // 쿠키 도메인
//							Constants.COOKIE_PATH_XDM, // 쿠키 경로
//							Constants.COOKIE_MAXAGE_XDM); // 쿠키 최대 수명
//				} else {
//					// 자동 로그인 요청이 없으면 아무 작업도 수행하지 않음
//				}
//
//				httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_XDM); // 세션 최대 비활성 시간 설정 (30분)
//				httpSession.setAttribute("sessSeqXdm", rtMember2.getIfmmSeq()); // 세션에 회원 시퀀스 저장
//				httpSession.setAttribute("sessIdXdm", rtMember2.getIfmmId()); // 세션에 회원 ID 저장
//				httpSession.setAttribute("sessNameXdm", rtMember2.getIfmmName()); // 세션에 회원 이름 저장
//
//				rtMember2.setIfmmSocialLoginCd(103); // 소셜 로그인 코드 설정
//				rtMember2.setIflgResultNy(1); // 로그인 성공 플래그 설정
//				service.insertLogLogin(rtMember2); // 로그인 기록 삽입
//
//				returnMap.put("rt", "success"); // 결과 맵에 성공 추가
//			} else {
//				dto.setIfmmSocialLoginCd(103); // 소셜 로그인 코드 설정
//				dto.setIfmmSeq(rtMember.getIfmmSeq()); // 기존 회원 시퀀스 설정
//				dto.setIflgResultNy(0); // 로그인 실패 플래그 설정
//				service.insertLogLogin(dto); // 로그인 기록 삽입
//
//				returnMap.put("rt", "fail"); // 결과 맵에 실패 추가
//			}
//		} else {
//			dto.setIfmmSocialLoginCd(103); // 소셜 로그인 코드 설정
//			dto.setIflgResultNy(0); // 로그인 실패 플래그 설정
//			service.insertLogLogin(dto); // 로그인 기록 삽입
//
//			returnMap.put("rt", "fail"); // 결과 맵에 실패 추가
//		}
//		return returnMap; // 결과 맵 반환
//	}

	// ------------------------------------------------
	// 로그아웃 처리 : 세션 무효화 (역할)
	@ResponseBody
	@RequestMapping(value = "/xdm/v1/infra/member/membersignoutXdmProc")
	public Map<String, Object> membersignoutXdmProc(HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<>(); // 결과를 담을 맵
		httpSession.invalidate(); // 세션 무효화
		System.out.println("Member Session 무효화 성공"); // 콘솔에 로그 출력
		returnMap.put("rt", "success"); // 결과에 성공 추가
		returnMap.put("redirectUrl", "/xdm/v1/infra/member/membersigninXdmForm");
		return returnMap; // 결과 반환
	}

	// 회원가입 요청
	@RequestMapping(value = "/xdm/v1/infra/member/membersignupXdmForm")
	public String membersignupXdmForm() {
		return "/xdm/v1/infra/member/membersignupXdmForm"; // 회원가입 페이지 반환
	}

	// USR 경로
	// index 요청
	@RequestMapping(value = "/xdm/v1/infra/member/memberIndex")
	public String memberIndex() {
		return "/xdm/v1/infra/member/memberIndex"; // 회원가입 페이지 반환
	}

}