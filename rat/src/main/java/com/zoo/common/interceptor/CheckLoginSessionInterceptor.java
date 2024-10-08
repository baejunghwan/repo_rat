package com.zoo.common.interceptor;

// Spring의 HandlerInterceptor 인터페이스를 임포트
import org.springframework.web.servlet.HandlerInterceptor;

// 상수 정의를 위한 임포트
import com.zoo.common.constants.Constants;

// HTTP 요청 및 응답 객체를 위한 임포트
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// CheckLoginSessionInterceptor 클래스 정의
public class CheckLoginSessionInterceptor implements HandlerInterceptor {

	// 요청 처리 전 호출되는 preHandle 메서드 오버라이드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// preHandle 메서드가 호출되었음을 콘솔에 출력
		System.out.println("preHandle : ");

		// 세션에서 로그인 여부 확인
		if (request.getSession().getAttribute("sessSeqXdm") != null) {
			// 로그인된 상태일 경우, 요청을 계속 처리
		} else {
			// 로그인되지 않은 상태일 경우, 로그인 페이지로 리다이렉트
			response.sendRedirect(Constants.URL_LOGINFORM);
			// 요청 처리를 중단하고 false 반환
			return false;
		}

		// 기본 동작을 수행하고 요청 처리를 계속 진행
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
