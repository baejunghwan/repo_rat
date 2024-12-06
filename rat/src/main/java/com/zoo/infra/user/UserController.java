package com.zoo.infra.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zoo.infra.code.CodeService;
import com.zoo.infra.product.ProductDto;
import com.zoo.infra.product.ProductService;
import com.zoo.infra.product.ProductVo;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	@Autowired
	CodeService codeService;

	@Autowired
	ProductService productService;

	// Spring Hash
	public String encodeBcrypt(String planeText, int strength) {
		return new BCryptPasswordEncoder(strength).encode(planeText);
	}

	public boolean matchesBcrypt(String planeText, String hashValue, int strength) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(strength);
		return passwordEncoder.matches(planeText, hashValue);
	}

	@RequestMapping(value = "/xdm/v1/infra/user/user404")
	public String user404() {
		return "xdm/v1/infra/user/user404";
	}

	@RequestMapping(value = "/xdm/v1/infra/user/userIndex")
	public String userIndex() {
		return "xdm/v1/infra/user/userIndex";
	}	

	@RequestMapping(value = "/xdm/v1/infra/user/userFaq")
	public String userFaq() {
		return "xdm/v1/infra/user/userFaq";
	}

	@RequestMapping(value = "/xdm/v1/infra/user/userAbout")
	public String userXdmForm() {
		return "xdm/v1/infra/user/userAbout";
	}

	@RequestMapping(value = "/xdm/v1/infra/user/userAccount")
	public String userAccount() {
		return "xdm/v1/infra/user/userAccount";
	}

	@RequestMapping(value = "/xdm/v1/infra/user/userBlogsingleVideo")
	public String userBlogsingleVideo(Model model) {

		return "xdm/v1/infra/user/userBlogsingleVideo";
	}

	@RequestMapping(value = "/xdm/v1/infra/user/userShopListSidebar")
	public String userShopListSidebar(Model model, ProductVo productVo) {
//	    List<UserDto> userList = userService.getUserShopList(userVo);

//		pdSeq가 null 인지 확인
//		if (productService.selectList(productVo) == null) {
//			System.out.println("pdSeq is null. ProductVo: " + productService.selectList(productVo));
//		} else {
//		}
		// 반환된 객체 리스트의 get(0) = 첫번째를 가져온다는 의미 (리스트는 0부터 시작) > 여기서 .get_ 메서드 사용의미
		System.out.println("getPdName : " + productService.selectList(productVo).get(0).getPdName());
		System.out.println("getPdMeida : " + productService.selectList(productVo).get(0).getPdMedia());
		System.out.println("getPdTerm : " + productService.selectList(productVo).get(0).getPdTerm());
//		System.out.println("selectOne.getPdMedia : " + productService.selectOne(productVo).getPdMedia());
		model.addAttribute("list", productService.selectList(productVo));
//		model.addAttribute("item", productService.selectOne(productVo));
		return "xdm/v1/infra/user/userShopListSidebar";
	}

	@RequestMapping(value = "/xdm/v1/infra/user/userShopProductDetail")
	public String userShopProductDetail(Model model, ProductDto productDto, ProductVo ProductVo, HttpSession httpSession) throws Exception {

//		System.out.println("selectList.getPdName : " + productService.selectList(productVo).get(0).getPdName());
//		System.out.println("selectList.getPdSeq : " + productService.selectList(productVo).get(0).getPdSeq());
//		System.out.println("selectOne.getPdName : " + productSe	rvice.selectOne(productDto).getPdName());
//		System.out.println("selectOne.getPdSeq : " + productService.selectOne(productDto).getPdSeq());
		
//		int reviewCount = productService.selectListReviewCount(productDto);
//		System.out.println("reviewCount : " + reviewCount);
		
//		int totalCount = productService.selectOneCount(productVo);
//		model.addAttribute("reviewCount", productService.selectListReview(productDto));
//		System.out.println("totalCount: " + totalCount);
//		System.out.println("리뷰 count : " + productService.selectListReview(productDto));
		
//		int reviewCount = productService.selectListReviewCount(productDto);
//		model.addAttribute("reveiwCount", productService.selectListReviewCount(productDto));
//		System.out.println("reviewCount : " + reviewCount);
		
//		System.out.println(" productService.selectOne(productDto): " + productService.selectOne(productDto));
//		System.out.println("item / productService.selectOne(productDto) pdRating: " + productService.selectOne(productDto).getPdRating());
//		System.out.println("가격 - 원가 : " + productService.selectOne(productDto).getPdPrice());
//		System.out.println("가격 - 할인율 : " + productService.selectOne(productDto).getPdPriceDcRate());
//		System.out.println("별점 : " + productService.selectOne(productDto).getPdRating());
	
//		int reviewCount = productService.selectListReviewCount(productDto); 
//		model.addAttribute("reviewCount", reviewCount); 
//		System.out.println("reviewCount : " + reviewCount); 
		
//		List<ProductDto> reviewCount = productService.selectListReviewCount(productDto);
//		model.addAttribute("reviewCount", reviewCount);
//		System.out.println("reviewCount : " + productService.selectListReviewCount(productDto));
		
		model.addAttribute("list", productService.selectList(ProductVo));
		model.addAttribute("item", productService.selectOne(productDto));
		model.addAttribute("review", productService.selectListReview(productDto));
		System.out.println("상품 별점% : " + productService.selectOne(productDto).getPdRating());
		
		model.addAttribute("reviewCount", productService.selectListReviewCount(productDto));
		System.out.println("reviewCount : " + productService.selectListReviewCount(productDto));
//		model.addAttribute("reviewCount", productService.selectListReviewCount(productVo));
//		System.out.println("리뷰Count : " + productService.selectListReviewCount(productVo));
		
//		System.out.println( "vo : " + ToStringBuilder.reflectionToString(xReviewCount));
		
//		model.addAttribute("reviewCount", productService.selectListReviewCount(productVo));
//		System.out.println("reviewCount : " + productService.selectListReviewCount(productVo));
	
		return "xdm/v1/infra/user/userShopProductDetail";
	}
	
	@RequestMapping(value = "/xdm/v1/infra/user/userSignup")
	public String userSignup() {
		return "xdm/v1/infra/user/userSignup";
	}

	@RequestMapping(value = "/xdm/v1/infra/user/userWishlist")
	public String userWishlist(ProductVo vo, Model model) {
		
		model.addAttribute("list", productService.selectList(vo));
		return "xdm/v1/infra/user/userWishlist";
	}

	@RequestMapping(value = "/xdm/v1/infra/user/userCheckout")
	public String userCheckout() {
		return "xdm/v1/infra/user/userCheckout";
	}

	@RequestMapping(value = "/xdm/v1/infra/user/userOrderCompleted")
	public String userOrderCompleted() {
		return "xdm/v1/infra/user/userOrderCompleted";
	}

	// Login 화면
	@RequestMapping(value = "/xdm/v1/infra/user/userLogin")
	public String userLogin(HttpSession session) {
//		// 이미 로그인 상태인 경우
//		if (session.getAttribute("sessIdUsr") != null) {
//			return "redirect:/xdm/v1/infra/user/userIndex"; // 로그인 성공 후 이동할 페이지
//		}
		return "xdm/v1/infra/user/userLogin"; // 로그인 페이지 반환
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
			// Spring Hash
			if (matchesBcrypt(userdto.getUserPw(), rtUser.getUserPw(), 10)) {

				System.out.println("rtUser ID: " + rtUser.getUserId()); // 로그인 성공 메시지 출력
				httpSession.setMaxInactiveInterval(60 * 30);
				httpSession.setAttribute("sessSeqUsr", rtUser.getUserSeq());
				httpSession.setAttribute("sessIdUsr", rtUser.getUserId());
				httpSession.setAttribute("sessNameUsr", rtUser.getUserName());

				System.out.println("세션에 저장할 ID: " + rtUser.getUserId());
				System.out.println("세션의 sessIdUsr: " + httpSession.getAttribute("sessIdUsr"));
				returnMap.put("rt", "success");
			} else {
				System.out.println("로그인 실패: " + userdto.getUserId());
				returnMap.put("rt", "fail");
			}
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