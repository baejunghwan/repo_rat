package com.zoo.common.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 세션의 상태에 따라 요청을 처리하거나 로그인 페이지로 리다이렉트.
// 요청을 가로채 세션상태 확인, 로그인 여부에 따라 요청 처리,중단 결정 용도  > 세션조건-어디로 보낸다 결정용도
public class CheckLoginSessionInterceptor implements HandlerInterceptor {

	// 요청 처리 전 호출되는 preHandle 메서드 오버라이드
	@Override // 인터셉터는 모든 요청을 가로채고, 세션의 상태를 확인
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {


//		 세션에서 로그인 여부 확인
//		if (request.getSession().getAttribute("sessIdXdm") != null) {
//			// 로그인된 상태일 경우, 요청을 계속 처리
//			System.out.println("현재 세션 ID: " + request.getSession().getId());
//			System.out.println("세션의 sessIdXdm: " + request.getSession().getAttribute("sessIdXdm"));
//			System.out.println("세션 로그인o : 요청 계속 처리");
//		} else {
//			// 로그인되지 않은 상태일 경우, 상수에 정의된 로그인 페이지로 리다이렉트
//			response.sendRedirect(Constants.URL_LOGINFORM);
//			// 요청 처리를 중단하고 false 반환
//			System.out.println("세션 로그인x : 요청 처리 중단");
//			return false;
//		}

		// 인터셉터가 특별한 동작을 하지 않을 때, Spring의 기본 요청 처리 로직을 계속 따르도록 하는 역할
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}