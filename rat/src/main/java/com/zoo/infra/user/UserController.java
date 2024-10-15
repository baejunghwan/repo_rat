package com.zoo.infra.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	// 메인화면
	@RequestMapping(value = "/xdm/v1/infra/user/userIndex")
	public String userIndex() {
		return "/xdm/v1/infra/user/userIndex";
	}

	@RequestMapping(value = "/xdm/v1/infra/user/user404")
	public String user404() {
		return "/xdm/v1/infra/user/user404";
	}

	@RequestMapping(value = "/xdm/v1/infra/user/userFaq")
	public String userFaq() {
		return "/xdm/v1/infra/user/userFaq";
	}

	@RequestMapping(value = "/xdm/v1/infra/user/userAbout")
	public String userXdmForm() {
		return "/xdm/v1/infra/user/userAbout";
	}

	@RequestMapping(value = "/xdm/v1/infra/user/userAccount")
	public String userAccount() {
		return "/xdm/v1/infra/user/userAccount";
	}

	@RequestMapping(value = "/xdm/v1/infra/user/userBlogsingleVideo")
	public String userBlogsingleVideo() {
		return "/xdm/v1/infra/user/userBlogsingleVideo";
	}

	// 상품 항목들
	@RequestMapping(value = "/xdm/v1/infra/user/userShopListSidebar")
	public String userShopListSidebar() {
		return "/xdm/v1/infra/user/userShopListSidebar";
	}

	// 자세히 살펴보기 : 댓글기능
	@RequestMapping(value = "/xdm/v1/infra/user/userShopProductDetail")
	public String userShopProductDetail() {
		return "/xdm/v1/infra/user/userShopProductDetail";
	}

	@RequestMapping(value = "/xdm/v1/infra/user/userSignup")
	public String userSignup() {
		return "/xdm/v1/infra/user/userSignup";
	}

	// 장바구니
	@RequestMapping(value = "/xdm/v1/infra/user/userWishlist")
	public String userWishlist() {
		return "/xdm/v1/infra/user/userWishlist";
	}

	// 결제화면
	@RequestMapping(value = "/xdm/v1/infra/user/userCheckout")
	public String userCheckout() {
		return "/xdm/v1/infra/user/userCheckout";
	}

	// 결제완료 (아이콘)
	@RequestMapping(value = "/xdm/v1/infra/user/userOrderCompleted")
	public String userOrderCompleted() {
		return "/xdm/v1/infra/user/userOrderCompleted";
	}

	// Login 화면
	@RequestMapping(value = "/xdm/v1/infra/user/userLogin")
	public String userLogin(HttpSession session) {
//		// 이미 로그인 상태인 경우
//		if (session.getAttribute("sessIdUsr") != null) {
//			return "redirect:/xdm/v1/infra/user/userIndex"; // 로그인 성공 후 이동할 페이지
//		}
		return "/xdm/v1/infra/user/userLogin"; // 로그인 페이지 반환
	}

	// AJAX Login 처리
	@ResponseBody
	@RequestMapping(value = "/xdm/v1/infra/user/userLoginProc")
	public Map<String, Object> userLoginProc(UserDto userdto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();

		// 로그인 요청 로그 추가
		System.out.println("로그인 요청 - ID: " + userdto.getUserId() + ", PW: " + userdto.getUserPw());

		// 로그인 정보를 조회하여 UserDto 객체로 반환
		UserDto rtUser = userService.selectOneLogin(userdto);
		System.out.println("로그인 정보 조회 결과: " + rtUser);

		if (rtUser != null) { // 로그인 성공 시
			System.out.println("rtUser ID: " + rtUser.getUserId()); // 로그인 성공 메시지 출력
			httpSession.setMaxInactiveInterval(60 * 30);
			httpSession.setAttribute("sessSeqUsr", rtUser.getUserSeq());
			httpSession.setAttribute("sessIdUsr", rtUser.getUserId());
			httpSession.setAttribute("sessNameUsr", rtUser.getUserName());

			System.out.println("세션에 저장할 ID: " + rtUser.getUserId());
			System.out.println("세션의 sessIdUsr: " + httpSession.getAttribute("sessIdUsr"));

			returnMap.put("rt", "success");
		} else { // 로그인 실패 시
			System.out.println("로그인 실패: " + userdto.getUserId());
			returnMap.put("rt", "fail");
		}
		return returnMap;
	}

	// 로그아웃 처리 : 세션 무효화 (역할)
	@ResponseBody
	@RequestMapping(value = "/xdm/v1/infra/user/userLogoutProc")
	public Map<String, Object> userLogoutProc(HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>(); // 결과를 담을 맵
		httpSession.invalidate(); // 세션 무효화
		System.out.println("User Session 무효화 성공"); // 콘솔에 로그 출력
		returnMap.put("rt", "success"); // 결과에 성공 추가
//		returnMap.put("redirectUrl", "/xdm/v1/infra/user/userLogin");
		return returnMap; // 결과 반환
	}

	// userBlogsidebar 나중에 추가하기
}