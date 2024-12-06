package com.zoo.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.zoo.common.interceptor.CheckLoginSessionInterceptor;

// Spring의 설정 클래스로 지정, 웹 MVC 설정을 정의.
@Configuration // Spring이 이 클래스를 설정 클래스로 인식.
public class WebMvcConfigurerImpl implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		// 이 인터셉터는 요청을 처리하기 전에 세션을 확인하는 역할을 합니다.
		registry.addInterceptor(new CheckLoginSessionInterceptor()).order(1) // 인터셉터의 실행 순서를 설정합니다. (낮은 숫자일수록 먼저 실행됨)

		// 인터셉터가 작동할 URL 경로를 지정합니다.
//				.addPathPatterns("/xdm/v1/infra/member/**") // 이 경로 아래의 모든 요청에 대해 인터셉터가 작동합니다.
//				.addPathPatterns("/xdm/v1/infra/user/**") // 이 경로 아래의 모든 요청에 대해 인터셉터가 작동합니다.

				// 인터셉터의 적용에서 제외할 URL 경로를 지정합니다.
				.excludePathPatterns(
						"/resources/**", // css,js는 세션검사를 할 필요가 없으니까 설정
						"/xdm/v1/infra/member/membersigninXdmForm", // 세션이 없다면 로그인을 시도해야 하므로 제외.
						"/xdm/v1/infra/member/membersigninXdmProc", // 로그인 처리 후, 세션이 생성되기 때문에 제외.
						"/xdm/v1/infra/member/membersignupXdmForm", 
						"/xdm/v1/infra/member/membersignupXdmProc", 
						"/xdm/v1/infra/user/userLogin",
						"/xdm/v1/infra/user/userLoginProc"
						);
	}
}