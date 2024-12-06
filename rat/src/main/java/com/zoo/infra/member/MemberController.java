package com.zoo.infra.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zoo.infra.mail.MailService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;

	@Autowired
	MailService mailService;

	// Spring Hash (Controller)
	public String encodeBcrypt(String planeText, int strength) {
		return new BCryptPasswordEncoder(strength).encode(planeText);
	}

	public boolean matchesBcrypt(String planeText, String hashValue, int strength) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(strength);
		return passwordEncoder.matches(planeText, hashValue);
	}

	@RequestMapping(value = "/xdm/v1/infra/member/memberXdmList")
	public String memberXdmList(@ModelAttribute("vo") MemberVo vo, Model model) throws Exception {
		List<MemberDto> memberSeq = memberService.selectList(vo);
		for (MemberDto memberDto : memberSeq) {
			System.out.println("memberDto.getMemberSeq(): " + memberDto.getMemberSeq()); 
		}

		model.addAttribute("list", memberService.selectList(vo));
		vo.setParamsPaging(memberService.selectOneCount(vo));

		return "xdm/v1/infra/member/memberXdmList";
	}

	@RequestMapping(value = "/xdm/v1/infra/member/memberXdmForm")
	public String memberXdmForm() {
		return "xdm/v1/infra/member/memberXdmForm";
	}

	@RequestMapping(value = "/xdm/v1/infra/member/memberXdmMfom")
	public String memberXdmMfom(MemberDto memberDto, Model model) {
		model.addAttribute("item", memberService.selectOne(memberDto)); 
		System.out.println("memberMfom Gender : " + memberService.selectOne(memberDto).getMemberGender()); // 성별 출력
		return "xdm/v1/infra/member/memberXdmMfom"; 
	}

	@RequestMapping(value = "/xdm/v1/infra/member/memberXdmInst")
	public String memberXdmInst(MemberDto memberDto) {

		System.out.println("memberDto.getMemberName(): " + memberDto.getMemberName()); 
		int a = memberService.insert(memberDto); 
		System.out.println("memberService.insert(memberDto): " + a); 
		return "redirect:/xdm/v1/infra/member/memberXdmList"; 
	}

	@RequestMapping(value = "/xdm/v1/infra/member/memberXdmUpdate")
	public String memberXdmUpdate(MemberDto memberDto) {
		System.out.println("memberDto.getMemberSeq(): " + memberDto.getMemberSeq()); 
		int b = memberService.update(memberDto); 
		System.out.println("memberService.update(memberDto): " + b); 
		return "redirect:/xdm/v1/infra/member/memberXdmList"; 
	}

	@RequestMapping(value = "/xdm/v1/infra/member/memberXdmDelete")
	public String memberXdmDelete(MemberDto memberDto) {
		System.out.println("memberDto.getMemberSeq(): " + memberDto.getMemberSeq()); 
		int c = memberService.delete(memberDto); 
		System.out.println("memberService.delete(memberDto): " + c); 
		return "redirect:/xdm/v1/infra/member/memberXdmList"; 
	}

	@RequestMapping(value = "/xdm/v1/infra/member/memberXdmUelete")
	public String memberXdmUelete(MemberDto memberDto) {
		System.out.println("memberDto.getMemberSeq(): " + memberDto.getMemberSeq()); 
		int d = memberService.uelete(memberDto); 
		System.out.println("memberService.uelete(memberDto): " + d); 
		return "redirect:/xdm/v1/infra/member/memberXdmList"; 
	}

	@RequestMapping(value = "/xdm/v1/infra/member/membersigninXdmForm")
	public String membersigninXdmForm() {
		return "xdm/v1/infra/member/membersigninXdmForm"; 
	}

	// AJAX 로그인 처리
	@ResponseBody // 이 메서드의 반환값이 HTTP 응답 본문으로 직접 사용됨을 나타냄
	@RequestMapping(value = "/xdm/v1/infra/member/membersigninProc") 
	public Map<String, Object> membersigninProc(MemberDto memberdto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>(); 

		System.out.println("로그인 요청 - ID: " + memberdto.getMemberId() + ", PW: " + memberdto.getMemberPw());

		MemberDto rtMember = memberService.selectOneLogin(memberdto); 
		System.out.println("로그인 정보 조회 결과: " + rtMember);

		// 로그인 성공 시
		if (rtMember != null) {
			System.out.println("rtMember ID: " + rtMember.getMemberId()); 
			httpSession.setMaxInactiveInterval(60 * 30); // 세션 만료 시간 설정 (60초 * 30분)
			httpSession.setAttribute("sessSeqXdm", rtMember.getMemberSeq()); 
			httpSession.setAttribute("sessIdXdm", rtMember.getMemberId()); // 세션에 회원 ID 저장
			httpSession.setAttribute("sessNameXdm", rtMember.getMemberName()); 

			// Spring Hash (로그인시)
			if (matchesBcrypt(memberdto.getMemberPw(), rtMember.getMemberPw(), 10))

				System.out.println("세션에 저장할 ID: " + rtMember.getMemberId());
			System.out.println("세션의 sessIdXdm: " + httpSession.getAttribute("sessIdXdm")); // 세션에 저장된 ID 출력

			returnMap.put("rt", "success"); 
		} else { 
			System.out.println("로그인 실패: " + memberdto.getMemberId()); 
			returnMap.put("rt", "fail"); 
		}
		return returnMap; 
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
	@ResponseBody // HTTP 응답 본문을 JSON 형식으로 반환함을 나타냄
	@RequestMapping(value = "/xdm/v1/infra/member/membersignoutXdmProc")
	public Map<String, Object> membersignoutXdmProc(HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<>();
		httpSession.invalidate(); 
		System.out.println("Member Session 무효화 성공");
		returnMap.put("rt", "success"); 
		returnMap.put("redirectUrl", "xdm/v1/infra/member/membersigninXdmForm");
		return returnMap; 
	}

	@RequestMapping(value = "/xdm/v1/infra/member/membersignupXdmForm")
	public String membersignupXdmForm() {
		return "xdm/v1/infra/member/membersignupXdmForm";
	}

	@RequestMapping(value = "/xdm/v1/infra/member/membersignupXdmProc")
	public String membersignupXdmProc(MemberDto memberDto, HttpSession httpSession) {

		// spring Hash (회원가입시)
		memberDto.setMemberPw(encodeBcrypt(memberDto.getMemberPw(), 10));
		return "xdm/v1/infra/member/membersignupXdmProc";
	}

	@RequestMapping(value = "/xdm/v1/infra/member/memberIndex")
	public String memberIndex() {
		return "xdm/v1/infra/member/memberIndex";
	}
}